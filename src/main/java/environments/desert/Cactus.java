package environments.desert;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;

public class Cactus implements Environment {
    private String flavorText =  "You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that. \n" +
            "A large rock is propped up at the base of the cactus";
    //battle cactus maybe?
    //have text explaining why rock is not usable on cactus
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        Display.print(flavorText);
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public Boolean start() {
        giveFlavorText();
        return true;
    }
}
