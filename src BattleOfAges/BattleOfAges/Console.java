package BattleOfAges;

import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.Type;

public class Console {
    void attack(){    }
    static Age Age1 = new Age(1,"background_age1.jpg",100,100, 10,1,2, 24);
    static Age Age2 = new Age(2,"background_age2.png",140,140, 14,2,2, 200);
    static Age Age3 = new Age(3,"background_age3.png",200,200, 20,3,2, 300);
    static Age Age4 = new Age(4,"background_age4.png",280,280, 28,4,2, 400);

    static Type Type1 = new Type(3,10,2,1, 100,1.25f,1);
    static Type Type2 = new Type(2,8, 3,2, 150,1.00f,2);
    static Type Type3 = new Type(4,15,1,1, 400,2.00f,3);

    static Turret  TypeOneTurret  = new Turret(Age1.getTurretDamageBonus());
    static Turret  TypeTwoTurret  = new Turret(Age2.getTurretDamageBonus());
    static Turret  TypeThreeTurret= new Turret(Age3.getTurretDamageBonus());
    static Turret  TypeFourTurret = new Turret(Age4.getTurretDamageBonus());

    public static Age[] arrayOfAges = {Age1, Age2,Age3, Age4};
    public static Turret[] arrayOfTurrets = {TypeOneTurret, TypeTwoTurret,TypeThreeTurret, TypeFourTurret};
    public static String[] arrayOfAgesBackgrounds = {"B1","B2","B3", "B4"};
    // public static String[] Powers = {"p1","p2","p3","p4"};

    public static int arrayCount = 0;
    protected Age getNextAge(){
        arrayCount ++;
        return arrayOfAges[arrayCount];
    }
    protected String getAgeBackground(){
        return arrayOfAgesBackgrounds[arrayCount];
    }
    protected String getUnitNameFromAgeAndType(int TypeNumber){
        return "A" + arrayCount + "T" + TypeNumber; //karanq player-i mech el gerenq [ "A" + player.currentAge.ageNumber() + "T" + selectedType ]
    }
    protected Turret getNextTurret(){
        return arrayOfTurrets[arrayCount];
    }
    static Warriors[] PlayerWarriors = new Warriors[0];
    static Warriors[] BotWarriors = new Warriors[0];
    static int position1 = 0;
    static int position2 = 0;
    static Player player = new Player("Left", PlayerWarriors); // player left
    static Player Bot    = new Player("Right", BotWarriors); // bot right
}
