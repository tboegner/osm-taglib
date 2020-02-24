package de.gaiasoft.osm.taglib.gen.generation;

import de.gaiasoft.osm.taglib.gen.processing.Namespace;

import java.util.Objects;

public class KeyDefinition {
    public enum Type {
        FEATURE,
        SUBKEY,
        NAMESPACE,
        UNKNOWN
    }

    private String id;
    private Type type;
    private Namespace namespace;

    public KeyDefinition(String id) {
        this(id, Type.UNKNOWN, null);
    }

    public KeyDefinition(String id, Type type, Namespace ns) {
        this.id = id;
        this.type = type;
        this.namespace = ns;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyDefinition that = (KeyDefinition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
