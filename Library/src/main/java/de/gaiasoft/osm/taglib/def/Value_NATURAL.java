package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_NATURAL implements ValueBase {
    SCREE("scree"),
    SADDLE("saddle"),
    CLIFF("cliff"),
    BARE_ROCK("bare_rock"),
    CAVE_ENTRANCE("cave_entrance"),
    SINKHOLE("sinkhole"),
    HEATH("heath"),
    ROCK("rock"),
    SPRING("spring"),
    FELL("fell"),
    WOOD("wood"),
    BAY("bay"),
    RIDGE("ridge"),
    TREE_ROW("tree_row"),
    GLACIER("glacier"),
    REEF("reef"),
    COASTLINE("coastline"),
    WETLAND("wetland"),
    TREE("tree"),
    PEAK("peak"),
    SCRUB("scrub"),
    WATER("water"),
    GRASSLAND("grassland"),
    STONE("stone"),
    SAND("sand"),
    HILL("hill"),
    BEACH("beach"),
    SHINGLE("shingle"),
    VALLEY("valley"),
    CAPE("cape"),
    MUD("mud"),
    ;

    private String value;
    Value_NATURAL(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
