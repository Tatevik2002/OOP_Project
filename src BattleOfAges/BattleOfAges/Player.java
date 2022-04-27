package BattleOfAges;
import BattleOfAges.*;

import BattleOfAges.Type.Type;
import BattleOfAges.Type.Type1;

public class Player extends PlayerMethods {
    private Age currentAge;
    private int ageIDinArray = 0;
    private int money;
    private int exp;
    private int timeNeededToUsePower; // seconds
    protected Warriors[] warriors = new Warriors[0];
    protected int CastleHealthNow = 100;
    Type[] Coordinates = new Type[1];
    int position;
    Player(int LeftOrRight, Warriors[] WarriorsArrayName){
        exp = 0;
        money = 500;
        currentAge = new Age(Main.arrayOfAges[0]);
        timeNeededToUsePower = 120; // seconds
        position = LeftOrRight;
    }

    public void usePower(Player opponent){
        Warriors[] listOfWarriors = opponent.getWarriors();
        for (int i= 0; i< listOfWarriors.length; i++){
            if (listOfWarriors[i].getCurrentHealth()-currentAge.getPower().getDamage()>0){
            listOfWarriors[i] = new Warriors((listOfWarriors[i].getCurrentHealth()-currentAge.getPower().getDamage()),
                    listOfWarriors[i].getAttack(),listOfWarriors[i].getPosition()) ;}
            else{
                PlayerMethods.changeArray(opponent);
            } // check exp and time before using power
        }
        exp = 0;
        timeNeededToUsePower += 120;
        // call power(player, currentAge);
    }
    public void ClickOnAge(){
        if(exp >= 1000){
            changeAge();
            return;
        }
        System.out.println("not enough exp");
    }
    private void changeAge(){
        if(ageIDinArray < 3){
            ageIDinArray++;
            currentAge = Main.arrayOfAges[ageIDinArray]; // karanq "new Age(Main.arrayOfAges[ageIDinArray])"- el anenq
        }
        else {
            System.out.println("last age reached");
        }
    }


//    public creatType1Unit(){
//        Type1 type1 = new Type1();
//        changeArray(Coordinates,1); // adds one length
//        Coordinates[Coordinates.length]= type1
//
//    }
    public Age getAge(){
        return new Age(currentAge.getImage(), currentAge.getHealthBonus(),
                currentAge.getAttackBonus(), currentAge.getPowerBonus(),currentAge.getCastleHealthBonus(), currentAge.getTurretDamageBonus(), currentAge.getCostBonus());
    }
    public Warriors[] getWarriors() {
        Warriors[] listOfWarriors = new Warriors[warriors.length];
        for(int i = 0; i< warriors.length;i++){
            listOfWarriors[i] = new Warriors(warriors[i].getCurrentHealth(),warriors[i].getAttack(),warriors[i].getPosition());
        }
        return listOfWarriors;
    }
    public void addWarriors(Warriors newWarrior) {
        this.warriors = changeArray(this, newWarrior);
    }
    //adds the newly created warrior to the player's warriors array.

    public int getCastleHealthNow() {
        return CastleHealthNow;
    }

    private void setCastleHealthNow(int castleHealthNow) {
        CastleHealthNow = castleHealthNow;
    }
}
