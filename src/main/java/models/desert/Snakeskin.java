package models.desert;

import interfaces.Obtainable;
import models.Player;
import utilities.AnsiColor;
import utilities.IOConsole;

//improves hp
public class Snakeskin implements Obtainable {
    @Override
    public String getName() {
        return "Snakeskin";
    }

    @Override
    public String getDescription() {
        return "A piece of relatively solid armor. Increases your maxHp by 200.";
    }

    public static void statIncrease(){
        AnsiColor.BLACK_AND_WHITE.ioConsole.println("Max Hp increased by 200!");
        //maybe have this restore health too?
        Player.getYou().addMaxHp(200);
    }
}
