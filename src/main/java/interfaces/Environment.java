package interfaces;

import utilities.Battle;

public interface Environment {
    Battle triggerBattle();
    String giveFlavorText();
    void setFlavorText();
}
