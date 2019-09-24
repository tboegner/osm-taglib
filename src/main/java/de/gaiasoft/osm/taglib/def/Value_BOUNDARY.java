package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_BOUNDARY implements ValueBase {
    FORESTRY_COMPARTMENT("forestry_compartment"),
    ABORIGINAL_LANDS("aboriginal_lands"),
    TIMEZONE("timezone"),
    LOCAL_AUTHORITY("local_authority"),
    POLITICAL("political"),
    MILITARY_DISTRICT("military_district"),
    LOW_EMISSION_ZONE("low_emission_zone"),
    NATIONAL_PARK("national_park"),
    CIVIL("civil"),
    NATIONAL("national"),
    PROTECTED_AREA("protected_area"),
    HISTORIC("historic"),
    HEALTH("health"),
    FOREST_COMPARTMENT("forest_compartment"),
    URBAN("urban"),
    ADMINISTRATIVE("administrative"),
    MARKER("marker"),
    CENSUS("census"),
    MARITIME("maritime"),
    RELIGIOUS_ADMINISTRATION("religious_administration"),
    POSTAL_CODE("postal_code"),
    REGIONAL_PARK("regional_park"),
    WATER_PROTECTION_AREA("water_protection_area"),
    ECONOMIC("economic"),
    VICE_COUNTY("vice_county"),
    ;

    private String value;
    Value_BOUNDARY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
