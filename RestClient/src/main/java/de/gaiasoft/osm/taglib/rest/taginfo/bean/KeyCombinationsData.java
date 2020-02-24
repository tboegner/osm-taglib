package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyCombinationsData {

    private String other_key;
    private Long together_count;
    private Double to_fraction;
    private Double from_fraction;

    public KeyCombinationsData() {
    }

    public String getOther_key() {
        return other_key;
    }

    public void setOther_key(String other_key) {
        this.other_key = other_key;
    }

    public Long getTogether_count() {
        return together_count;
    }

    public void setTogether_count(Long together_count) {
        this.together_count = together_count;
    }

    public Double getTo_fraction() {
        return to_fraction;
    }

    public void setTo_fraction(Double to_fraction) {
        this.to_fraction = to_fraction;
    }

    public Double getFrom_fraction() {
        return from_fraction;
    }

    public void setFrom_fraction(Double from_fraction) {
        this.from_fraction = from_fraction;
    }
}
