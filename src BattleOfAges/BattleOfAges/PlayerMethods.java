package BattleOfAges;

public class PlayerMethods {
    public static Warriors[] changeArray(Player player){ // jnjuma
        int newLength = player.warriors.length - 1;
        Warriors[] NewArray = new Warriors[newLength];
        for (int i = 1; i < player.warriors.length; i++) {
            NewArray[i-1] = player.warriors[i];
        }
        return NewArray;
    }
    public static Warriors[] changeArray(Player player,Warriors newWarrior) { // avelacnuma mi hat warrior
        int newLength = player.warriors.length + 1;
        Warriors[] NewArray = new Warriors[newLength];
        for (int i = 0; i < player.warriors.length; i++) {
            NewArray[i] = player.warriors[i];
        }
        NewArray[newLength - 1] = newWarrior;
        return NewArray;
    }
}
