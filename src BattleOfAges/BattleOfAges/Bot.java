
package BattleOfAges;
import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.*;
import jdk.jfr.Label;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.beancontext.BeanContextChild;

public class Bot extends Player{
    protected Player myEnemy = null;
    protected String name = "Bot";

    Bot(String LeftOrRight){
        super(LeftOrRight);
    }

    public  void setMyEnemy(Object myEnemy) {
       Player playerReference = new Player("Left");
        if (myEnemy ==  null){
            System.out.println("The enemy is null");
        }
        else if (myEnemy.getClass()== playerReference.getClass()){
            this.myEnemy = (Player)myEnemy;

        }
        else{
            System.out.println("Another object");
        }

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
            return myEnemy.getMyWarrior(Console.player.getMyWarriorLength() - 1);
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
    public void ToBeOrNotToBe(){
        if(warriors.length > 0) {
            Warriors wPlayer = warriors[warriors.length-1];
            if(Console.bot.getMyWarriorLength() > 0) {
                if (!(getClosestEnemyWarrior() == null)) {
                Warriors wEnemy = getClosestEnemyWarrior();
                if (wPlayer.getPositionX() - wEnemy.getPositionX() > 100) {
                    wPlayer.setPosition(wPlayer.getPositionX() - 100);
                    System.out.println("first player warrior moved from " + wPlayer.getPositionX());
                } else if (wPlayer.getPositionX() - myEnemy.getCastlePosition()[0] < 101) {
                    if (myEnemy.castle.damageToCastle(wPlayer.getAttack()) == "Dead") {
                        System.out.println("the " + this.name + " has won the game.");
                        System.out.println("thank you for playing the game");
                        System.out.println("credits: Olga, Tatev, Gabriel");
                        System.exit(0);
                    }
                }
            }
            }
            else{
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
    }
    public void tryUpgradingAge(){
        int n = this.currentAge.getAgeNumber() + 1;
        if (n >= 4) {
            System.out.println("last age reached");
        } else if (exp >= 24 * n) {
            System.out.println(this.currentAge.getAgeNumber());
            currentAge = Console.arrayOfAges[this.currentAge.getAgeNumber() + 1];
            if( Math.random()*100 > 95  ){
                this.tryUsingPower();
            }

        } else
            System.out.println("not enough exp");
    }
    public void tryCreatingTurret(){
        int cost = Console.arrayOfTurrets[currentAge.getAgeNumber()-1].getCost();;
//        if(this.money >= cost){
//            turretAge = currentAge.getAgeNumber();
//        }
    }
    public void tryCreatingUnit(){
        if (this.warriors.length <= 7){
            int a = (int)Math.round(Math.random()*10);
            if(a <5){
                Warriors warrior = new Warriors(currentAge,Console.Type3,1320);
                this.exp += (int)(warrior.getExp()*9/10);
                this.addWarriors(warrior);
            }else if(a<4){
                Warriors warrior = new Warriors(currentAge,Console.Type2,1320);
                this.exp += (int)(warrior.getExp()*9/10);
                this.addWarriors(warrior);
            }else if(a<3){
                Warriors warrior = new Warriors(currentAge,Console.Type1,1320);
                this.exp += (int)(warrior.getExp()*9/10);
                this.addWarriors(warrior);
            }
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
