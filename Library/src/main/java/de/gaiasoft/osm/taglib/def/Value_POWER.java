package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_POWER implements ValueBase {
    LINE("line"),
    CONVERTER("converter"),
    TRANSFORMER("transformer"),
    GENERATOR("generator"),
    HELIOSTAT("heliostat"),
    POLE("pole"),
    ANTENNA_LINE("antenna_line"),
    SUB_STATION("sub_station"),
    SWITCH("switch"),
    CATENARY_MAST("catenary_mast"),
    SWITCHGEAR("switchgear"),
    SUBSTATION("substation"),
    STATION("station"),
    OUTLET("outlet"),
    PORTAL("portal"),
    CABLE("cable"),
    INSULATOR("insulator"),
    MINOR_LINE("minor_line"),
    TOWER("tower"),
    UNDERGROUND_CABLE("underground_cable"),
    CABLE_DISTRIBUTION_CABINET("cable_distribution_cabinet"),
    TERMINAL("terminal"),
    COMPENSATOR("compensator"),
    BUSBAR("busbar"),
    MARKER("marker"),
    PLANT("plant"),
    GROUNDING("grounding"),
    ;

    private String value;
    Value_POWER(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
