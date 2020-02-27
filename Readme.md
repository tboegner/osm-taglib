#OsmTagLib

The OsmTagLib is an attempt to provide a library with known and established OSM tags. The main criteria for the "established" state is the fact that the tag is discribed in the [map feature documentation](https://wiki.openstreetmap.org/wiki/Map_Features) in the OSM-wiki.

The tag definitions are generated with the help of the [TagInfo](https://taginfo.openstreetmap.org/) webservice.

The project consists of three separate submodules:
* TagInfo-[RestClient](RestClient/Readme.md)
* [Generator](Generator/Readme.md) for the library
* [Library](Library/Readme.md) with tag definitions

**TODO:**
* Include License (SW + Data)