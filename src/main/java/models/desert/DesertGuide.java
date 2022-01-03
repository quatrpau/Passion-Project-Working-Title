package models.desert;

import interfaces.Speaker;
import utilities.Display;

public class DesertGuide implements Speaker {
    //have descriptor of her as well
    //if acted on by a machete she shoots you
    //have player point to cabin? and ask her if she lives there
    @Override
    public void speak() {
        Display.print("You must cross the Yellow-Orange Desert to get to the dragon.  It will take 3 days by foot.");
    }

}
