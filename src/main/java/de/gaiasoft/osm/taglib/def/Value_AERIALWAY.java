package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_AERIALWAY implements ValueBase {
    CABLE_CAR("cable_car"),
    PLATTER("platter"),
    PYLON("pylon"),
    MIXED_LIFT("mixed_lift"),
    GOODS("goods"),
    CHAIR_LIFT("chair_lift"),
    GONDOLA("gondola"),
    CANOPY("canopy"),
    MAGIC_CARPET("magic_carpet"),
    DRAG_LIFT("drag_lift"),
    STATION("station"),
    ROPE_TOW("rope_tow"),
    ZIP_LINE("zip_line"),
    ;

    private String value;
    Value_AERIALWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
