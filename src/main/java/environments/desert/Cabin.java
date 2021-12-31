package environments.desert;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;

public class Cabin implements Environment {
    private String flavorText = "You approach the cabin. It seems to have been abandoned for quite some time. \n" +
            "You see a door with a rusted lock. It looks like it be compromised with a little force.";

    @Override
    //battle with raccoon living in home?
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {

    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public Boolean start() {
        Display.print(flavorText);
        return true;
    }
}
