package de.gaiasoft.osm.taglib.support;


import de.gaiasoft.osm.taglib.base.KeyBase;
import de.gaiasoft.osm.taglib.base.ValueBase;
import de.gaiasoft.osm.taglib.def.Key;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton helper handling known keys and values from OSM-tags. Provides finder methods which return
 * results as enum-values.
 */
public class TagHandler {
    private static TagHandler instance = null;
    private Map<String, KeyInfo> keyCache = new HashMap<>();

    private TagHandler() {
        for(Key keyItem : Key.values()) {
            cacheKeyInfo(keyItem);
        }
    }

    private void cacheKeyInfo(Key keyItem) {
        Class<? extends ValueBase> valueEnum;
        try {
            valueEnum = Class.forName("de.gaiasoft.osm.taglib.def.Value_" + keyItem.getKey().toUpperCase())
                    .asSubclass(ValueBase.class);
        } catch (ClassNotFoundException e) {
            valueEnum = null;
        }
        keyCache.put(keyItem.getKey(), new KeyInfo(keyItem, valueEnum));
    }


    /**
     * Singleton instance creator.
     * @return Singleton TagHandler instance.
     */
    public static TagHandler getInstance() {
        if(instance == null) {
            instance = new TagHandler();
        }
        return instance;
    }

    /**
     * Finder for supported OSM-Keys
     * @param key Key of OSM-Tag.
     * @return KeyInfo-Structure for supported key, otherwise null.
     */
    public KeyInfo findKey(String key) {
        return keyCache.get(key);
    }

    /**
     * Checker for known/limited values existing for a key.
     * @param key Key of OSM-Tag.
     * @return True, if key can have free values. False, if key unknown or it can not have free values.
     */
    public boolean isKeySupportingFreeValues(String key) {
        KeyInfo keyInfo = findKey(key);
        return keyInfo != null && keyInfo.valueEnum == null;
    }

    /**
     * Finder for supported/known values of a OSM-Key.
     * @param key Key of OSM-Tag.
     * @param value Value of OSM-Tag.
     * @return Instance of (Enum-)Value, if value is known for key. Null if key is not supported
     * or value is not known for key.
     */
    public ValueBase findValidValueForKey(String key, String value) {
        Tag tag = buildTag(key, value);
        if(tag != null) {
            return tag.getValue();
        }
        return null;
    }

    /**
     * Convenience method for building a tag from strings.
     * @param keyAsString Key as string.
     * @param valueAsString Value as string.
     * @return Tag instance for valid/known key-value pair. Null otherwise.
     */
    public Tag buildTag(String keyAsString, String valueAsString) {
        KeyInfo keyInfo = findKey(keyAsString);
        if(keyInfo != null && keyInfo.valueEnum != null) {
            ValueBase[] values = keyInfo.valueEnum.getEnumConstants();
            for(ValueBase validValue : values) {
                if(validValue.getValue().equals(valueAsString)) {
                    return new Tag(keyInfo.key, validValue);
                }
            }
        }
        return null;
    }

    /**
     * Convenience method for building a tag with value.
     * @param key Key instance.
     * @param valueAsString Value as string.
     * @return Tag instance for valid/known key-value pair. Null otherwise.
     */
    public Tag buildTag(KeyBase key, String valueAsString) {
        return buildTag(key.getKey(), valueAsString);
    }

}
