package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_VENDING implements ValueBase {
    BOTTLE_RETURN("bottle_return"),
    ELECTRONICS("electronics"),
    CONDOMS("condoms"),
    FUEL("fuel"),
    DRINKS("drinks"),
    BICYCLE_TUBE("bicycle_tube"),
    CANDLES("candles"),
    TOLL("toll"),
    ICE_CREAM("ice_cream"),
    PUBLIC_TRANSPORT_PLANS("public_transport_plans"),
    PARCEL_PICKUP("parcel_pickup"),
    ADMISSION_TICKETS("admission_tickets"),
    PARKING_TICKETS("parking_tickets"),
    ANIMAL_FEED("animal_feed"),
    STAMPS("stamps"),
    PARCEL_MAIL_IN("parcel_mail_in"),
    CHEMIST("chemist"),
    BREAD("bread"),
    FLOWERS("flowers"),
    TOYS("toys"),
    ELONGATED_COIN("elongated_coin"),
    MILK("milk"),
    NEWSPAPERS("newspapers"),
    ICE_CUBES("ice_cubes"),
    WATER("water"),
    FOOD("food"),
    TELEPHONE_VOUCHERS("telephone_vouchers"),
    CHEWING_GUMS("chewing_gums"),
    COFFEE("coffee"),
    CONTACT_LENSES("contact_lenses"),
    SYRINGES("syringes"),
    CIGARETTES("cigarettes"),
    SWEETS("sweets"),
    EXCREMENT_BAGS("excrement_bags"),
    PUBLIC_TRANSPORT_TICKETS("public_transport_tickets"),
    ;

    private String value;
    Value_VENDING(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
