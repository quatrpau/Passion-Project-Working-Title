package models.desert;

import interfaces.Obtainable;
import models.Player;
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
        IOConsole.printlin("Increased Damage by 75");
        Player.getYou().addDamage(75);

    }
}
