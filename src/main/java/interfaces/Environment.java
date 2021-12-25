package interfaces;

import models.Enemy;
import utilities.Battle;

public interface Environment {
    Battle triggerBattle(Enemy opponent);
    String giveFlavorText();
    void setFlavorText(String flavorText);
    void start();
}
