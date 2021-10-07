package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
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
    DANGER_AREA("danger_area"),
    BASE("base"),
    ;

    private String value;
    Value_MILITARY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
