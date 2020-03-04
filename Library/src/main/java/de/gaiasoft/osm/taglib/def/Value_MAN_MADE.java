package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_MAN_MADE implements ValueBase {
    DYKE("dyke"),
    ANTENNA("antenna"),
    FLARE("flare"),
    BREAKWATER("breakwater"),
    GOODS_CONVEYOR("goods_conveyor"),
    SNOW_FENCE("snow_fence"),
    WATER_WORKS("water_works"),
    MONITORING_STATION("monitoring_station"),
    PUMPING_RIG("pumping_rig"),
    CAMPANILE("campanile"),
    EMBANKMENT("embankment"),
    STREET_CABINET("street_cabinet"),
    FLAGPOLE("flagpole"),
    WATER_WELL("water_well"),
    TOWER("tower"),
    SPOIL_HEAP("spoil_heap"),
    CRANE("crane"),
    DOLPHIN("dolphin"),
    ADIT("adit"),
    WINDMILL("windmill"),
    PETROLEUM_WELL("petroleum_well"),
    BUNKER_SILO("bunker_silo"),
    CHILLER("chiller"),
    GROYNE("groyne"),
    BEACON("beacon"),
    PILLAR("pillar"),
    SNOW_CANNON("snow_cannon"),
    DOVECOTE("dovecote"),
    RESERVOIR_COVERED("reservoir_covered"),
    WATER_TAP("water_tap"),
    BRIDGE("bridge"),
    TELESCOPE("telescope"),
    COOLING_TOWER("cooling_tower"),
    COMMUNICATIONS_TOWER("communications_tower"),
    CHIMNEY("chimney"),
    WORKS("works"),
    LIGHTHOUSE("lighthouse"),
    MAST("mast"),
    UTILITY_POLE("utility_pole"),
    MINESHAFT("mineshaft"),
    GEOGLYPH("geoglyph"),
    BEEHIVE("beehive"),
    CLEARCUT("clearcut"),
    STORAGE_TANK("storage_tank"),
    OBSERVATORY("observatory"),
    PIER("pier"),
    KILN("kiln"),
    PUMPING_STATION("pumping_station"),
    SATELLITE_DISH("satellite_dish"),
    WATER_TOWER("water_tower"),
    OIL_WELL("oil_well"),
    WILDLIFE_CROSSING("wildlife_crossing"),
    OBELISK("obelisk"),
    PLANTER("planter"),
    SURVEILLANCE("surveillance"),
    SURVEY_POINT("survey_point"),
    CAIRN("cairn"),
    CROSS("cross"),
    QUAY("quay"),
    WASTEWATER_PLANT("wastewater_plant"),
    SILO("silo"),
    PIPELINE("pipeline"),
    CUTLINE("cutline"),
    GASOMETER("gasometer"),
    WATERMILL("watermill"),
    WINDPUMP("windpump"),
    MAYPOLE("maypole"),
    ;

    private String value;
    Value_MAN_MADE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
