package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_WATERWAY implements ValueBase {
    WEIR("weir"),
    DERELICT_CANAL("derelict_canal"),
    DRYSTREAM("drystream"),
    LAKEBANK("lakebank"),
    DITCH("ditch"),
    FUEL("fuel"),
    RIVERBANK("riverbank"),
    DRAIN("drain"),
    DAM("dam"),
    BOATYARD("boatyard"),
    STREAM_END("stream_end"),
    LOCK_GATE("lock_gate"),
    STREAM("stream"),
    WATER_POINT("water_point"),
    WATERFALL("waterfall"),
    CONSTRUCTION("construction"),
    BOAT_LIFT("boat_lift"),
    CANAL("canal"),
    DOCK("dock"),
    PRESSURISED("pressurised"),
    SLUICE_GATE("sluice_gate"),
    BROOK("brook"),
    TIDAL_CHANNEL("tidal_channel"),
    RAPIDS("rapids"),
    FISH_PASS("fish_pass"),
    SPILLWAY("spillway"),
    OFFSHORE_FIELD("offshore_field"),
    TURNING_POINT("turning_point"),
    MILESTONE("milestone"),
    ESTUARY("estuary"),
    FAIRWAY("fairway"),
    WADI("wadi"),
    DEEP_WELL("deep_well"),
    SEAWAY("seaway"),
    RIVER("river"),
    SANITARY_DUMP_STATION("sanitary_dump_station"),
    PORTAGE("portage"),
    DREDGED_AREA("dredged_area"),
    MOORING("mooring"),
    SWEPT_AREA("swept_area"),
    ;

    private String value;
    Value_WATERWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
