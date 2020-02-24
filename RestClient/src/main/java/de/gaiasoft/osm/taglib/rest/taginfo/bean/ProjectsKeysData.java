package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectsKeysData {

    private String key;
    private Long projects;
    private Boolean in_wiki;
    private Long count_all;
    private Double count_all_fraction;

    public ProjectsKeysData() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getProjects() {
        return projects;
    }

    public void setProjects(Long projects) {
        this.projects = projects;
    }

    public Boolean getIn_wiki() {
        return in_wiki;
    }

    public void setIn_wiki(Boolean in_wiki) {
        this.in_wiki = in_wiki;
    }

    public Long getCount_all() {
        return count_all;
    }

    public void setCount_all(Long count_all) {
        this.count_all = count_all;
    }

    public Double getCount_all_fraction() {
        return count_all_fraction;
    }

    public void setCount_all_fraction(Double count_all_fraction) {
        this.count_all_fraction = count_all_fraction;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", projects=" + projects +
                ", in_wiki=" + in_wiki +
                ", count_all=" + count_all +
                ", count_all_fraction=" + count_all_fraction +
                '}';
    }

    @Override
    public int hashCode() {
        return count_all != null ? count_all.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;

        if(!(o instanceof ProjectsKeysData))
            return false;
        ProjectsKeysData other = (ProjectsKeysData)o;

        if(!Objects.equals(key, other.getKey()))
            return false;
        if(!Objects.equals(projects, other.getProjects()))
            return false;
        if(!Objects.equals(in_wiki, other.getIn_wiki()))
            return false;
        if(!Objects.equals(count_all, other.getCount_all()))
            return false;
        if(!Objects.equals(count_all_fraction, other.getCount_all_fraction()))
            return false;

        return true;
    }
}
