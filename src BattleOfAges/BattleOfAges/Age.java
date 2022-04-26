package BattleOfAges;
import BattleOfAges.Type.*;

public class Age {
    private int healthBonus;
    private int attackBonus;
    private int powerBonus;
    private int costBonus;
    private String image;
    private Power power;
    private int castleHealthBonus;

    public Age(String image, int healthBonus, int attackBonus, int powerBonus, int castleHealthBonus) {
        this.healthBonus = healthBonus;
        this.attackBonus = attackBonus;
        this.powerBonus = powerBonus;
        // this.costBonus = costBonus;
        this.image = image;
        this.power = new Power(this,image);
        this.castleHealthBonus = castleHealthBonus;
    }
    public Age(Age theAge) {
        this.healthBonus = theAge.healthBonus;
        this.attackBonus = theAge.attackBonus;
        this.powerBonus = theAge.powerBonus;
        this.costBonus = theAge.costBonus;
        this.image = theAge.image;
        this.power = theAge.getPower();
    }
    public Power getPower(){
        return power;
    }
    public int getHealthBonus() {
        return healthBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getPowerBonus() {
        return powerBonus;
    }

    public int getCostBonus() {
        return costBonus;
    }

    public String getImage() {
        return image;
    }

    public int getCastleHealthBonus() {
        return castleHealthBonus;
    }
}

