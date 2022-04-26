package BattleOfAges.Type;

import BattleOfAges.Warriors;

public class Type {
    private int attack;
    private int health;
    private int movementSpeed;
    private int range;
    private int cost;
//    private int hitRate;

    public Type(int attack, int health, int movementSpeed, int range, int cost) {
        this.attack = attack;
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.range = range;
        this.cost = cost;
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
}
