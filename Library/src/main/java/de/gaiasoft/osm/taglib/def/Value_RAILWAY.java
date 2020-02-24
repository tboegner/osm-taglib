package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_RAILWAY implements ValueBase {
    JUNCTION("junction"),
    LUBRICATOR("lubricator"),
    OBLITERATED("obliterated"),
    PLATFORM_EDGE("platform_edge"),
    TRAM_STOP("tram_stop"),
    VIADUCT("viaduct"),
    YARD("yard"),
    FUEL("fuel"),
    HISTORICAL("historical"),
    LIGHT_RAIL("light_rail"),
    SIGNAL_BOX("signal_box"),
    FUNICULAR("funicular"),
    PRESERVED("preserved"),
    DISMANTLED("dismantled"),
    TRAIN_STATION_ENTRANCE("train_station_entrance"),
    ROUNDHOUSE("roundhouse"),
    ABANDONED("abandoned"),
    TRAM("tram"),
    SIGNAL("signal"),
    WATER_CRANE("water_crane"),
    RAIL("rail"),
    WASH("wash"),
    CROSSING("crossing"),
    LEVEL_CROSSING("level_crossing"),
    PROPOSED("proposed"),
    STOP("stop"),
    RAILWAY_CROSSING("railway_crossing"),
    SPUR_JUNCTION("spur_junction"),
    BUFFER_STOP("buffer_stop"),
    TURNTABLE("turntable"),
    PLATFORM("platform"),
    MONORAIL("monorail"),
    SWITCH("switch"),
    SERVICE_STATION("service_station"),
    WATER_TOWER("water_tower"),
    STATION("station"),
    CONSTRUCTION("construction"),
    LOADING_RACK("loading_rack"),
    NARROW_GAUGE("narrow_gauge"),
    SUBWAY_ENTRANCE("subway_entrance"),
    HISTORIC("historic"),
    TRAVERSER("traverser"),
    CROSSING_CONTROLLER("crossing_controller"),
    RAIL_BRAKE("rail_brake"),
    DISUSED("disused"),
    HALT("halt"),
    DIAMOND("diamond"),
    SUBWAY("subway"),
    MILESTONE("milestone"),
    MINIATURE("miniature"),
    DERAIL("derail"),
    RAZED("razed"),
    ;

    private String value;
    Value_RAILWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
