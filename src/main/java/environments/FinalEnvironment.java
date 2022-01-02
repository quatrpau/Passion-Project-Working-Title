package environments;

import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//maybe have option to talk to dragon before battle
public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you fight him?(y/n)";
    //return string instead?
    @Override
    public Battle triggerBattle(Enemy opponent) {
        return new Battle(opponent);
    }

    @Override
    public void giveFlavorText() {
        Display.print(flavorText);
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
    @Override
    public Boolean start(){
        boolean hasEscaped = false;
        boolean warningShot = false;
        while(!hasEscaped) {
            giveFlavorText();
            if (InputTaker.getYesOrNo()) {
                Boolean outcome = triggerBattle(new Enemy("Dragon", 200, 200, 200)).getResult();
                if (outcome == null) {
                    //maybe something better here?
                    Display.print("Peace has been achieved.");
                    //may return null here
                    return true;
                } else if (outcome) {
                    Display.print("You won");
                    return true;
                } else {
                    //game over screen?
                    return false;
                }
            }
            else if(!warningShot){
                //do not allow dragon to surrender on first turn OR
                //do not allow dragon to surrender at all
                Display.print("You turn around and attempt to flee but a wall of flames quickly blocks your path, narrowly missing you.");
                warningShot = true;
            }
            else{
                Display.print("Are you sure?(y/n)");
                if(InputTaker.getYesOrNo()){
                    Display.print("Undeterred, you try to flee again, this time at a full sprint! \n" +
                            "Unfortunately, the flames have not yet dissipated and you are quickly burnt to a crisp.");
                    hasEscaped = true;
                }
            }
        }
        return false;
    }
}
