package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_ORGANIC implements ValueBase {
    NO("no"),
    YES("yes"),
    ONLY("only"),
    ;

    private String value;
    Value_ORGANIC(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
