package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_MILITARY implements ValueBase {
    CHECKPOINT("checkpoint"),
    AMMUNITION("ammunition"),
    BUNKER("bunker"),
    LAUNCHPAD("launchpad"),
    TRENCH("trench"),
    BARRACKS("barracks"),
    NUCLEAR_EXPLOSION_SITE("nuclear_explosion_site"),
    AIRFIELD("airfield"),
    RANGE("range"),
    OFFICE("office"),
    TRAINING_AREA("training_area"),
    OBSTACLE_COURSE("obstacle_course"),
    NAVAL_BASE("naval_base"),
    DANGER_AREA("danger_area"),
    ;

    private String value;
    Value_MILITARY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
