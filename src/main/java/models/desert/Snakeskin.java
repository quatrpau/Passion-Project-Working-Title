package models.desert;

import interfaces.Item;
import models.Player;
import utilities.IOConsole;

//improves hp
public class Snakeskin implements Item {
    @Override
    public String getName() {
        return "Snakeskin";
    }

    @Override
    public String getDescription() {
        return "A piece of relatively solid armor. Increases your maxHp by 200.";
    }

    public static void statIncrease(){
        IOConsole.printlin("Max hp increased by 200!");
        Player.getYou().addMaxHp(200);
    }
}
