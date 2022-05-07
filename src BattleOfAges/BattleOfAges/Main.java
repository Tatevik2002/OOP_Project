package BattleOfAges;

import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.Type;
import BattleOfAges.Type.*;

public class Main {
    int arrayCount = 0;
    static Age[] arrayOfAges;
    static Turret[] arrayOfTurrets;
    public static void Main(String[] args) {

        Age Age1 = new Age("img1", 100, 100, 10, 1, 2, 100);
        Age Age2 = new Age("img2", 140, 140, 14, 2, 2, 200);
        Age Age3 = new Age("img3", 200, 200, 20, 3, 2, 300);
        Age Age4 = new Age("img4", 280, 280, 28, 4, 2, 400);

        Type Type1 = new Type(3, 10, 2, 1, 100);
        Type Type2 = new Type(5, 8, 3, 2, 200);
        Type Type3 = new Type(8, 30, 1, 1, 400);

        Turret TypeOneTurret = new Turret(Age1.getTurretDamageBonus());
        Turret TypeTwoTurret = new Turret(Age2.getTurretDamageBonus());
        Turret TypeThreeTurret = new Turret(Age3.getTurretDamageBonus());
        Turret TypeFourTurret = new Turret(Age4.getTurretDamageBonus());
        arrayOfTurrets = new Turret[4];
        arrayOfAges = new Age[4];
        arrayOfAges[0]= Age1;
        arrayOfAges[1]= Age2;
        arrayOfAges[2]= Age2;
        arrayOfAges[3]= Age4;
        arrayOfTurrets[0]= TypeOneTurret;
        arrayOfTurrets[1]= TypeTwoTurret;
        arrayOfTurrets[2]= TypeThreeTurret;
        arrayOfTurrets[3]= TypeFourTurret;


        Warriors[] PlayerWarriors = new Warriors[0];
        Warriors[] BotWarriors = new Warriors[0];
        int position1 = 0;
        int position2 = 0;
        Player player = new Player(position1, PlayerWarriors); // player left
        Player Bot = new Player(position2, BotWarriors); // bot right
        //    Warriors[] botWar = Bot.WarriosArray;
        Type1 type1 = new Type1();
        Type2 type2 = new Type2();
        Type3 type3 = new Type3();
        MyFrame myFrame = new MyFrame();


    }
    protected Age getNextAge(){
        arrayCount++;
        return arrayOfAges[arrayCount];
    }
    protected Turret getNextTurret() {
        return arrayOfTurrets[arrayCount];
    }}
