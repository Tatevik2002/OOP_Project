package BattleOfAges;

import java.util.EventListener;
import BattleOfAges.TurretTypes.*;
import BattleOfAges.Type.*;

public class Main {
    public static void main(String[] args){

        Console.player.setMyEnemy((Object)(Console.bot));
        Console.bot.setMyEnemy((Object)Console.player);
        MyFrame myFrame = new MyFrame();
    }
}