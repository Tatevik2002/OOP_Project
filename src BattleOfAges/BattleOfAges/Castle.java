package BattleOfAges;

public class Castle{

    private int castleHealth;
    private final int baseCastleHealth = 100;
    private int thisAgeBonus;

    public Castle(Player player){
        castleHealth = baseCastleHealth;
        thisAgeBonus = player.getAge().getCastleHealthBonus();
    }

    public int getCastleHealth() {
        return castleHealth;
    }

    public boolean changeCastleHealth(Player player){
        try{
            float healthPercent = (float) Math.ceil((float)castleHealth / (baseCastleHealth * thisAgeBonus) );
            thisAgeBonus =  player.getAge().getCastleHealthBonus();
            castleHealth =  (int)healthPercent * (baseCastleHealth * thisAgeBonus );
            return true ;
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
