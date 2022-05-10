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
        this.attack = other.attack;
        this.health = other.health;
        this.movementSpeed = other.movementSpeed;
        this.range = other.range;
        this.cost= other.cost;
        this.exp = other.exp;
        this.number = other.number;
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
