package de.gaiasoft.osm.taglib.support;

import de.gaiasoft.osm.taglib.base.ValueBase;
import de.gaiasoft.osm.taglib.def.Key;

public class KeyInfo {
    public Key key;
    public Class<? extends ValueBase> valueEnum;

    public KeyInfo(Key key, Class<? extends ValueBase> valueEnum) {
        this.key = key;
        this.valueEnum = valueEnum;
    }
}
