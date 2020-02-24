package de.gaiasoft.osm.taglib.rest.taginfo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Base {

    private Long total;
    private String url;
    private String data_until;

    public Base() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData_until() {
        return data_until;
    }

    public void setData_until(String data_until) {
        this.data_until = data_until;
    }

    @Override
    public String toString() {
        return "url="+url+", total="+total+", data_until="+ data_until;
    }
}
