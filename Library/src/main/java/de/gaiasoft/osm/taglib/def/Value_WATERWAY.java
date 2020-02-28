package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_WATERWAY implements ValueBase {
    WEIR("weir"),
    DRYSTREAM("drystream"),
    RAPIDS("rapids"),
    DITCH("ditch"),
    RIVERBANK("riverbank"),
    DRAIN("drain"),
    DAM("dam"),
    ARTIFICIAL("artificial"),
    BOATYARD("boatyard"),
    LOCK_GATE("lock_gate"),
    MILESTONE("milestone"),
    STREAM("stream"),
    WATERFALL("waterfall"),
    RIVER("river"),
    CANAL("canal"),
    DOCK("dock"),
    PRESSURISED("pressurised"),
    ;

    private String value;
    Value_WATERWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
