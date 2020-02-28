package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_GEOLOGICAL implements ValueBase {
    VOLCANIC_VENT("volcanic_vent"),
    PALAEONTOLOGICAL_SITE("palaeontological_site"),
    VOLCANIC_CALDERA_RIM("volcanic_caldera_rim"),
    OUTCROP("outcrop"),
    MORAINE("moraine"),
    ;

    private String value;
    Value_GEOLOGICAL(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
