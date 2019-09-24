package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_ROUTE implements ValueBase {
    BUS("bus"),
    MOTORBOAT("motorboat"),
    BICYCLE("bicycle"),
    CANOE("canoe"),
    MUDFLAT_HIKING("mudflat_hiking"),
    LIGHT_RAIL("light_rail"),
    MONORAIL("monorail"),
    PISTE("piste"),
    RUNNING("running"),
    SKI("ski"),
    SHARE_TAXI("share_taxi"),
    AQUEDUCT("aqueduct"),
    ROAD("road"),
    FERRY("ferry"),
    NCN("ncn"),
    MTB("mtb"),
    CANAL("canal"),
    POWER("power"),
    RAILWAY("railway"),
    TRAM("tram"),
    FOOT("foot"),
    TRAIN("train"),
    EVACUATION("evacuation"),
    HISTORIC("historic"),
    NORDIC_WALKING("nordic_walking"),
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
    MINIBUS("minibus"),
    COACH("coach"),
    WORSHIP("worship"),
    FERRATA("ferrata"),
    ;

    private String value;
    Value_ROUTE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
