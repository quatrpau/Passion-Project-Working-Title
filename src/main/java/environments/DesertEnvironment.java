package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;

//dusty gardening gloves buried in the sand
public class DesertEnvironment implements Environment {
    private final Display
    private final String desertText = "You enter the desert. A desolate place with yellow stretching as far the eye can see, a lone cactus breaking the monotony. \n" +
            "To your right you see an abandoned warehouse. You must cross the desert to get to the dragon. It will take 3 days by foot." ;
    @Override
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public String giveFlavorText() {
        return null;
    }

    @Override
    public void setFlavorText(String flavorText) {

    }

    @Override
    public Boolean start() {
        Display.print(desertText);
        InputTaker.
    }
}
//desert enemies
    //snake
    //giant scorpion
    //vulture

//implement monetary system? //must find way to make money