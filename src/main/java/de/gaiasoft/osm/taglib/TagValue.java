package de.bogensoft.sitefinder.api.bean.adapter;

public enum TagValue {
    // common values
    YES("yes"),
    NO("no"),
    LIMITED("limited"),
    DESIGNATED("designated"),
    ONLY("only"),

    // shop values
    //alcohol
    BAKERY("bakery"),
    BEVERAGES("beverages"),
    //brewing_supplies
    BUTCHER("butcher"),
    //cheese
    //chocolate
    // coffee
    // confectionery
    CONVENIENCE("convenience"),
    // deli
    // dairy
    FARM("farm"),
    //frozen_food
    GREENGROCER("greengrocer"),
    // health_food
    // ice_cream
    // organic  Alternatively you can use the more versatile organic=* in combination with a general shop=* key (In this case: shop=supermarket or shop=convenience).
    //pasta
    // pastry
    // seafood
    // spices
    // tea
    // wine -> obsolete: Area 	please use shop=alcohol + drink:wine=yes instead
    SUPERMARKET("supermarket"),

    // amenity values
    MARKETPLACE("marketplace"),
    BAR("bar"),
    //amenity 	bbq
    BIERGARTEN("biergarten"),
    CAFE("cafe"),
    //amenity 	drinking_water,
    FAST_FOOD("fast_food"),
    FOOD_COURT("food_court"),
    ICE_CREAM("ice_cream"),
    PUB("pub"),
    RESTAURANT("restaurant"),
    VENDING_MACHINE("vending_machine"),
    VENDING("vending"),
    FOOD("food"),
    CIGARETTES("cigarettes"),
    ;

    public static TagValue findValue(String value) {
        for(TagValue tagValue : values()) {
            if(tagValue.value.equals(value)) {
                return tagValue;
            }
        }
        return null;
    }

    private String value;
    TagValue(String value) {
        this.value = value;
    }
    public String getValue() { return value; }
}
