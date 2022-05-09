package BattleOfAges.Type;

import BattleOfAges.Warriors;

public class Type {
    private int attack;
    private int health;
    private int movementSpeed;
    private int range;
    private int cost;
    private float exp;
    private int number;
//    private int hitRate;

    public Type(int attack, int health, int movementSpeed, int range, int cost,float exp,int number) {
        this.attack = attack;
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.range = range;
        this.cost = cost;
        this.exp = exp;
        this.number = number;
    }
    public Type(Type other){
        int attack = other.attack;
        int health = other.health;
        int movementSpeed = other.movementSpeed;
        int range = other.range;
        int cost= other.cost;
        float exp = other.exp;
        int number = other.number;
    }


    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }
    public float getExp(){return exp;}
    public int getNumber() {
        return number;
    }
}
