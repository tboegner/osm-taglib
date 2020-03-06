package de.gaiasoft.osm.taglib.rest.taginfo;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.*;
import org.springframework.web.client.RestTemplate;

public class TagInfoRestClient {
    public static final String SORT_KEY = "key";
    public static final String SORT_PROJECTS = "projects";
    public static final String SORT_COUNT_ALL = "count_all";
    public static final String SORT_TOGETHER_COUNT = "together_count";
    public static final String FILTER_IN_WIKI = "in_wiki";
    public static final String FILTER_ALL = "all";

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Constructor
     * @param baseUrl The base URL of the taginfo REST Service to be used.
     */
    public TagInfoRestClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public KeyStats getKeyStats(String key) {
        return restTemplate.getForObject(
                baseUrl +"key/stats?key="+key, KeyStats.class);
    }

    public ProjectsKeys getProjectsKeys(int page, int resultsPerPage, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                baseUrl +"projects/keys?page="+page+"&rp="+resultsPerPage+
                "&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                ProjectsKeys.class);
    }

    public KeysAll getKeysAll(int page, int resultsPerPage, String filter, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                baseUrl +"keys/all?page="+page+"&rp="+resultsPerPage+
                        "&filter="+filter+"&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeysAll.class);
    }

    public KeyCombinations getKeyCombinations(String key, int page, int resultsPerPage, String filter, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                baseUrl +"key/combinations?key="+key+"&page="+page+"&rp="+resultsPerPage+
                        "&filter="+filter+"&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeyCombinations.class);
    }

    public KeyValues getKeyValues(String key, int page, int resultsPerPage, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                baseUrl +"key/values?key="+key+"&page="+page+"&rp="+resultsPerPage+
                        "&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeyValues.class);
    }
}
