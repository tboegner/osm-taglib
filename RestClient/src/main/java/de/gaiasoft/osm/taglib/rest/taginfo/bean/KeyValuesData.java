package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyValuesData {

    private String value;
    private Long count;
    private Double fraction;
    private Boolean in_wiki;
    private String desclang;
    private String descdir;
    private String description;

    public KeyValuesData() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIn_wiki() {
        return in_wiki;
    }

    public void setIn_wiki(Boolean in_wiki) {
        this.in_wiki = in_wiki;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getFraction() {
        return fraction;
    }

    public void setFraction(Double fraction) {
        this.fraction = fraction;
    }

    public String getDesclang() {
        return desclang;
    }

    public void setDesclang(String desclang) {
        this.desclang = desclang;
    }

    public String getDescdir() {
        return descdir;
    }

    public void setDescdir(String descdir) {
        this.descdir = descdir;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", count=" + count +
                ", fraction=" + fraction +
                ", in_wiki=" + in_wiki +
                ", desclang=" + desclang +
                ", descdir=" + descdir +
                ", description=" + description +
                '}';
    }
}
