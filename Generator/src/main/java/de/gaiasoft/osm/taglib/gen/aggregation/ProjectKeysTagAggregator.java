package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.ProjectsKeys;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.ProjectsKeysData;

import java.util.HashSet;
import java.util.Set;

/**
 * Finds keys via the "projectKeys"-interface.
 * Relevance is determined by the number of projects for the key. Additionally
 * exceeding a minimum count of absolute appearance can qualify a key independently.
 */
public class ProjectKeysTagAggregator extends RestTagAggregator {
    private int pageSizeProjectKeys = 25;
    private static final long MIN_PROJECTS = 10;
    private static final long MIN_KEY_COUNT = 10000000;

    @Override
    public String getPostfixIdentifier() {
        return "ProjectKeys";
    }

    @Override
    public Set<KeysAllData> determineBasicKeySet() {
        Set<KeysAllData> basicKeySet = new HashSet<>();
        ProjectsKeys projectsKeys;
        int page=0;
        int relevantKeysOnPage;
        do {
            projectsKeys = tagInfo.getProjectsKeys(++page, pageSizeProjectKeys, TagInfoRestClient.SORT_PROJECTS, false);
            relevantKeysOnPage = 0;
            for (ProjectsKeysData item : projectsKeys.getData()) {
                boolean relevantKey = item.getIn_wiki() &&
                        (item.getProjects() >= MIN_PROJECTS || item.getCount_all() >= MIN_KEY_COUNT);
                if(relevantKey) {
                    ++relevantKeysOnPage;
                    // TODO (optional): design decoupled data type at the interface
                    // the types from rest interface are not really matching our needs
                    basicKeySet.add(upcast(item));
                }

            }
        } while(relevantKeysOnPage > 0 && (page * pageSizeProjectKeys < projectsKeys.getTotal()));

        return basicKeySet;
    }

    @Override
    public Set<KeysAllData> determineExtendedKeySet(Set<KeysAllData> basicKeySet) {
        return new HashSet<>();
    }

    private KeysAllData upcast(ProjectsKeysData projectsKeysData) {
        KeysAllData keysAllData = new KeysAllData();
        keysAllData.setKey(projectsKeysData.getKey());
        keysAllData.setIn_wiki(projectsKeysData.getIn_wiki());
        keysAllData.setCount_all(projectsKeysData.getCount_all());
        keysAllData.setCount_all_fraction(projectsKeysData.getCount_all_fraction());
        keysAllData.setProjects(projectsKeysData.getProjects());
        return keysAllData;
    }
}
