package BattleOfAges;

import BattleOfAges.Type.*;

public class Warriors {
    //
//    public Type1 type1 = new Type1(); //
//    public Type2 type2 = new Type2(); //
//    public Type3 type3 = new Type3(); //
    private Age thisAge; // laves arel
    private Type thisType; // laves arel
    private int maxhealth = thisType.getHealth() * thisAge.getHealthBonus(); // laves arel
    private int currentHealth = maxhealth; // laves arel
    private int attack = thisType.getAttack() * thisAge.getAttackBonus();// laves arel
    private int[] position = {0,0}; // laves arel

    public Warriors(Age thisAge,Type thisType,int[] position) { // laves arel
        this.thisAge = thisAge;
        this.thisType = thisType;
        this.position = position;
    }
    public Warriors(int currentHealth,int Attack,int[] position) { // xi 2rd constructor, eti yeselem asum xi 2nd constructor?
        this.currentHealth = currentHealth;
        this.attack = Attack;
        this.position = position;
    }
    public Warriors(Warriors other){
        this.thisAge = other.thisAge;
        this.thisType = other.thisType;
        this.position = other.position;
        this.attack= other.attack;

    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int[] getPosition() {
        return position;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setCurrentHealth(int damageTacken) {
        this.currentHealth -= damageTacken;
    }


    public void setPosition(int[] position) {
        this.position = position;
    }
    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

}
