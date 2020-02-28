package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_EMERGENCY implements ValueBase {
    AMBULANCE_STATION("ambulance_station"),
    ACCESS_POINT("access_point"),
    FIRE_EXTINGUISHER("fire_extinguisher"),
    SIREN("siren"),
    FIRE_ALARM_BOX("fire_alarm_box"),
    YES("yes"),
    ASSEMBLY_POINT("assembly_point"),
    SUCTION_POINT("suction_point"),
    FIRE_HOSE("fire_hose"),
    EMERGENCY_WARD_ENTRANCE("emergency_ward_entrance"),
    LIFE_RING("life_ring"),
    LIFEGUARD_TOWER("lifeguard_tower"),
    LIFEGUARD_BASE("lifeguard_base"),
    FIRE_HYDRANT("fire_hydrant"),
    LANDING_SITE("landing_site"),
    DRY_RISER_INLET("dry_riser_inlet"),
    FIRST_AID_KIT("first_aid_kit"),
    PHONE("phone"),
    LIFEGUARD("lifeguard"),
    DRINKING_WATER("drinking_water"),
    WATER_RESCUE_STATION("water_rescue_station"),
    WATER_TANK("water_tank"),
    DEFIBRILLATOR("defibrillator"),
    FIRE_WATER_POND("fire_water_pond"),
    ;

    private String value;
    Value_EMERGENCY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
