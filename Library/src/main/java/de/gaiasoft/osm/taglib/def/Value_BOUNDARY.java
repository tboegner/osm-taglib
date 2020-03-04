package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
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
