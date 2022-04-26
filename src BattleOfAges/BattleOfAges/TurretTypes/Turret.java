package BattleOfAges.TurretTypes;


public class Turret{

    private int attack;
    private int range;
    private int cost;

    public Turret(int attack, int range, int cost) {
        this.attack = attack;
        this.range = range;
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }


}
