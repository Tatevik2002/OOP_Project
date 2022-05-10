
package BattleOfAges;
import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.*;
import jdk.jfr.Label;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.beancontext.BeanContextChild;

public class Bot extends Player{
    protected Player myEnemy = Console.player;
    protected String name = "Bot";

    Bot(String LeftOrRight){
        super("Right");
    }

    // WARRIORS
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
            return null; // will be handeled where it is used.
    }

    // Age,Castle,Type
    public Age getAge(){
        if (this.currentAge != null){
            return new Age(this.currentAge);
        }
        return Console.Age1;
    }
    public int getCastleHealthNow() {
        return castle.getCastleHealth();
    }
    private void setCastleHealthNow(int castleHealthNow) {
        if(!castle.changeCastleHealth(this)){
            System.out.println("the age wasn't able to change");
        }
    }

    // BARD METHODS
    public void ToBeOrNotToBe(){ // Bot-i hamar reverse gerel
        if(warriors.length > 0) {
            Warriors wEnemy = getClosestEnemyWarrior();
            Warriors wPlayer = warriors[warriors.length-1];
            if(wPlayer.getPositionX() - wEnemy.getPositionX() > 100){
                wPlayer.setPosition(wPlayer.getPositionX() - 100);
            }else if(wPlayer.getPositionX() - myEnemy.getCastlePosition()[0] < 101){
                if(myEnemy.castle.damageToCastle(wPlayer.getAttack()) == "Dead"){
                    System.out.println("the " + this.name + " has won the game.");
                    System.out.println("thank you for playing the game");
                    System.out.println("credits: Olga, Tatev, Gabriel");
                    System.exit(0);
                }
            }
            if(warriors.length > 1){ // for mooving all the warriors in the back
                int i = warriors.length-1;
                while(i > 0){
                    int frontWarriorX = warriors[i].getPositionX();
                    int backWarriorX = warriors[i-1].getPositionX();
                    if( backWarriorX - frontWarriorX > 100){
                        warriors[i-1].setPosition(warriors[i].getPositionX() - 100);
                    }
                    i--;
                }
            }
            // @HIT
            if (wEnemy != null){
                if (wEnemy.getPositionX() - wPlayer.getPositionX() < 100){
                    System.out.println("hit ara ara");
                    wEnemy.setCurrentHealth(wPlayer.getAttack());
                    wPlayer.setCurrentHealth(wEnemy.getAttack());
                    if (wPlayer.getCurrentHealth() <= 0){
                        this.changeArray();
                    }
                    if(wEnemy.getCurrentHealth() <= 0){
                        this.exp += wEnemy.getThisType().getExp();
//                        this.money += (int)(wEnemy.getCost() * 1.2);
                        myEnemy.changeArray();
                    }
                    if(wEnemy.getCurrentHealth() <= 0){
                        myEnemy.changeArray();
                    }
                }
            }
        }
    }
    public void tryUsingPower(){
        int leastPossibleExpToBeInThisAge = this.currentAge.getAgeNumber() * 24;
        float expConsumedToUsePower = 24*0.4f;

        if(this.exp >= leastPossibleExpToBeInThisAge + expConsumedToUsePower){
            this.exp -= expConsumedToUsePower;
            EnemyWarriors = myEnemy.getMyWarriorArray();
            int damageDone = new Warriors(this.currentAge,Console.Type2,0).getMaxhealth();
            for (int i= 0; i < myEnemy.getMyWarriorLength() - 1; i++){
                if (EnemyWarriors[i].getCurrentHealth()-damageDone > 0)
                    EnemyWarriors[i].setCurrentHealth(damageDone);
                else
//                    this.money += (int)(EnemyWarriors[i].getCost() * 1.2);
                    myEnemy.changeArray(i);
            }
        }
        else
            System.out.println("not enough exp" + "\n" + (leastPossibleExpToBeInThisAge + expConsumedToUsePower) + " exp needed" );
    }
    public void tryUpgradingAge(){
        int n = this.currentAge.getAgeNumber() + 1;
        if (n >= 5) {
            System.out.println("last age reached");
        } else if (exp >= 24 * n) {
            currentAge = Console.arrayOfAges[this.currentAge.getAgeNumber() + 1];
        } else
            System.out.println("not enough exp");
    }
    public void tryCreatingTurret(){
        int cost = Console.arrayOfTurrets[currentAge.getAgeNumber()-1].getCost();;
//        if(this.money >= cost){
//            turretAge = currentAge.getAgeNumber();
//        }
    }
    public void tryCreatingUnit(Type type){
        if (this.warriors.length <= 7){
            Warriors warrior = new Warriors(currentAge,type,-90);
//            if(money >= warrior.getCost()){
//                this.money -= warrior.getCost();
//                this.addWarriors(warrior);
//            }else{
//                System.out.println("not enough money, you need " + warrior.getCost());
//            }
        }else{
            System.out.println("you have reached maximum capacity of 7 warriors");
        }
    }


    // PRIMITIVE GETTERS (may not be used)
    public void setDamageFirstWarriorHealth(int damageToWarrior) {
        warriors[0].setCurrentHealth(damageToWarrior);
        if(warriors[0].getCurrentHealth() < 1) {
            this.changeArray();
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
    public int[] getCastlePosition() {
        return castlePosition;
    }
    public void addWarriors(Warriors newWarrior) {
        this.changeArray(newWarrior);
    }
    //adds the newly created warrior to the player's warriors array.
}
