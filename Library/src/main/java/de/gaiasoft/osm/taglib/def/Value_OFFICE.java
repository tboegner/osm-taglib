package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_OFFICE implements ValueBase {
    INSURANCE("insurance"),
    NEWSPAPER("newspaper"),
    MEDICAL("medical"),
    EDUCATIONAL_INSTITUTION("educational_institution"),
    ACCOUNTANT("accountant"),
    COWORKING("coworking"),
    WATER_UTILITY("water_utility"),
    TAX_ADVISOR("tax_advisor"),
    ENERGY_SUPPLIER("energy_supplier"),
    FINANCIAL("financial"),
    ARCHITECT("architect"),
    ASSOCIATION("association"),
    LOGISTICS("logistics"),
    FOUNDATION("foundation"),
    QUANGO("quango"),
    TELECOMMUNICATION("telecommunication"),
    RESEARCH("research"),
    POLITICAL_PARTY("political_party"),
    SECURITY("security"),
    GOVERNMENT("government"),
    PROPERTY_MANAGEMENT("property_management"),
    CHARITY("charity"),
    GEODESIST("geodesist"),
    NGO("ngo"),
    HARBOUR_MASTER("harbour_master"),
    COMPANY("company"),
    ESTATE_AGENT("estate_agent"),
    ADVERTISING_AGENCY("advertising_agency"),
    LAWYER("lawyer"),
    GUIDE("guide"),
    YES("yes"),
    CONSULTING("consulting"),
    EMPLOYMENT_AGENCY("employment_agency"),
    SURVEYOR("surveyor"),
    TAX("tax"),
    IT("it"),
    ENGINEER("engineer"),
    RELIGION("religion"),
    MOVING_COMPANY("moving_company"),
    NOTARY("notary"),
    FORESTRY("forestry"),
    GRAPHIC_DESIGN("graphic_design"),
    ;

    private String value;
    Value_OFFICE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
