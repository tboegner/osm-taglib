package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

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
