package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectsKeys extends BasePaging {
    private List<ProjectsKeysData> data;

    public ProjectsKeys() {
    }

    public List<ProjectsKeysData> getData() {
        return data;
    }

    public void setData(List<ProjectsKeysData> data) {
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
