## Submodule Generator
The generator generates the enums with tag definitions for the library submodule.

The process consists of three steps:
* Data aggregation: relevant keys and known values for keys are determined. See the Aggregation-section for more details.
* Tag-Interpretation: Preparing data for generation step. See Interpretation-section.
* Generation of source-files with aggregated/interpreted data. See Generation-section.

### Aggregation
The aggregation is highly modular and done by multiple implementations of the `TagAggregatorStrategy` interface. The 
first intention was to aggregate keys and values by the TagInfo REST interface in combination with smart filters. This 
resulted in complicated, hard maintainable threshold logic executing many REST calls. These attempts lead to many 
aggregators which are currently unused.  
Currently the relevant keys are aggregated by multiple csv-files (separated by osm-feature-sections in wiki) by the 
`FileKeySetNoValuesAggregator`. 
For the sections 'Primary' and 'Property' the known values are determined via the rest interface. The acceptance
criteria are that a value is mentioned in wiki and has a minimum percentage of occurrence with its key.
The sections 'Address', 'Name' and 'Annotation' are expected to have no known distinct values, therefore no value 
detection is done.
The Values for keys from the 'Whitelist' don't have to be in wiki, they can qualify by high percentage of occurrence. 

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
* Enable also free values for a key if known values are detected by a control flag -> type information for keys needed
* Enable usage thresholds for values per input key.  
* Check:
  KeySetCombinationsTagAggregator (getKeyStats?)
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

