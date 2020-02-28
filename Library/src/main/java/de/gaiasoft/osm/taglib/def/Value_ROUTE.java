package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_ROUTE implements ValueBase {
    BUS("bus"),
    MOTORBOAT("motorboat"),
    BICYCLE("bicycle"),
    CANOE("canoe"),
    LIGHT_RAIL("light_rail"),
    PISTE("piste"),
    RUNNING("running"),
    SHARE_TAXI("share_taxi"),
    ROAD("road"),
    FERRY("ferry"),
    MTB("mtb"),
    TRAM("tram"),
    FOOT("foot"),
    TRAIN("train"),
    FITNESS_TRAIL("fitness_trail"),
    HIKING("hiking"),
    TROLLEYBUS("trolleybus"),
    TRACKS("tracks"),
    HORSE("horse"),
    PIPELINE("pipeline"),
    TRANSHUMANCE("transhumance"),
    DETOUR("detour"),
    SUBWAY("subway"),
    INLINE_SKATES("inline_skates"),
    SNOWMOBILE("snowmobile"),
    ;

    private String value;
    Value_ROUTE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
