package BattleOfAges;
import BattleOfAges.Type.*;

public class Age {
    private int healthBonus;
    private int attackBonus;
    private int powerBonus;
    private int expCost;
    private String image;
    private Power power;
    private int castleHealthBonus;
    private int turretDamageBonus;
    private int ageNumber;
    private int costBonus;

    public Age(int ageNumber, String image, int healthBonus, int attackBonus, int powerBonus, int castleHealthBonus,int costBonus, int turretDamageBonus, int expCost ) {
        this.image = image;
        this.ageNumber = ageNumber;
        this.healthBonus = healthBonus;
        this.attackBonus = attackBonus;
        this.powerBonus = powerBonus;
        this.expCost = expCost;
        this.costBonus = costBonus;
        this.power = new Power(this.image);
        this.turretDamageBonus = turretDamageBonus;
        this.castleHealthBonus = castleHealthBonus;
        this.ageNumber = ageNumber;
    }
    public Age(Age theAge) {
        this.healthBonus = theAge.healthBonus;
        this.attackBonus = theAge.attackBonus;
        this.powerBonus = theAge.powerBonus;
        this.expCost = theAge.expCost;
        this.image = theAge.image;
        this.power = theAge.getPower();
        this.turretDamageBonus = theAge.turretDamageBonus;
        this.castleHealthBonus = theAge.castleHealthBonus;
        this.ageNumber = theAge.ageNumber;
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
    public int getExpCost() {
        return expCost;
    }
    public String getImage() {
        return image;
    }
    public int getTurretDamageBonus() {
        return turretDamageBonus;
    }
    public int getCastleHealthBonus() {
        return castleHealthBonus;
    }
    public int getAgeNumber() {
        return ageNumber;
    }
}

