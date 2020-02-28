package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

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
