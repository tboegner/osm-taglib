package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyStatsData {

    private String type;
    private Long count;
    private Double count_fraction;
    private Long values;

    public KeyStatsData() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getCount_fraction() {
        return count_fraction;
    }

    public void setCount_fraction(Double count_fraction) {
        this.count_fraction = count_fraction;
    }

    public Long getValues() {
        return values;
    }

    public void setValues(Long values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", count=" + count +
                ", count_fraction=" + count_fraction +
                ", values=" + values +
                '}';
    }
}
