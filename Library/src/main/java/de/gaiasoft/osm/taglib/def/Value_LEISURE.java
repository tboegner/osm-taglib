package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_LEISURE implements ValueBase {
    BOWLING_ALLEY("bowling_alley"),
    ICE_RINK("ice_rink"),
    TANNING_SALON("tanning_salon"),
    BLEACHERS("bleachers"),
    HACKERSPACE("hackerspace"),
    BEACH_RESORT("beach_resort"),
    FITNESS_STATION("fitness_station"),
    SAUNA("sauna"),
    PLAYGROUND("playground"),
    STADIUM("stadium"),
    PITCH("pitch"),
    SLIPWAY("slipway"),
    OUTDOOR_SEATING("outdoor_seating"),
    HORSE_RIDING("horse_riding"),
    TRACK("track"),
    RESORT("resort"),
    DANCE("dance"),
    SWIMMING_POOL("swimming_pool"),
    PARK("park"),
    BANDSTAND("bandstand"),
    AMUSEMENT_ARCADE("amusement_arcade"),
    SPORTS_CENTRE("sports_centre"),
    FISHING("fishing"),
    PICNIC_TABLE("picnic_table"),
    BIRD_HIDE("bird_hide"),
    MARINA("marina"),
    FITNESS_CENTRE("fitness_centre"),
    WATER_PARK("water_park"),
    SWIMMING_AREA("swimming_area"),
    DOG_PARK("dog_park"),
    GARDEN("garden"),
    NATURE_RESERVE("nature_reserve"),
    MINIATURE_GOLF("miniature_golf"),
    FIREPIT("firepit"),
    GOLF_COURSE("golf_course"),
    ADULT_GAMING_CENTRE("adult_gaming_centre"),
    ;

    private String value;
    Value_LEISURE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
