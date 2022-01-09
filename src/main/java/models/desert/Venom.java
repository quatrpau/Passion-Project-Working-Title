package models.desert;

import interfaces.Obtainable;
import models.Player;
import utilities.AnsiColor;
import utilities.IOConsole;

//improves damage
public class Venom implements Obtainable {
    @Override
    public String getName() {
        return "Venom";
    }

    @Override
    public String getDescription() {
        return "A potent concoction of poison from the stinger of a scorpion.";
    }

    public static void statIncrease(){
        AnsiColor.BLACK_AND_WHITE.ioConsole.println("Increased Damage by 75");
        Player.getYou().addDamage(75);

    }
}
