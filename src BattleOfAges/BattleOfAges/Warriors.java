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
    Age thisAge;
    Type thisType;
    int maxhealth = thisType.getHealth() * thisAge.getHealthBonus();
    int currentHealth = maxhealth;
    int Attack = thisType.getAttack() * thisAge.getAttackBonus();
    int position = 0; // kam enmi dseve


    public Warriors(Age thisAge,Type thisType,int positionOfPlayerOrBot) {
        this.thisAge = thisAge;
        this.thisType = thisType;
        this.position = positionOfPlayerOrBot;
    }
    public Warriors(int currentHealth,int Attack,int position) {
        this.currentHealth = currentHealth;
        this.Attack = Attack;
        this.position = position;
    }


    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return Attack;
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
