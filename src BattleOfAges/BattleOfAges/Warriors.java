package BattleOfAges;

import BattleOfAges.Main;
import BattleOfAges.Type.Type;

import BattleOfAges.Type.Type1;
import BattleOfAges.Type.Type2;
import BattleOfAges.Type.Type3;

public class Warriors {
//
//    public Type1 type1 = new Type1(); //
//    public Type2 type2 = new Type2(); //
//    public Type3 type3 = new Type3(); //
    private Age thisAge; //poxel em
    private Type thisType; // poxel em
    private int maxhealth = thisType.getHealth() * thisAge.getHealthBonus(); //poxel em
    private int currentHealth = maxhealth; //poxel em
    private int attack = thisType.getAttack() * thisAge.getAttackBonus();//poxel em
    private int position = 0; //poxel em, xi 0? hakaraky petqa lini


    public Warriors(Age thisAge,Type thisType,int positionOfPlayerOrBot, int attack) { //poxel em
        this.thisAge = thisAge;
        this.thisType = thisType;
        this.position = positionOfPlayerOrBot;
        this.attack= attack;
    }
    public Warriors(int currentHealth,int Attack,int position) { // xi 2rd constructor
        this.currentHealth = currentHealth;
        this.attack = Attack;
        this.position = position;
    }
    public Warriors(Warriors other){
        this.thisAge = other.thisAge;
        this.thisType = other.thisType;
        this.position = other.position;
        this.attack= this.attack;

    }


    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getPosition() {
        return position;
    }


    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public void setPosition(int position) {
        this.position = position;
    }

}
