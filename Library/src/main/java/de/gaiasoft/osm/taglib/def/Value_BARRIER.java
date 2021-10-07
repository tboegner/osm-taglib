package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_BARRIER implements ValueBase {
    LOG("log"),
    DITCH("ditch"),
    KISSING_GATE("kissing_gate"),
    HEDGE("hedge"),
    JERSEY_BARRIER("jersey_barrier"),
    CITY_WALL("city_wall"),
    BOLLARD("bollard"),
    DEBRIS("debris"),
    BLOCK("block"),
    CATTLE_GRID("cattle_grid"),
    ENTRANCE("entrance"),
    CYCLE_BARRIER("cycle_barrier"),
    HAMPSHIRE_GATE("hampshire_gate"),
    SALLY_PORT("sally_port"),
    CHAIN("chain"),
    HANDRAIL("handrail"),
    YES("yes"),
    SLIDING_GATE("sliding_gate"),
    SWING_GATE("swing_gate"),
    BORDER_CONTROL("border_control"),
    STILE("stile"),
    LIFT_GATE("lift_gate"),
    GUARD_RAIL("guard_rail"),
    RETAINING_WALL("retaining_wall"),
    TURNSTILE("turnstile"),
    KERB("kerb"),
    HEDGE_BANK("hedge_bank"),
    HEIGHT_RESTRICTOR("height_restrictor"),
    TOLL_BOOTH("toll_booth"),
    AVALANCHE_PROTECTION("avalanche_protection"),
    GATE("gate"),
    FENCE("fence"),
    WALL("wall"),
    ;

    private String value;
    Value_BARRIER(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
