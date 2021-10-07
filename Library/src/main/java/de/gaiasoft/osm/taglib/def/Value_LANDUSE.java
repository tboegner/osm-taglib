package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_LANDUSE implements ValueBase {
    RELIGIOUS("religious"),
    FOREST("forest"),
    COMMERCIAL("commercial"),
    FARMYARD("farmyard"),
    BROWNFIELD("brownfield"),
    PLANT_NURSERY("plant_nursery"),
    FARMLAND("farmland"),
    RETAIL("retail"),
    LANDFILL("landfill"),
    VINEYARD("vineyard"),
    PLANTATION("plantation"),
    GRASS("grass"),
    CONSTRUCTION("construction"),
    MILITARY("military"),
    RAILWAY("railway"),
    HIGHWAY("highway"),
    CEMETERY("cemetery"),
    MEADOW("meadow"),
    GREENHOUSE_HORTICULTURE("greenhouse_horticulture"),
    VILLAGE_GREEN("village_green"),
    GREENFIELD("greenfield"),
    CHURCHYARD("churchyard"),
    ALLOTMENTS("allotments"),
    FLOWERBED("flowerbed"),
    BASIN("basin"),
    SALT_POND("salt_pond"),
    QUARRY("quarry"),
    GARAGES("garages"),
    AQUACULTURE("aquaculture"),
    INDUSTRIAL("industrial"),
    GREENERY("greenery"),
    RESIDENTIAL("residential"),
    ORCHARD("orchard"),
    RECREATION_GROUND("recreation_ground"),
    LOGGING("logging"),
    RESERVOIR("reservoir"),
    ;

    private String value;
    Value_LANDUSE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
