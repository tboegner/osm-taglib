package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_OFFICE implements ValueBase {
    INSURANCE("insurance"),
    ADOPTION_AGENCY("adoption_agency"),
    CAMPING("camping"),
    ACCOUNTANT("accountant"),
    ENERGY_SUPPLIER("energy_supplier"),
    TAX_ADVISOR("tax_advisor"),
    QUANGO("quango"),
    TELECOMMUNICATION("telecommunication"),
    RESEARCH("research"),
    REALTOR("realtor"),
    DIPLOMATIC("diplomatic"),
    CHARITY("charity"),
    PARISH("parish"),
    HARBOUR_MASTER("harbour_master"),
    ADVERTISING_AGENCY("advertising_agency"),
    SUPERVISED_INJECTION_SITE("supervised_injection_site"),
    GUIDE("guide"),
    THERAPIST("therapist"),
    EMPLOYMENT_AGENCY("employment_agency"),
    SURVEYOR("surveyor"),
    TAX("tax"),
    IT("it"),
    MOVING_COMPANY("moving_company"),
    NOTARY("notary"),
    OCCUPATIONAL_SAFETY("occupational_safety"),
    NEWSPAPER("newspaper"),
    EDUCATIONAL_INSTITUTION("educational_institution"),
    COWORKING("coworking"),
    WATER_UTILITY("water_utility"),
    FINANCIAL("financial"),
    ARCHITECT("architect"),
    ASSOCIATION("association"),
    LOGISTICS("logistics"),
    FOUNDATION("foundation"),
    POLITICAL_PARTY("political_party"),
    GOVERNMENT("government"),
    PROPERTY_MANAGEMENT("property_management"),
    GEODESIST("geodesist"),
    NGO("ngo"),
    COMPANY("company"),
    ESTATE_AGENT("estate_agent"),
    REAL_ESTATE_AGENT("real_estate_agent"),
    LAWYER("lawyer"),
    TOURIST_ACCOMMODATION("tourist_accommodation"),
    CONSULTING("consulting"),
    YES("yes"),
    ENGINEER("engineer"),
    RELIGION("religion"),
    TRAVEL_AGENT("travel_agent"),
    BAIL_BOND_AGENT("bail_bond_agent"),
    ADMINISTRATIVE("administrative"),
    VISA("visa"),
    PRIVATE_INVESTIGATOR("private_investigator"),
    FORESTRY("forestry"),
    REGISTER("register"),
    ;

    private String value;
    Value_OFFICE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
