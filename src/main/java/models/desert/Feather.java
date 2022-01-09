package models.desert;

import interfaces.Obtainable;
import models.Player;
import utilities.AnsiColor;
import utilities.IOConsole;

//improves speed;
public class Feather implements Obtainable {
    @Override
    public String getName() {
        return "Feather";
    }

    @Override
    public String getDescription() {
        return "A feather from a vulture.";
    }
    public static void statIncrease(){
        AnsiColor.BLACK_AND_WHITE.ioConsole.println("Speed increased by 100!");
        Player.getYou().addSpeed(100);
    }
}
