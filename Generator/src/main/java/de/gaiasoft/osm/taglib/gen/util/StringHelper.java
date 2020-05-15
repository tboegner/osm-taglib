package de.gaiasoft.osm.taglib.gen.util;

import org.apache.commons.lang3.CharUtils;

public class StringHelper {
    public static StringBuilder appendSpaces(StringBuilder sb, int count) {
        for(int i=0; i<count; ++i) {
            sb.append(' ');
        }
        return sb;
    }

    public static String toConstantDefinition(String name) {
        String constDef = name.replaceAll("[:;-]", "_").toUpperCase();
        if(CharUtils.isAsciiNumeric(constDef.charAt(0))) {
            return "_" + constDef;
        }
        return constDef;
    }

}
