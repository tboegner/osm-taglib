package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_HISTORIC implements ValueBase {
    ROMAN_ROAD("roman_road"),
    MINE_SHAFT("mine_shaft"),
    CASTLE("castle"),
    CITYWALLS("citywalls"),
    CANNON("cannon"),
    CHARCOAL_PILE("charcoal_pile"),
    HIGHWATER_MARK("highwater_mark"),
    PALEONTOLOGICAL_SITE("paleontological_site"),
    SHIP("ship"),
    TREE_SHRINE("tree_shrine"),
    BUILDING("building"),
    CITY_WALL("city_wall"),
    ARTIFACT("artifact"),
    MANOR("manor"),
    WRECK("wreck"),
    CITY_GATE("city_gate"),
    PILLORY("pillory"),
    LOCOMOTIVE("locomotive"),
    BOUNDARY_STONE("boundary_stone"),
    FARM("farm"),
    RUNE_STONE("rune_stone"),
    OPTICAL_TELEGRAPH("optical_telegraph"),
    ABANDONED("abandoned"),
    TOWER("tower"),
    WAYSIDE_SHRINE("wayside_shrine"),
    HERITAGE("heritage"),
    RAILWAY_CAR("railway_car"),
    RUINS("ruins"),
    SHIELING("shieling"),
    GALLOWS("gallows"),
    ARCHAEOLOGICAL_SITE("archaeological_site"),
    BOMB_CRATER("bomb_crater"),
    FLOOD_MARK("flood_mark"),
    CASTLE_WALL("castle_wall"),
    CHURCH("church"),
    MONUMENT("monument"),
    RAMPART("rampart"),
    AQUEDUCT("aqueduct"),
    MEMORIAL("memorial"),
    EVENT("event"),
    TANK("tank"),
    MINE("mine"),
    TOMB("tomb"),
    YES("yes"),
    AIRCRAFT("aircraft"),
    WAYSIDE_CROSS("wayside_cross"),
    EPIGRAPH("epigraph"),
    STONE("stone"),
    PA("pa"),
    MONASTERY("monastery"),
    MILESTONE("milestone"),
    BATTLEFIELD("battlefield"),
    FORT("fort"),
    ;

    private String value;
    Value_HISTORIC(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
