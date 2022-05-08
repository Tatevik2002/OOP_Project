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
    private int turretDamageBonus;
    public int ageNumber;

    public Age(int ageNumber, String image, int healthBonus, int attackBonus, int powerBonus, int castleHealthBonus, int turretDamageBonus, int costBonus ) {
        this.ageNumber = ageNumber;
        this.healthBonus = healthBonus;
        this.attackBonus = attackBonus;
        this.powerBonus = powerBonus;
        this.costBonus = costBonus;
        this.image = image;
        this.power = new Power(this.image);
        this.turretDamageBonus = turretDamageBonus;
        this.castleHealthBonus = castleHealthBonus;
    }
    public Age(Age theAge) {
        this.healthBonus = theAge.healthBonus;
        this.attackBonus = theAge.attackBonus;
        this.powerBonus = theAge.powerBonus;
        this.costBonus = theAge.costBonus;
        this.image = theAge.image;
        this.power = theAge.getPower();
        this.turretDamageBonus = theAge.turretDamageBonus;// avelacrel em
        this.castleHealthBonus = theAge.castleHealthBonus;//avelacrel em
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

    public int getTurretDamageBonus() {
        return turretDamageBonus;
    }

    public int getCastleHealthBonus() {
        return castleHealthBonus;
    }

}

