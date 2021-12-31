package environments.Desert;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
//maybe make oranges display only orange and/or yellow
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
