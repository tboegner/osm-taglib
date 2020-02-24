package de.gaiasoft.osm.taglib.gen.generation;

import de.gaiasoft.osm.taglib.gen.processing.InterpretationResult;

import java.util.Map;
import java.util.Set;

public interface TagLibGeneratorStrategy {
    void generateSourceCode(InterpretationResult interpretationResult);
}
