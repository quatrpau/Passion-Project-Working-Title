package models.desert;

import interfaces.Affectable;
import interfaces.Speaker;
import utilities.Display;

public class DesertGuide implements Speaker, Affectable<Machete> {
    //have descriptor of her as well
    //if acted on by a machete she shoots you
    //have player point to cabin? and ask her if she lives there
    @Override
    public void speak() {
        Display.print("You must cross the Yellow-Orange Desert to get to the dragon.  It will take 3 days by foot.");
    }

    @Override
    public Boolean getAffected(Machete catalyst) {
        return null;
    }

    @Override
    public void setFlavorText(String flavorText) {

    }
}
