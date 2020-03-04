package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_AERIALWAY implements ValueBase {
    PYLON("pylon"),
    PLATTER("platter"),
    CABLE_CAR("cable_car"),
    MAGIC_CARPET("magic_carpet"),
    MIXED_LIFT("mixed_lift"),
    STATION("station"),
    DRAG_LIFT("drag_lift"),
    GOODS("goods"),
    ROPE_TOW("rope_tow"),
    ZIP_LINE("zip_line"),
    CHAIR_LIFT("chair_lift"),
    GONDOLA("gondola"),
    ;

    private String value;
    Value_AERIALWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
