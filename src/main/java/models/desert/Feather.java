package models.desert;

import interfaces.Item;
import models.Player;
import utilities.IOConsole;

//improves speed;
public class Feather implements Item {
    @Override
    public String getName() {
        return "Feather";
    }

    @Override
    public String getDescription() {
        return "A feather from a vulture.";
    }
    public static void statIncrease(){
        IOConsole.printlin("Speed increased by 100!");
        Player.getYou().addSpeed(100);
    }
}
