package BattleOfAges;

import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.TurretTypes.TypeOneTurret;
import BattleOfAges.TurretTypes.TypeThreeTurret;
import BattleOfAges.TurretTypes.TypeTwoTurret;
import BattleOfAges.Type.Type;
import BattleOfAges.Type.*;

public class Main {

    static Age Age1 = new Age("img1",100,100, 10,1);
    static Age Age2 = new Age("img2",140,140, 14,2);
    static Age Age3 = new Age("img3",200,200, 20,3);
    static Age Age4 = new Age("img4",280,280, 28,4);

    static Type Type1 = new Type(3,10,2,1, 100);
    static Type Type2 = new Type(5,8, 3,2 , 200);
    static Type Type3 = new Type(8,30,1,1, 400);

    static Turret  TypeOneTurret  = new TypeOneTurret();
    static Turret  TypeTwoTurret  = new TypeTwoTurret();
    static Turret TypeThreeTurret = new TypeThreeTurret(); // senc cheyir uzum sarqeyir @ Ofeli ?


    public static Age[] arrayOfAges = {Age1, Age2,Age3, Age4};
    public int arraycount = 0;
    protected Age getNextAge(){
        arraycount ++;
        return arrayOfAges[arraycount];
    }
    static Warriors[] PlayerWarriors = new Warriors[0];
    static Warriors[] BotWarriors = new Warriors[0];
    static int position1 = 5;
    static int position2 = 0;
    static Player player = new Player(position1, PlayerWarriors); // player left
    static Player Bot    = new Player(position2, BotWarriors); // bot right
    //    Warriors[] botWar = Bot.WarriosArray;
    public Type1 type1 = new Type1();
    public Type2 type2 = new Type2();
    public Type3 type3 = new Type3();


}
