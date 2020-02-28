package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_BOUNDARY implements ValueBase {
    LOW_EMISSION_ZONE("low_emission_zone"),
    HISTORIC("historic"),
    FOREST_COMPARTMENT("forest_compartment"),
    ADMINISTRATIVE("administrative"),
    NATIONAL_PARK("national_park"),
    MARKER("marker"),
    ABORIGINAL_LANDS("aboriginal_lands"),
    CENSUS("census"),
    POLITICAL("political"),
    PROTECTED_AREA("protected_area"),
    MARITIME("maritime"),
    POSTAL_CODE("postal_code"),
    ;

    private String value;
    Value_BOUNDARY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
