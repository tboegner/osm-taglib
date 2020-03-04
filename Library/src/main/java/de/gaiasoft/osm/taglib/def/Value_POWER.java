package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_POWER implements ValueBase {
    LINE("line"),
    TRANSFORMER("transformer"),
    GENERATOR("generator"),
    HELIOSTAT("heliostat"),
    TERMINAL("terminal"),
    POLE("pole"),
    SUB_STATION("sub_station"),
    SWITCH("switch"),
    CATENARY_MAST("catenary_mast"),
    SUBSTATION("substation"),
    PLANT("plant"),
    PORTAL("portal"),
    CABLE("cable"),
    INSULATOR("insulator"),
    TOWER("tower"),
    MINOR_LINE("minor_line"),
    ;

    private String value;
    Value_POWER(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
