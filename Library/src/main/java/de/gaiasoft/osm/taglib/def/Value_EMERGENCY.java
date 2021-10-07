package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_EMERGENCY implements ValueBase {
    AMBULANCE_STATION("ambulance_station"),
    ACCESS_POINT("access_point"),
    SIREN("siren"),
    FIRE_ALARM_BOX("fire_alarm_box"),
    SUCTION_POINT("suction_point"),
    ASSEMBLY_POINT("assembly_point"),
    FIRE_HYDRANT("fire_hydrant"),
    LANDING_SITE("landing_site"),
    DESIGNATED("designated"),
    FIRST_AID_KIT("first_aid_kit"),
    MOUNTAIN_RESCUE("mountain_rescue"),
    LIFEGUARD("lifeguard"),
    SLIPWAY("slipway"),
    FIRE_WATER_POND("fire_water_pond"),
    FIRE_EXTINGUISHER("fire_extinguisher"),
    LIFEBOAT_STATION("lifeboat_station"),
    YES("yes"),
    FIRE_HOSE("fire_hose"),
    EMERGENCY_WARD_ENTRANCE("emergency_ward_entrance"),
    LIFE_RING("life_ring"),
    CONTROL_CENTRE("control_centre"),
    DRY_RISER_INLET("dry_riser_inlet"),
    FIRE_LOOKOUT("fire_lookout"),
    PHONE("phone"),
    DRINKING_WATER("drinking_water"),
    WATER_TANK("water_tank"),
    DEFIBRILLATOR("defibrillator"),
    ;

    private String value;
    Value_EMERGENCY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
