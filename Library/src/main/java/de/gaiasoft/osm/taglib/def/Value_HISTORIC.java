package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_HISTORIC implements ValueBase {
    ARCHAEOLOGICAL_SITE("archaeological_site"),
    MINE_SHAFT("mine_shaft"),
    BOMB_CRATER("bomb_crater"),
    CASTLE("castle"),
    CITYWALLS("citywalls"),
    CASTLE_WALL("castle_wall"),
    CHARCOAL_PILE("charcoal_pile"),
    CHURCH("church"),
    CANNON("cannon"),
    HIGHWATER_MARK("highwater_mark"),
    SHIP("ship"),
    MONUMENT("monument"),
    TREE_SHRINE("tree_shrine"),
    HOUSE("house"),
    BUILDING("building"),
    MANOR("manor"),
    WRECK("wreck"),
    CITY_GATE("city_gate"),
    AQUEDUCT("aqueduct"),
    PILLORY("pillory"),
    LOCOMOTIVE("locomotive"),
    BOUNDARY_STONE("boundary_stone"),
    FARM("farm"),
    RUNE_STONE("rune_stone"),
    MEMORIAL("memorial"),
    TANK("tank"),
    CEMETERY("cemetery"),
    TOWER("tower"),
    MINE("mine"),
    WAYSIDE_SHRINE("wayside_shrine"),
    YES("yes"),
    TOMB("tomb"),
    AIRCRAFT("aircraft"),
    WAYSIDE_CROSS("wayside_cross"),
    HERITAGE("heritage"),
    STONE("stone"),
    RAILWAY_CAR("railway_car"),
    PA("pa"),
    MONASTERY("monastery"),
    MILESTONE("milestone"),
    RUINS("ruins"),
    BATTLEFIELD("battlefield"),
    DISTRICT("district"),
    SHIELING("shieling"),
    FORT("fort"),
    ;

    private String value;
    Value_HISTORIC(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
