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
The key definitions are generated into one single enum. For a high number of keys, this can be problematic. In Java 8
more than 2000 enum values in a single enum lead to a compiler error in the library.

###ToDos + improvements
* Make the generator runable by gradle task.
* Support for namespaces (enums defined but not used for generation)
  * Defined Namespaces are very rudimentary
  * Namespace can't be distinguished from normal subkey (type-discrepancy)
* Enable also free values for a key (by a key-specific setting, type information for keys needed), even if known values are detected 
* Enable usage thresholds for values per input key.
