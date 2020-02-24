package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyCombinations extends BasePaging {
    private List<KeyCombinationsData> data;

    public KeyCombinations() {
    }

    public List<KeyCombinationsData> getData() {
        return data;
    }

    public void setData(List<KeyCombinationsData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"+super.toString());
        sb.append(", data=[\n");
        for (KeyCombinationsData item: data) {
            sb.append(item.toString() + "\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
