package environments.Desert;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;

public class Cactus implements Environment {

    //battle cactus maybe?
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
    }

    @Override
    public void setFlavorText(String flavorText) {
    }

    @Override
    public Boolean start() {
        return null;
    }
}
