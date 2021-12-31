package environments.desert;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;

//maybe make desert display only orange and/or yellow depending
//on whether or not you are at the entrance
public class Desert implements Environment {
    @Override
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
