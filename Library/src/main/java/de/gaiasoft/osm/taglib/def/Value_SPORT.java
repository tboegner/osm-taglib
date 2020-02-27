package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_SPORT implements ValueBase {
    DANCING("dancing"),
    POLE_DANCE("pole_dance"),
    EQUESTRIAN("equestrian"),
    BOBSLEIGH("bobsleigh"),
    CANOE("canoe"),
    SHOOTING("shooting"),
    CANOE_POLO("canoe_polo"),
    CYCLING("cycling"),
    BILLARDS("billards"),
    TABLE_SOCCER("table_soccer"),
    WATER_POLO("water_polo"),
    GAELIC_GAMES("gaelic_games"),
    MULTI("multi"),
    COCKFIGHTING("cockfighting"),
    OBSTACLE_COURSE("obstacle_course"),
    DISC_GOLF("disc_golf"),
    DIVING("diving"),
    KARATE("karate"),
    ROWING("rowing"),
    SAFETY_TRAINING("safety_training"),
    BEACHVOLLEYBALL("beachvolleyball"),
    FIELD_HOCKEY("field_hockey"),
    CURLING("curling"),
    HIGH_ROPE_COURSE("high_rope_course"),
    JUDO("judo"),
    BILLIARDS("billiards"),
    PADEL("padel"),
    TAEKWONDO("taekwondo"),
    WEIGHTLIFTING("weightlifting"),
    ASSOCIATION_FOOTBALL("association_football"),
    AUSTRALIAN_FOOTBALL("australian_football"),
    HORSESHOES("horseshoes"),
    SHOOTING_RANGE("shooting_range"),
    BASEBALL("baseball"),
    VOLLEYBALL("volleyball"),
    ARCHERY("archery"),
    MOTOR("motor"),
    GAELIC_FOOTBALL("gaelic_football"),
    PELOTA("pelota"),
    _8PIN("8pin"),
    BOWLS("bowls"),
    ICE_HOCKEY("ice_hockey"),
    YOGA("yoga"),
    SCUBA_DIVING("scuba_diving"),
    LASER_TAG("laser_tag"),
    CROQUET("croquet"),
    SWIMMING("swimming"),
    WINDSURFING("windsurfing"),
    GOLF("golf"),
    RACQUET("racquet"),
    RUGBY_LEAGUE("rugby_league"),
    NINE_MENS_MORRIS("nine_mens_morris"),
    HOCKEY("hockey"),
    SKIING("skiing"),
    BADMINTON("badminton"),
    BALLE_PELOTE("balle_pelote"),
    GYMNASTICS("gymnastics"),
    CLIMBING_ADVENTURE("climbing_adventure"),
    PARACHUTING("parachuting"),
    TENNIS("tennis"),
    CRICKET_NETS("cricket_nets"),
    TABLE_TENNIS("table_tennis"),
    TEAM_HANDBALL("team_handball"),
    BANDY("bandy"),
    CRICKET("cricket"),
    TOBOGGAN("toboggan"),
    ORIENTEERING("orienteering"),
    DARTS("darts"),
    LACROSSE("lacrosse"),
    SURFING("surfing"),
    BMX("bmx"),
    FUTSAL("futsal"),
    LONG_JUMP("long_jump"),
    FREE_FLYING("free_flying"),
    ICE_SKATING("ice_skating"),
    BASKETBALL("basketball"),
    FITNESS("fitness"),
    TRAMPOLINE("trampoline"),
    CLIMBING("climbing"),
    BATTING_CAGE("batting_cage"),
    MODEL_AERODROME("model_aerodrome"),
    CHESS("chess"),
    KRACHTBAL("krachtbal"),
    RUGBY("rugby"),
    _9PIN("9pin"),
    WATER_SKI("water_ski"),
    PAINTBALL("paintball"),
    CLIFF_DIVING("cliff_diving"),
    ROLLER_SKATING("roller_skating"),
    SUMO("sumo"),
    BOXING("boxing"),
    SAILING("sailing"),
    ICE_STOCK("ice_stock"),
    DOG_RACING("dog_racing"),
    SKATEBOARD("skateboard"),
    KITESURFING("kitesurfing"),
    NETBALL("netball"),
    FIVES("fives"),
    RUNNING("running"),
    KORFBALL("korfball"),
    PADDLE_TENNIS("paddle_tennis"),
    PARAGLIDING("paragliding"),
    ROLLER_HOCKEY("roller_hockey"),
    _10PIN("10pin"),
    CANADIAN_FOOTBALL("canadian_football"),
    RUGBY_UNION("rugby_union"),
    BOULES("boules"),
    BULLFIGHTING("bullfighting"),
    SOCCER("soccer"),
    FOOTBALLGOLF("footballgolf"),
    SKATING("skating"),
    MOTOCROSS("motocross"),
    HAPKIDO("hapkido"),
    FOOTBALL("football"),
    HORSE_RACING("horse_racing"),
    AIKIDO("aikido"),
    RC_CAR("rc_car"),
    AMERICAN_FOOTBALL("american_football"),
    HANDBALL("handball"),
    POLO("polo"),
    KARTING("karting"),
    ATHLETICS("athletics"),
    WRESTLING("wrestling"),
    BASE("base"),
    FENCING("fencing"),
    ;

    private String value;
    Value_SPORT(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}