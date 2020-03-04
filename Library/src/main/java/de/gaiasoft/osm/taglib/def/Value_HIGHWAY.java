package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_HIGHWAY implements ValueBase {
    UNCLASSIFIED("unclassified"),
    TURNING_LOOP("turning_loop"),
    PRIMARY_LINK("primary_link"),
    PLATFORM("platform"),
    REST_AREA("rest_area"),
    PATH("path"),
    RACEWAY("raceway"),
    TRAFFIC_SIGNALS("traffic_signals"),
    ROAD("road"),
    CONSTRUCTION("construction"),
    TRACK("track"),
    STREET_LAMP("street_lamp"),
    SECONDARY_LINK("secondary_link"),
    GIVE_WAY("give_way"),
    EMERGENCY_ACCESS_POINT("emergency_access_point"),
    TERTIARY_LINK("tertiary_link"),
    BRIDLEWAY("bridleway"),
    TERTIARY("tertiary"),
    SPEED_CAMERA("speed_camera"),
    LIVING_STREET("living_street"),
    MINI_ROUNDABOUT("mini_roundabout"),
    TRUNK("trunk"),
    MOTORWAY_LINK("motorway_link"),
    CROSSING("crossing"),
    STEPS("steps"),
    MOTORWAY("motorway"),
    SECONDARY("secondary"),
    RESIDENTIAL("residential"),
    TURNING_CIRCLE("turning_circle"),
    STOP("stop"),
    MOTORWAY_JUNCTION("motorway_junction"),
    MILESTONE("milestone"),
    PROPOSED("proposed"),
    SERVICE("service"),
    FOOTWAY("footway"),
    PEDESTRIAN("pedestrian"),
    BUS_STOP("bus_stop"),
    CYCLEWAY("cycleway"),
    TRUNK_LINK("trunk_link"),
    PRIMARY("primary"),
    ;

    private String value;
    Value_HIGHWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
