package de.gaiasoft.osm.taglib.rest.taginfo;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.*;
import org.springframework.web.client.RestTemplate;

public class TagInfoRestClient {
    private static final String BASE_URL = "https://taginfo.openstreetmap.org/api/4/";
    public static final String SORT_KEY = "key";
    public static final String SORT_PROJECTS = "projects";
    public static final String SORT_COUNT_ALL = "count_all";
    public static final String SORT_TOGETHER_COUNT = "together_count";
    public static final String FILTER_IN_WIKI = "in_wiki";
    public static final String FILTER_ALL = "all";

    private RestTemplate restTemplate = new RestTemplate();

    public KeyStats getKeyStats(String key) {
        return restTemplate.getForObject(
                BASE_URL+"key/stats?key="+key, KeyStats.class);
    }

    public ProjectsKeys getProjectsKeys(int page, int resultsPerPage, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                BASE_URL+"projects/keys?page="+page+"&rp="+resultsPerPage+
                "&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                ProjectsKeys.class);
    }

    public KeysAll getKeysAll(int page, int resultsPerPage, String filter, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                BASE_URL+"keys/all?page="+page+"&rp="+resultsPerPage+
                        "&filter="+filter+"&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeysAll.class);
    }

    public KeyCombinations getKeyCombinations(String key, int page, int resultsPerPage, String filter, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                BASE_URL+"key/combinations?key="+key+"&page="+page+"&rp="+resultsPerPage+
                        "&filter="+filter+"&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeyCombinations.class);
    }

    public KeyValues getKeyValues(String key, int page, int resultsPerPage, String sortBy, boolean sortAscending) {
        return restTemplate.getForObject(
                BASE_URL+"key/values?key="+key+"&page="+page+"&rp="+resultsPerPage+
                        "&sortname="+sortBy+"&sortorder="+(sortAscending?"asc":"desc"),
                KeyValues.class);
    }
}
