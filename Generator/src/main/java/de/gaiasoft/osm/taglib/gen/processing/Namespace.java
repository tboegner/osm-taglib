package de.gaiasoft.osm.taglib.gen.processing;

import java.util.HashMap;

import static de.gaiasoft.osm.taglib.gen.processing.NamespaceType.*;

public enum Namespace {
    ADDR("addr", GROUP_PREFIX),
    CONTACT("contact", GROUP_PREFIX),
    IS_IN("is_in", STATE_PREFIX),
    ABANDONED("abandoned", STATE_PREFIX),
    ;

    private String key;
    private NamespaceType type;
    private static HashMap<String, Namespace> namespaceMap = null;
    Namespace(String key, NamespaceType type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public NamespaceType getType() {
        return type;
    }

    public static Namespace getByKey(String key) {
        if(namespaceMap == null) {
            // lazy init
            namespaceMap = new HashMap<>();
            for (Namespace ns : Namespace.values()) {
                namespaceMap.put(ns.getKey(), ns);
            }
        }
        return namespaceMap.get(key);
    }
}
