package interfaces;

import models.Enemy;
import utilities.Battle;

public interface Environment {
    Battle triggerBattle(Challenger opponent); //Maybe have battle environment and regular Environment
    void giveFlavorText();//add index to give flavor text
    void setFlavorText(String flavorText);
    Boolean start(); //maybe have this return an optional of a boolean so it can be null
}
