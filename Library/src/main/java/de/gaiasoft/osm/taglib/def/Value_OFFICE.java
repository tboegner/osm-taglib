package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_OFFICE implements ValueBase {
    INSURANCE("insurance"),
    MEDICAL("medical"),
    ACCOUNTANT("accountant"),
    TAX_ADVISOR("tax_advisor"),
    ENERGY_SUPPLIER("energy_supplier"),
    QUANGO("quango"),
    TELECOMMUNICATION("telecommunication"),
    RESEARCH("research"),
    CHARITY("charity"),
    HARBOUR_MASTER("harbour_master"),
    ADVERTISING_AGENCY("advertising_agency"),
    GUIDE("guide"),
    EMPLOYMENT_AGENCY("employment_agency"),
    SURVEYOR("surveyor"),
    TAX("tax"),
    IT("it"),
    MOVING_COMPANY("moving_company"),
    NOTARY("notary"),
    COURIER("courier"),
    PUBLISHER("publisher"),
    GRAPHIC_DESIGN("graphic_design"),
    NEWSPAPER("newspaper"),
    EDUCATIONAL_INSTITUTION("educational_institution"),
    WATER_UTILITY("water_utility"),
    COWORKING("coworking"),
    FINANCIAL("financial"),
    UNIVERSITY("university"),
    ARCHITECT("architect"),
    ASSOCIATION("association"),
    LOGISTICS("logistics"),
    FOUNDATION("foundation"),
    POLITICAL_PARTY("political_party"),
    HEALTHCARE("healthcare"),
    SECURITY("security"),
    GOVERNMENT("government"),
    PROPERTY_MANAGEMENT("property_management"),
    GEODESIST("geodesist"),
    NGO("ngo"),
    COMPANY("company"),
    ESTATE_AGENT("estate_agent"),
    LAWYER("lawyer"),
    YES("yes"),
    CONSULTING("consulting"),
    UNION("union"),
    ENGINEER("engineer"),
    RELIGION("religion"),
    TRAVEL_AGENT("travel_agent"),
    BAIL_BOND_AGENT("bail_bond_agent"),
    PRIVATE_INVESTIGATOR("private_investigator"),
    FORESTRY("forestry"),
    FINANCIAL_ADVISOR("financial_advisor"),
    ;

    private String value;
    Value_OFFICE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
