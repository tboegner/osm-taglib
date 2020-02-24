package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_TELECOM implements ValueBase {
    DATA_CENTRE("data_centre"),
    SERVICE_DEVICE("service_device"),
    REMOTE_TERMINAL("remote_terminal"),
    DATA_CENTER("data_center"),
    DATACENTER("datacenter"),
    EXCHANGE("exchange"),
    CONNECTION_POINT("connection_point"),
    REMOTE_DIGITAL_TERMINAL("remote_digital_terminal"),
    ;

    private String value;
    Value_TELECOM(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
