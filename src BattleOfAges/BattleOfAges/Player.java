package BattleOfAges;
import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.beancontext.BeanContextChild;

public class Player {
    private Age currentAge;
    private int ageIDinArray = 0;
    private int money;
    private float exp;
    private int timeNeededToUsePower; // seconds
    protected Warriors[] warriors = new Warriors[0];
    protected Castle castle = new Castle(this);
    //    Type[] Coordinates = new Type[1];
    Player myEnemy = Console.Bot;
    int[] castlePosition = new int[2];
    Warriors[] EnemyWarriors;

    Player(String LeftOrRight, Warriors[] WarriorsArrayName){
        exp = 0;
        money = 500;
        currentAge = new Age(Console.arrayOfAges[0]);
        timeNeededToUsePower = 120; // seconds
        if(LeftOrRight == "Left"){
            castlePosition[0] = -60;
            castlePosition[1] = 480;
        }else if(LeftOrRight == "Right"){
            castlePosition[0] = 1080-60;
            castlePosition[1] = 480;
        }
        else   {
            System.out.println("wrong position input, try capital letters");
            System.exit(0);
        }
    }

    public void changeArray(Player player){ // jnjuma warrior[0]
        int newLength = player.warriors.length - 1;
        Warriors[] newArray = new Warriors[newLength];
        for (int i = 1; i < Console.player.warriors.length - 1; i++)
            newArray[i-1] = player.warriors[i]; //OBOE danger
        this.warriors = newArray;
    }
    public Warriors[] changeArray(Player player, int index){ // jnjuma mi hat warrior[i]
        int newLength = player.warriors.length - 1;
        Warriors[] newArray = new Warriors[newLength];
        Warriors[] copyArray = new Warriors[newLength];
        for (int i = 0, j=0; i < player.warriors.length; i++)
        // petqa grel
        {
            if (i == index){
                continue;
            }
            newArray[i] = player.warriors[i-1];
            copyArray[i]= new Warriors(player.warriors[i-1]);
        }
        this.warriors = newArray;
        return newArray;
    }
    public Warriors[] changeArray(Player player,Warriors newWarrior) { // avelacnuma mi hat warrior
        int newLength = player.warriors.length + 1;
        Warriors[] copyArray = new Warriors[newLength];
        Warriors[] newArray = new Warriors[newLength];
        for (int i = 0; i < player.warriors.length; i++) {
            newArray[i] = player.warriors[i];
            copyArray[i]= new Warriors(player.warriors[i]);
        }
        newArray[newLength - 1] = newWarrior;
        copyArray[newLength - 1] = new Warriors(newWarrior);
        this.warriors = newArray;
        return newArray;
    }
    public Warriors[] getMyWarriorArray(){
        return warriors;
    }
    public Warriors getMyWarrior(int id){
        return warriors[id];
    }
    public int getMyWarriorLength(){
        return warriors.length;
    }
    public Warriors getEnemyWarrior(int id){
        return myEnemy.getMyWarrior(id);
    }
    public Warriors getClosestEnemyWarrior(){
        if (myEnemy.warriors.length != 0)
            return myEnemy.getMyWarrior(Console.Bot.getMyWarriorLength() - 1);
        else
            return null;
    }
    public void ToBeOrNotToBe(){
        if(warriors.length > 0)
        for(int i = 0; i < warriors.length; i++){
            Warriors w = getClosestEnemyWarrior();
            int myX = warriors[i].getPositionX();
            if (w != null){
                if (w.getPositionX() - myX <100)
                    System.out.println("hit ara ara");
            }
            warriors[i].setPosition(warriors[i].getPositionX() + 100);
        }
    }

    public void tryUsingPower(){
        int leastPossibleExpToBeInThisAge = this.currentAge.getAgeNumber() * 24;
        float expConsumedToUsePower = 24*0.4f;

        if(this.exp >= leastPossibleExpToBeInThisAge + expConsumedToUsePower){
            this.exp -= expConsumedToUsePower;
            EnemyWarriors = myEnemy.getMyWarriorArray();
            int damageDone = new Warriors(this.currentAge,Console.Type2, 0).getMaxhealth();
            for (int i= 0; i < myEnemy.getMyWarriorLength() - 1; i++){
                if (EnemyWarriors[i].getCurrentHealth()-damageDone > 0)
                    EnemyWarriors[i].setCurrentHealth(damageDone);
                else
                    changeArray(myEnemy,i);
            }
        }
        else
            System.out.println("not enough exp" + "\n" + (leastPossibleExpToBeInThisAge + expConsumedToUsePower) + " exp needed" );
    }
    public void tryUpgradingAge() {
        int n = this.currentAge.getAgeNumber() + 1;
        if (n >= 5) {
            System.out.println("last age reached");
        } else if (exp >= 24 * n) {
            currentAge = Console.arrayOfAges[this.currentAge.getAgeNumber() + 1];
        } else
            System.out.println("not enough exp");
    }


    public void addWarriors(Warriors newWarrior) {
        this.warriors = changeArray(this, newWarrior);
    }
    //adds the newly created warrior to the player's warriors array.

//        public creatType1Unit(){
//        Type1 type1 = new Type1();
//        changeArray(Coordinates,1); // adds one length
//        Coordinates[Coordinates.length]= type1
//    }

    public Age getAge(){
        return new Age(currentAge.getAgeNumber(), currentAge.getImage(), currentAge.getHealthBonus(),
                currentAge.getAttackBonus(), currentAge.getPowerBonus(),currentAge.getCastleHealthBonus(),
                currentAge.getTurretDamageBonus(), currentAge.getExpCost());
    }
    public int getCastleHealthNow() {
        return castle.getCastleHealth();
    }
    private void setCastleHealthNow(int castleHealthNow) {
        if(!castle.changeCastleHealth(this)){
            System.out.println("the age wasn't able to change");
        }
    }


    public void setDamageFirstWarriorHealth(int damageToWarrior) {
        warriors[0].setCurrentHealth(damageToWarrior);
        if(warriors[0].getCurrentHealth() < 1) {
            changeArray(this);
        }
    }
    protected Age getNextAge(){
        if(this.currentAge.getAgeNumber() < 3){
            Console.arrayCount++;
            return Console.arrayOfAges[Console.arrayCount];
        }
        else {
            return null;
        }
    }
    protected void setNextAge(){
        if(getNextAge() != null){
            currentAge = getNextAge();
        }
    }
    protected Turret getNextTurret() {
        return Console.arrayOfTurrets[Console.arrayCount];
    }
}


/*  public Warriors getFirstWarrior() {
////        Warriors copyWarrior = new Warriors(warriors[0]);
////        return copyWarrior;
    }*/

/* public Warriors[] getWarriors() {
        Warriors[] listOfWarriors = new Warriors[warriors.length];
        for(int i = 0; i< warriors.length;i++){
            listOfWarriors[i] = new Warriors(warriors[i].getCurrentHealth(),warriors[i].getAttack(),warriors[i].getPosition());
        }
        return listOfWarriors;
    } */