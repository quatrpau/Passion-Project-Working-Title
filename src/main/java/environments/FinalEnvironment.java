package environments;

import interfaces.Challenger;
import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;
//maybe have option to talk to dragon before battle
public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you fight him?(y/n)";
    //return string instead?
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return new Battle(opponent);
    }

    @Override
    public void giveFlavorText() {
        IOConsole.printlin(flavorText);
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
                    IOConsole.printlin("Peace has been achieved.");
                    //may return null here
                    return true;
                } else if (outcome) {
                    IOConsole.printlin("You won");
                    return true;
                } else {
                    //game over screen?
                    return false;
                }
            }
            else if(!warningShot){
                //do not allow dragon to surrender on first turn OR
                //do not allow dragon to surrender at all
                IOConsole.printlin("You turn around and attempt to flee but a wall of flames quickly blocks your path, narrowly missing you.");
                warningShot = true;
            }
            else{
                IOConsole.printlin("Are you sure?(y/n)");
                if(InputTaker.getYesOrNo()){
                    IOConsole.printlin("Undeterred, you try to flee again, this time at a full sprint! \n" +
                            "Unfortunately, the flames have not yet dissipated and you are quickly burnt to a crisp.");
                    hasEscaped = true;
                }
            }
        }
        return false;
    }
}
