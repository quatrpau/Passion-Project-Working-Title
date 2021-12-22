package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.InputTaker;

public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you kill him?(y/n)";
    //private InputTaker inputTaker;
    @Override
    //return string instead?
    public Battle triggerBattle(Enemy opponent) {
        return new Battle(opponent);
    }

    @Override
    public String giveFlavorText() {
        return flavorText;
    }

    @Override
    public void setFlavorText() {

    }
}
