package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_TOURISM implements ValueBase {
    TRAIL_RIDING_STATION("trail_riding_station"),
    VIEWPOINT("viewpoint"),
    GUEST_HOUSE("guest_house"),
    CAMP_PITCH("camp_pitch"),
    HOSTEL("hostel"),
    WINE_CELLAR("wine_cellar"),
    CHALET("chalet"),
    ARTWORK("artwork"),
    MOTEL("motel"),
    AQUARIUM("aquarium"),
    WILDERNESS_HUT("wilderness_hut"),
    ATTRACTION("attraction"),
    MUSEUM("museum"),
    ALPINE_HUT("alpine_hut"),
    HOTEL("hotel"),
    CARAVAN_SITE("caravan_site"),
    INFORMATION("information"),
    CAMP_SITE("camp_site"),
    THEME_PARK("theme_park"),
    ZOO("zoo"),
    PICNIC_SITE("picnic_site"),
    APARTMENT("apartment"),
    GALLERY("gallery"),
    ;

    private String value;
    Value_TOURISM(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
