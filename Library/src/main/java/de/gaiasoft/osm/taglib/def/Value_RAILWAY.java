package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_RAILWAY implements ValueBase {
    JUNCTION("junction"),
    TRAM_STOP("tram_stop"),
    PLATFORM_EDGE("platform_edge"),
    YARD("yard"),
    BUFFER_STOP("buffer_stop"),
    TURNTABLE("turntable"),
    LIGHT_RAIL("light_rail"),
    TRAM_CROSSING("tram_crossing"),
    PLATFORM("platform"),
    SIGNAL_BOX("signal_box"),
    SWITCH("switch"),
    MONORAIL("monorail"),
    FUNICULAR("funicular"),
    PRESERVED("preserved"),
    STATION("station"),
    ABANDONED("abandoned"),
    TRAM("tram"),
    SIGNAL("signal"),
    NARROW_GAUGE("narrow_gauge"),
    SUBWAY_ENTRANCE("subway_entrance"),
    RAIL("rail"),
    DISUSED("disused"),
    CROSSING("crossing"),
    TRAM_LEVEL_CROSSING("tram_level_crossing"),
    HALT("halt"),
    LEVEL_CROSSING("level_crossing"),
    SUBWAY("subway"),
    MILESTONE("milestone"),
    STOP("stop"),
    RAILWAY_CROSSING("railway_crossing"),
    MINIATURE("miniature"),
    DERAIL("derail"),
    ;

    private String value;
    Value_RAILWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
