package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyStats extends Base {
    private List<KeyStatsData> data;

    public KeyStats() {
    }

    public List<KeyStatsData> getData() {
        return data;
    }

    public void setData(List<KeyStatsData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"+super.toString());
        sb.append(", data=[\n");
        for (KeyStatsData item: data) {
            sb.append(item.toString() + "\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
