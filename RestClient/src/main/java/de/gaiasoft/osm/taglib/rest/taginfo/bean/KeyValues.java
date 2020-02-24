package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyValues extends BasePaging {
    private List<KeyValuesData> data;

    public KeyValues() {
    }

    public List<KeyValuesData> getData() {
        return data;
    }

    public void setData(List<KeyValuesData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"+super.toString());
        sb.append(", data=[\n");
        for (KeyValuesData item: data) {
            sb.append(item.toString() + "\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
