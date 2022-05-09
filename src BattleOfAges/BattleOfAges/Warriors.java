package BattleOfAges;

import BattleOfAges.Type.*;

public class Warriors {
    //
//    public Type1 type1 = new Type1(); //
//    public Type2 type2 = new Type2(); //
//    public Type3 type3 = new Type3(); //
    private Age thisAge;
    private Type thisType;
    private int maxhealth = thisType.getHealth() * thisAge.getHealthBonus();
    private int currentHealth = maxhealth;
    private int attack = thisType.getAttack() * thisAge.getAttackBonus();
    private int positionX = 0;

    public Warriors(Age thisAge,Type thisType,int positionOfX) {
        this.thisAge = thisAge;
        this.thisType = thisType;
        this.positionX = positionOfX;
    }
    public Warriors(Warriors other){
        this.thisAge = other.thisAge;
        this.thisType = other.thisType;
        this.positionX = other.positionX;
        this.attack= other.attack;

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

    public void setCurrentHealth(int damageTaken) {
        this.currentHealth -= damageTaken;
    }
    public void setPosition(int X) {
        this.positionX = X;
    }

}



/* public Warriors(int currentHealth,int Attack,int positionOfX) {
        this.currentHealth = currentHealth;
        this.attack = Attack;
        this.positionX = positionOfX;
    } */