package BattleOfAges;

import BattleOfAges.Type.*;

public class Warriors {
    //
//    public Type1 type1 = new Type1(); //
//    public Type2 type2 = new Type2(); //
//    public Type3 type3 = new Type3(); //
    private Age thisAge;
    private Type thisType;
    private int maxhealth  ;
    private int currentHealth;
    private int attack;
    private int positionX = 150;
    private int cost ;
    public Warriors(Age thisAge,Type thisType,int positionOfX) {
        this.thisAge = thisAge;
        this.thisType = thisType;
        this.positionX = positionOfX;
        this.maxhealth = thisType.getHealth() * thisAge.getHealthBonus();
        this.currentHealth = maxhealth;
        this.attack = thisType.getAttack() * thisAge.getAttackBonus();
        this.cost= (int)(thisType.getCost() * (1 + thisAge.getAgeNumber()*0.1f));
    }
    public Warriors(Warriors other){
        this.thisAge = other.thisAge;
        this.thisType = other.thisType;
        this.positionX = other.positionX;
        this.attack= other.attack;
        this.maxhealth = other.maxhealth;
        this.currentHealth = other.currentHealth;
        this.cost = other.cost;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    public int getAttack() {
        return attack;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getMaxhealth() {
        return maxhealth;
    }
    public float getExp(){return thisType.getExp();}
    public int getCost() {
        return cost;
    }
    public void setCurrentHealth(int damageTaken) {
        this.currentHealth -= damageTaken;
    }
    public void setPosition(int X) {
        this.positionX = X;
    }
    public Age getAge(){
        return new Age(this.thisAge);

    }
    public Type getThisType(){
        return new Type(this.thisType);
    }
}
