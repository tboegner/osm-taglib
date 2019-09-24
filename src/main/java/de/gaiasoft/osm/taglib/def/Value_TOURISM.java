package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_TOURISM implements ValueBase {
    HOSTEL("hostel"),
    WINE_CELLAR("wine_cellar"),
    MOTEL("motel"),
    CARAVAN_SITE("caravan_site"),
    HOTEL("hotel"),
    CAMP_SITE("camp_site"),
    THEME_PARK("theme_park"),
    ZOO("zoo"),
    PICNIC_SITE("picnic_site"),
    RESORT("resort"),
    GALLERY("gallery"),
    TRAIL_RIDING_STATION("trail_riding_station"),
    GUEST_HOUSE("guest_house"),
    VIEWPOINT("viewpoint"),
    CAMP_PITCH("camp_pitch"),
    YES("yes"),
    CHALET("chalet"),
    ARTWORK("artwork"),
    AQUARIUM("aquarium"),
    LEAN_TO("lean_to"),
    WILDERNESS_HUT("wilderness_hut"),
    SPA_RESORT("spa_resort"),
    ATTRACTION("attraction"),
    MUSEUM("museum"),
    ALPINE_HUT("alpine_hut"),
    ACCOMMODATION("accommodation"),
    BED_AND_BREAKFAST("bed_and_breakfast"),
    INFORMATION("information"),
    APARTMENT("apartment"),
    ;

    private String value;
    Value_TOURISM(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
