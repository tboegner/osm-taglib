package de.gaiasoft.osm.taglib.support;

import de.gaiasoft.osm.taglib.base.KeyBase;
import de.gaiasoft.osm.taglib.base.ValueBase;

import java.util.Objects;

public class Tag {
    private KeyBase key;
    private ValueBase value;

    public Tag(KeyBase key, ValueBase value) {
        this.key = key;
        this.value = value;
    }

    public KeyBase getKey() {
        return key;
    }

    public ValueBase getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key.getKey() + "=" + value.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(key, tag.key) &&
                Objects.equals(value, tag.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
