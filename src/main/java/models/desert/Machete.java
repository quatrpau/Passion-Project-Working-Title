package models.desert;

import interfaces.Obtainable;
import models.Player;
import utilities.AnsiColor;
import utilities.IOConsole;

public class Machete implements Obtainable {

    @Override
    public String getName() {
        return "Machete";
    }

    @Override
    public String getDescription() {
        return "A bit rusty, but still does the job. Increases damage by 100.";
    }

    public static void statIncrease(){
        AnsiColor.BLACK_AND_WHITE.ioConsole.println("Increased damage by 100.");
        Player.getYou().addDamage(100);
    }
}
