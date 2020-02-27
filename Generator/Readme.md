## Submodule Generator
The generator generates the enums with tag definitions for the library submodule.

The process consists of three steps:
* Data aggregation: relevant keys and known values for keys are determined. See the Aggregation-section for more details.
* Tag-Interpretation: Preparing data for generation step. See Interpretation-section.
* Generation of source-files with aggregated/interpreted data. See Generation-section.

### Aggregation
The aggregation is highly modular and done by multiple implementations of the `TagAggregatorStrategy` interface. The 
first intention was to aggregate keys and values by the TagInfo REST interface in combination with smart filters. This 
resulted in complicated, hard maintainable threshold logic executing many REST calls. These attempts resulted in many 
aggregators which are currently unused.  
Currently the relevant keys are aggregated by multiple csv-files (separated by osm-feature-sections in wiki) by the 
`FileKeySetNoValuesAggregator`. 
**TODO: describe value aggregation**

### Interpretation
The data collected from the aggregation step are processed and checked for plausibility. This step is done for each
section and the results are collected in the `InterpretationResult` data class. The result consists of three lists:
* Key-Definitions
* Value-Definitions
* Mappings from keys to values (known tags)

### Generation
The generation is done by reading in code templates and filling them with enum definitions of the processed data. The 
basic interface `TagLibGeneratorStrategy` can be implemented by multiple classes providing definitions for different 
languages. Currently only an implementation for java exists.

**ToDos + improvements**
* Make the generator runable by gradle task.
* Support for namespaces (enums defined but not used for generation)
  * Defined Namespaces are very rudimentary
  * Namespace can't be distinguished from normal subkey (type-discrepancy)
* Problem: sqlite-DB liegt lokal vor und veraltet.
* CSV-Ausgabe verbessern/ logs ablegen? Konfig?
* Stats in der Konsole lesbarer/verständlicher machen
* Check:
  KeySetCombinationsTagAggregator (getKeyStats? also for KeySetTagAggregator)
  AllKeysTagAggregator
  ProjectKeysTagAggregator
  



**Status der Aggregatoren:**
Der Sqllite-Aggregator erstellte zunächst alles, was im Wiki war. Das führte zu einem
values-Enum mit knapp 3000 Werten. Bei mehr als 2000 Werten kam es zu Compiler-Fehlern
in der TagLib.
*24.09.19:* Nun erzeugen wir nur noch die im Wiki erwähnten Map Features (https://wiki.openstreetmap.org/wiki/Map_Features)
als hart codierte Liste mit deren Values (aus der sqlite db) plus eine White-List an keys und deren values (REST).
Die Keys werden nun wieder in ein einziges Enum geschrieben, da die Trennung in Segmente das Handling der Keys
verkompliziert. Der intern wird die Trennung trotzdem vorgenommen, da es ggf. nochmal gebraucht werden könnte, z.B. weil
wir an die 2000er Grenze stoßen.
Falls ein Key dedizierte Values hat, werden diese in ein separates Werte Enum pro Key geschrieben.


**Veröffentlichung der TagLib:**
Noch ist unklar, wie die TagLib veröffentlicht wird. Wird der Generator OpenSource,
sodass jeder sich seine eigene Lib erstellen kann? Macht eine Versionierung dann Sinn?
Evtl. ja, dann haben wir eine Standard-Implementierung, von der jedermann abweichen kann.

***19.09.19:* Optionen zum Weitermachen:**
* Visitor-Pattern für KeySegements
* Key-Segements erweitern
* Gebräuchliche Combinations finden über REST
* Wrapper-Hilfsklasse für Enums schreiben (unter Berücksichtigung des SiteFinder)
* Aufräumen

**Evakuiert aus Key-Template:**
    Key#0#(String key, boolean allowShortKey) {
        this.key = key;
        if(allowShortKey && key.contains(":")) {
            String[] keyParts = key.split(":");
            shortKey = keyParts[keyParts.length-1];
        }
    }
