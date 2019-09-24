package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_BARRIER implements ValueBase {
    KENT_CARRIAGE_GATE("kent_carriage_gate"),
    CABLE_BARRIER("cable_barrier"),
    HAHA("haha"),
    DITCH("ditch"),
    KISSING_GATE("kissing_gate"),
    CURB("curb"),
    JERSEY_BARRIER("jersey_barrier"),
    MOTORCYCLE_BARRIER("motorcycle_barrier"),
    CITY_WALL("city_wall"),
    BUS_TRAP("bus_trap"),
    BOLLARD("bollard"),
    BUMP_GATE("bump_gate"),
    DEBRIS("debris"),
    BLOCK("block"),
    EMBANKMENT("embankment"),
    CATTLE_GRID("cattle_grid"),
    ENTRANCE("entrance"),
    CYCLE_BARRIER("cycle_barrier"),
    HAMPSHIRE_GATE("hampshire_gate"),
    SALLY_PORT("sally_port"),
    HANDRAIL("handrail"),
    BORDER_CONTROL("border_control"),
    SWING_GATE("swing_gate"),
    TREE("tree"),
    HORSE_JUMP("horse_jump"),
    STILE("stile"),
    TANK_TRAP("tank_trap"),
    GUARD_RAIL("guard_rail"),
    LIFT_GATE("lift_gate"),
    RETAINING_WALL("retaining_wall"),
    SPIKES("spikes"),
    KERB("kerb"),
    HEDGE_BANK("hedge_bank"),
    HEIGHT_RESTRICTOR("height_restrictor"),
    CZECH_HEDGEHOG("czech_hedgehog"),
    LOG("log"),
    ROPE("rope"),
    HEDGE("hedge"),
    CHICANE("chicane"),
    WIRE_FENCE("wire_fence"),
    WICKET_GATE("wicket_gate"),
    WOOD_FENCE("wood_fence"),
    SUMP_BUSTER("sump_buster"),
    SELECT_ACCES("select_acces"),
    CHAIN("chain"),
    HORSE_STILE("horse_stile"),
    CHECH_HEDGEHOG("chech_hedgehog"),
    YES("yes"),
    TURNSTILE("turnstile"),
    KENT_CARRIAGE_GAP("kent_carriage_gap"),
    TOLL_BOOTH("toll_booth"),
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
