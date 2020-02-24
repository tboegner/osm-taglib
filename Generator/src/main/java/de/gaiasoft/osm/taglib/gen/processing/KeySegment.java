package de.gaiasoft.osm.taglib.gen.processing;

public enum KeySegment {
    PRIMARY("Primary"),
    ADDRESS("Address"),
    NAME("Name"),
    ANNOTATION("Annotation"),
    PROPERTY("Property"),
    DETAIL("Detail"),
    ;

    private String id;
    KeySegment(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
