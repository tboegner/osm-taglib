package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_TELECOM implements ValueBase {
    SERVICE_DEVICE("service_device"),
    DISTRIBUTION_POINT("distribution_point"),
    REMOTE_TERMINAL("remote_terminal"),
    EXCHANGE("exchange"),
    DATA_CENTER("data_center"),
    CONNECTION_POINT("connection_point"),
    ;

    private String value;
    Value_TELECOM(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
