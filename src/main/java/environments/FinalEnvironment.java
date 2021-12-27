package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;

public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you fight him?(y/n)";
    private final InputTaker inputTaker = new InputTaker();
    private final Display display = new Display();
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
            Boolean outcome = triggerBattle(new Enemy("Dragon",200,200,200)).getResult();
            if (outcome == null){
                //maybe something better here?
                display.print("Peace has been achieved");
            }
            else if(outcome){
                display.print("You won");
            }
            else{
                //game over screen?
                display.print("GAME OVER");
                //retry functionality?
            }
        }
    }
}
