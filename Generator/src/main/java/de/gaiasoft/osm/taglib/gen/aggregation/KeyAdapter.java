package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyStats;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyStatsData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.ProjectsKeysData;

public class KeyAdapter {
    private String key;
    private KeysAllData keysAllData;

    public KeyAdapter(String key) {
        this.key = key;
    }

    /**
     * Constructor for result of getKeyStats-REST interface
     * @param key Key
     * @param keyStats Result from getKeyStats
     */
    public KeyAdapter(String key, KeyStats keyStats) {
        this(key);
        keysAllData = new KeysAllData();
        keysAllData.setKey(key);
        for(KeyStatsData item: keyStats.getData()) {
            switch (item.getType()) {
                case "all":
                    keysAllData.setCount_all(item.getCount());
                    keysAllData.setCount_all_fraction(item.getCount_fraction());
                    break;
                case "nodes":
                    keysAllData.setCount_nodes(item.getCount());
                    keysAllData.setCount_nodes_fraction(item.getCount_fraction());
                    break;
                case "ways":
                    keysAllData.setCount_ways(item.getCount());
                    keysAllData.setCount_ways_fraction(item.getCount_fraction());
                    break;
                case "relations":
                    keysAllData.setCount_relations(item.getCount());
                    keysAllData.setCount_relations_fraction(item.getCount_fraction());
                    break;
            }
        }
    }

    /**
     * Constructor for result of getProjectKeys-REST interface
     * @param projectsKeysData Result from getProjectKeys
     */
    public KeyAdapter(ProjectsKeysData projectsKeysData) {
        this(projectsKeysData.getKey());
        keysAllData = new KeysAllData();
        keysAllData.setKey(projectsKeysData.getKey());
        keysAllData.setIn_wiki(projectsKeysData.getIn_wiki());
        keysAllData.setCount_all(projectsKeysData.getCount_all());
        keysAllData.setCount_all_fraction(projectsKeysData.getCount_all_fraction());
        keysAllData.setProjects(projectsKeysData.getProjects());
    }

    public KeyAdapter(KeysAllData keysAllData) {
        this(keysAllData.getKey());
        this.keysAllData = keysAllData;
    }

    public String getKey() {
        return key;
    }

    public KeysAllData getKeysAllData() {
        return keysAllData;
    }
}
