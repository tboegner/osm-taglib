package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeysAllData extends ProjectsKeysData {

    private Long count_nodes;
    private Double count_nodes_fraction;
    private Long count_ways;
    private Double count_ways_fraction;
    private Long count_relations;
    private Double count_relations_fraction;
    private Long values_all;
    private Long users_all;

    public KeysAllData() {
    }

    public Long getCount_nodes() {
        return count_nodes;
    }

    public void setCount_nodes(Long count_nodes) {
        this.count_nodes = count_nodes;
    }

    public Double getCount_nodes_fraction() {
        return count_nodes_fraction;
    }

    public void setCount_nodes_fraction(Double count_nodes_fraction) {
        this.count_nodes_fraction = count_nodes_fraction;
    }

    public Long getCount_ways() {
        return count_ways;
    }

    public void setCount_ways(Long count_ways) {
        this.count_ways = count_ways;
    }

    public Double getCount_ways_fraction() {
        return count_ways_fraction;
    }

    public void setCount_ways_fraction(Double count_ways_fraction) {
        this.count_ways_fraction = count_ways_fraction;
    }

    public Long getCount_relations() {
        return count_relations;
    }

    public void setCount_relations(Long count_relations) {
        this.count_relations = count_relations;
    }

    public Double getCount_relations_fraction() {
        return count_relations_fraction;
    }

    public void setCount_relations_fraction(Double count_relations_fraction) {
        this.count_relations_fraction = count_relations_fraction;
    }

    public Long getValues_all() {
        return values_all;
    }

    public void setValues_all(Long values_all) {
        this.values_all = values_all;
    }

    public Long getUsers_all() {
        return users_all;
    }

    public void setUsers_all(Long users_all) {
        this.users_all = users_all;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(!super.equals(o))
            return false;

        if(!(o instanceof KeysAllData))
            return false;
        KeysAllData other = (KeysAllData)o;

        if(!Objects.equals(count_nodes, other.getCount_nodes()))
            return false;
        if(!Objects.equals(count_nodes_fraction, other.getCount_nodes_fraction()))
            return false;
        if(!Objects.equals(count_ways, other.getCount_ways()))
            return false;
        if(!Objects.equals(count_ways_fraction, other.getCount_ways_fraction()))
            return false;
        if(!Objects.equals(count_relations, other.getCount_relations()))
            return false;
        if(!Objects.equals(count_relations_fraction, other.getCount_relations_fraction()))
            return false;
        if(!Objects.equals(values_all, other.getValues_all()))
            return false;
        if(!Objects.equals(users_all, other.getUsers_all()))
            return false;

        return true;
    }
}
