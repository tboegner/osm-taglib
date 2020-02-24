package de.gaiasoft.osm.taglib.gen.processing;

import java.util.HashSet;

public class FeatureKeySet extends HashSet<String> {
    
    private FeatureKeySet() {
        add("aerialway");
        add("aeroway");
        add("amenity");
        add("barrier");
        add("boundary");
        add("building");
        add("craft");
        add("emergency");
        add("geological");
        add("highway");
        add("historic");
        add("leisure");
        add("man_made");
        add("military");
        add("natural");
        add("office");
        add("place");
        add("power");
        add("public_transport");
        add("railway");
        add("route");
        add("shop");
        add("sport");
        add("telecom");
        add("tourism");
        add("waterway");
    }

    private static FeatureKeySet instance;

    public static FeatureKeySet get() {
        if(instance == null) {
            instance = new FeatureKeySet();
        }
        return instance;
    }
}
