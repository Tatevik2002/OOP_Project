package BattleOfAges;

public class Power{
    private int damage;

    // oqtvi army database-ic u ichecru health-e
    public Power(String imageName){
        if (imageName == "img1"){
            damage = Main.Age1.getPowerBonus();
        }
        else if (imageName == "img2"){
            damage += Main.Age2.getPowerBonus();
        }
        else if (imageName == "img3"){
            damage += Main.Age3.getPowerBonus();
        }
        else{
            damage += Main.Age4.getPowerBonus();
        }

    }
    public int  getDamage(){
        return damage;
    }

    // initiate attack on the screen
    // change the photo of the power in the screen
    // damage enemy
}