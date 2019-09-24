package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_GEOLOGICAL implements ValueBase {
    PALAEONTOLOGICAL_SITE("palaeontological_site"),
    VOLCANIC_VENT("volcanic_vent"),
    VOLCANIC_CALDERA_RIM("volcanic_caldera_rim"),
    OUTCROP("outcrop"),
    VOLCANIC_FUMAROLE("volcanic_fumarole"),
    VOLCANIC_GEYSER("volcanic_geyser"),
    MORAINE("moraine"),
    VOLCANIC_LAVA_TUBE("volcanic_lava_tube"),
    VOLCANIC_LAVA_CHANNEL("volcanic_lava_channel"),
    ;

    private String value;
    Value_GEOLOGICAL(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
