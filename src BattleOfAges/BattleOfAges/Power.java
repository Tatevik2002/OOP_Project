package BattleOfAges;

public class Power{
    private int damage;

    // oqtvi army database-ic u ichecru health-e
    public Power( Age age, String imageName){
        if (age.getImage() == "img1"){
            damage = age.getPowerBonus();
        }
        if (age.getImage() == "img2"){
            damage += age.getPowerBonus();
        }
        else{
            damage += age.getPowerBonus();

        }

    }
    public int  getDamage(){
        return damage;
    }

    // initiate attack on the screen
    // change the photo of the power in the screen
    // damage enemy
}