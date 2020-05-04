package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_ROUTE implements ValueBase {
    BUS("bus"),
    MOTORBOAT("motorboat"),
    BICYCLE("bicycle"),
    CANOE("canoe"),
    LIGHT_RAIL("light_rail"),
    PISTE("piste"),
    SKI("ski"),
    RUNNING("running"),
    SHARE_TAXI("share_taxi"),
    ROAD("road"),
    FERRY("ferry"),
    MTB("mtb"),
    RAILWAY("railway"),
    TRAM("tram"),
    FOOT("foot"),
    TRAIN("train"),
    FITNESS_TRAIL("fitness_trail"),
    WATERWAY("waterway"),
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
