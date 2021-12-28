package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
//dusty gardening gloves buried in the sand
public class DesertEnvironment implements Environment {
    private String flavorText = "You enter the desert. A desolate place with orange sand stretching as far the eye can see." +
            " All you see is cacti";
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
        return false;
    }
}
