package de.gaiasoft.osm.taglib.support;


import de.gaiasoft.osm.taglib.base.KeyBase;
import de.gaiasoft.osm.taglib.base.ValueBase;
import de.gaiasoft.osm.taglib.def.Key;

import java.util.HashMap;
import java.util.Map;

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


    public static TagHandler getInstance() {
        if(instance == null) {
            instance = new TagHandler();
        }
        return instance;
    }

    public KeyInfo findKey(String key) {
        return keyCache.get(key);
    }

    // TODO: Exception, if key not exists?
    public boolean hasKeyLimitedValues(String key) {
        KeyInfo keyInfo = findKey(key);
        return keyInfo != null && keyInfo.valueEnum != null;
    }

    public ValueBase findValidValueForKey(String key, String value) {
        KeyInfo keyInfo = findKey(key);
        if(keyInfo != null && keyInfo.valueEnum != null) {
            ValueBase[] values = keyInfo.valueEnum.getEnumConstants();
            for(ValueBase validValue : values) {
                if(validValue.getValue().equals(value)) {
                    return validValue;
                }
            }
        }
        return null;
    }

    // TODO: Exception, if values are not limited
    public boolean isValueValidForKey(String key, String value) {
        return findValidValueForKey(key, value) != null;
    }
}
