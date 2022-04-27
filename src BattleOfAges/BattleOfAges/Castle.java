package BattleOfAges;

public class Castle{

    private int castleHealth;
    private int baseCastleHealth;
    private int healthPercent;
    private int thisAgeBonus;

    public Castle(Player player){
        baseCastleHealth = 100;
        castleHealth = baseCastleHealth;
        thisAgeBonus = player.getAge().getCastleHealthBonus();
    }
    public int changeCastleHealth(Player player){

        // player-e vorpes argument tanq? te this-ov anenq player-i mech?

        castleHealth = player.getCastleHealthNow(); /////
        healthPercent = castleHealth/ (baseCastleHealth * thisAgeBonus );
        thisAgeBonus =  player.getAge().getCastleHealthBonus();
        return   healthPercent * player.getAge().getCastleHealthBonus(); // castleHealthNow = heto kanchenq method e
    }
}
