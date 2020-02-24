package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeysAll extends BasePaging {
    private List<KeysAllData> data;

    public KeysAll() {
    }

    public List<KeysAllData> getData() {
        return data;
    }

    public void setData(List<KeysAllData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"+super.toString());
        sb.append(", data=[\n");
        for (ProjectsKeysData item: data) {
            sb.append(item.toString() + "\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
