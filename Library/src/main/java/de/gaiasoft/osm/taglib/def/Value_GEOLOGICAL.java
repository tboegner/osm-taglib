package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_GEOLOGICAL implements ValueBase {
    VOLCANIC_VENT("volcanic_vent"),
    PALAEONTOLOGICAL_SITE("palaeontological_site"),
    VOLCANIC_CALDERA_RIM("volcanic_caldera_rim"),
    OUTCROP("outcrop"),
    VOLCANIC_LAVA_FIELD("volcanic_lava_field"),
    FAULT("fault"),
    MORAINE("moraine"),
    ;

    private String value;
    Value_GEOLOGICAL(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
