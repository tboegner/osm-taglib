package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.gen.util.ConfigManager;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;

import java.sql.*;
import java.util.*;

public class SqliteTagAggregator implements TagAggregatorStrategy {
    private static final String dbFileName = ConfigManager.getInstance().getInputDir()+"taginfo-wiki.db";
    private Set<String> inputKeySet;

    public SqliteTagAggregator(Set<String> inputKeySet) {
        this.inputKeySet = inputKeySet;
    }

    private Map<String, List<KeyValuesData>> loadKeyValuesMap(Connection conn) throws SQLException {
        Map<String, List<KeyValuesData>> keyValuesMap = new HashMap<>();
        String query = "select key, value from wikipages_tags" + getInputKeysAsInClause();
        ResultSet rs = conn.createStatement().executeQuery(query);
        List<KeyValuesData> valueList;
        KeyValuesData valueData;
        while (rs.next()) {
            String key = rs.getString("key");
            valueList = keyValuesMap.computeIfAbsent(key, k -> new ArrayList<>());
            valueData = new KeyValuesData();
            valueData.setValue(rs.getString("value"));
            valueData.setIn_wiki(true);
            valueList.add(valueData);
        }
        return keyValuesMap;
    }

    private Set<KeysAllData> loadKeySet(Connection conn) {
        Set<KeysAllData> keySet = new HashSet<>();
        KeysAllData keyData;
        for (String key : inputKeySet) {
            keyData = new KeysAllData();
            keyData.setKey(key);
            keyData.setIn_wiki(true);
            keySet.add(keyData);
        }
        return keySet;
    }

    private String getInputKeysAsInClause() {
        StringBuilder sb = new StringBuilder(" where key in (");
        boolean first = true;
        for (String key : inputKeySet) {
            if(first) {
               first = false;
            } else {
                sb.append(",");
            }
            sb.append("'").append(key).append("'");
        }
        sb.append(");");
        return sb.toString();
    }

    @Override
    public AggregationResult aggregateTagData() {
        AggregationResult result = new AggregationResult();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);
            result.keyValueMappings = loadKeyValuesMap(conn);
            result.keySet = loadKeySet(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
