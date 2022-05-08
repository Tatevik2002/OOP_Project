package BattleOfAges;

import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.Type;
import BattleOfAges.Type.Type1;
import BattleOfAges.Type.Type2;
import BattleOfAges.Type.Type3;

public class Console {
    void attack(){    }
    static Age Age1 = new Age(1,"img1",100,100, 10,1,2, 100);
    static Age Age2 = new Age(2,"img2",140,140, 14,2,2, 200);
    static Age Age3 = new Age(3,"img3",200,200, 20,3,2, 300);
    static Age Age4 = new Age(4,"img4",280,280, 28,4,2, 400);

    static Type Type1 = new Type(3,10,2,1, 100);
    static Type Type2 = new Type(5,8, 3,2, 200);
    static Type Type3 = new Type(8,30,1,1, 400);

    static Turret TypeOneTurret  = new Turret(Age1.getTurretDamageBonus());
    static Turret  TypeTwoTurret  = new Turret(Age2.getTurretDamageBonus());
    static Turret TypeThreeTurret = new Turret(Age3.getTurretDamageBonus());
    static Turret  TypeFourTurret = new Turret(Age4.getTurretDamageBonus());

    public static Age[] arrayOfAges = {Age1, Age2,Age3, Age4};
    public static Turret[] arrayOfTurrets = {TypeOneTurret, TypeTwoTurret,TypeThreeTurret, TypeFourTurret};
    public static String[] arrayOfAgesBackgrounds = {"B1","B2","B3", "B4"};

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
    static Player player = new Player(position1, PlayerWarriors); // player left
    static Player Bot    = new Player(position2, BotWarriors); // bot right
    public BattleOfAges.Type.Type1 type1 = new Type1();
    public BattleOfAges.Type.Type2 type2 = new Type2();
    public BattleOfAges.Type.Type3 type3 = new Type3();
}
