package models.desert;

import interfaces.Item;
import models.Player;
import utilities.Display;

public class Machete implements Item {

    @Override
    public String getName() {
        return "Machete";
    }

    @Override
    public String getDescription() {
        return "A bit rusty, but still does the job. Increases damage by 100.";
    }

    public void statIncrease(){
        Display.print("Increased damage by 100.");
        Player.getYou().addDamage(100);
    }
}
