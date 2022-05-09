package BattleOfAges;

public class Power{
    private int damage;

    // oqtvi army database-ic u ichecru health-e
    public Power(String imageName){
        if (imageName.equals("p1")){
            damage = Console.Age1.getPowerBonus();
        }
        else if (imageName.equals("p2")){
            damage += Console.Age2.getPowerBonus();
        }
        else if (imageName.equals("p3")){
            damage += Console.Age3.getPowerBonus();
        }
        else{
            damage += Console.Age4.getPowerBonus();
        }

    }
    public int  getDamage(){
        return damage;
    }

    // initiate attack on the screen
    // change the photo of the power in the screen
    // damage enemy
}