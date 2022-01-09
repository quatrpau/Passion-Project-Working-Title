package environments;

import interfaces.Challenger;
import interfaces.Environment;
import models.Enemy;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;
//maybe have option to talk to dragon before battle
public class FinalEnvironment implements Environment {
    private String flavorText = "You see a dragon up ahead. Will you fight him?(y/n)";
    private final IOConsole console = AnsiColor.WHITE.ioConsole;
    //return string instead?
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return new Battle(opponent);
    }

    @Override
    public void giveFlavorText() {
        console.println(flavorText);
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
                    console.println("Peace has been achieved.");
                    //may return null here
                    return true;
                } else if (outcome) {
                    console.println("You won");
                    return true;
                } else {
                    //game over screen?
                    return false;
                }
            }
            else if(!warningShot){
                //do not allow dragon to surrender on first turn OR
                //do not allow dragon to surrender at all
                console.println("You turn around and attempt to flee but a wall of flames quickly blocks your path, narrowly missing you.");
                warningShot = true;
            }
            else{
                console.println("Are you sure?(y/n)");
                if(InputTaker.getYesOrNo()){
                    console.println("Undeterred, you try to flee again, this time at a full sprint! \n" +
                            "Unfortunately, the flames have not yet dissipated and you are quickly burnt to a crisp.");
                    hasEscaped = true;
                }
            }
        }
        return false;
    }
}
