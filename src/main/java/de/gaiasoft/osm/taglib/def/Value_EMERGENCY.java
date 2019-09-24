package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_EMERGENCY implements ValueBase {
    ACCESS_POINT("access_point"),
    AMBULANCE_STATION("ambulance_station"),
    AED("aed"),
    SIREN("siren"),
    FIRE_ALARM_BOX("fire_alarm_box"),
    ASSEMBLY_POINT("assembly_point"),
    SUCTION_POINT("suction_point"),
    DESTINATION("destination"),
    LIFEGUARD_TOWER("lifeguard_tower"),
    FIRE_HYDRANT("fire_hydrant"),
    LANDING_SITE("landing_site"),
    SPRINKLER_CONNECTION("sprinkler_connection"),
    DRY_RISER("dry_riser"),
    COAST_GUARD("coast_guard"),
    FIRE_FLAPPER("fire_flapper"),
    FIRST_AID_KIT("first_aid_kit"),
    SIAMESE("siamese"),
    MOUNTAIN_RESCUE("mountain_rescue"),
    LIFEGUARD("lifeguard"),
    RESCUE_BOX("rescue_box"),
    SLIPWAY("slipway"),
    FIRE_ALARM("fire_alarm"),
    SPRINKLER("sprinkler"),
    FIRE_WATER_POND("fire_water_pond"),
    FIRST_AID("first_aid"),
    FIRE_DETECTION_SYSTEM("fire_detection_system"),
    FIRE_EXTINGUISHER("fire_extinguisher"),
    LIFEBOAT_STATION("lifeboat_station"),
    YES("yes"),
    FIRE_HOSE("fire_hose"),
    STANDPIPE("standpipe"),
    EMERGENCY_WARD_ENTRANCE("emergency_ward_entrance"),
    LIFE_RING("life_ring"),
    LIFEGUARD_BASE("lifeguard_base"),
    FIRE_POINT_STAND("fire_point_stand"),
    DISASTER_RESPONSE("disaster_response"),
    DRY_RISER_INLET("dry_riser_inlet"),
    DEFIBRILATOR("defibrilator"),
    LIFEGUARD_PLACE("lifeguard_place"),
    PHONE("phone"),
    LIFEGUARD_PLATFORM("lifeguard_platform"),
    SES_STATION("ses_station"),
    WATER_RESCUE_STATION("water_rescue_station"),
    WATER_TANK("water_tank"),
    FIRE_SAND_BIN("fire_sand_bin"),
    MARINE_REFUGE("marine_refuge"),
    WET_RISER("wet_riser"),
    DEFIBRILLATOR("defibrillator"),
    ;

    private String value;
    Value_EMERGENCY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
