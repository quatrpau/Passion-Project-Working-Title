package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;

public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you fight him?(y/n)";
    private InputTaker inputTaker;
    private Display display;
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
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
    @Override
    public void start(){
        display.print(flavorText);
        if(inputTaker.getYesOrNo()){
            triggerBattle(new Enemy("Dragon",200,200,200));
        }
    }
}
