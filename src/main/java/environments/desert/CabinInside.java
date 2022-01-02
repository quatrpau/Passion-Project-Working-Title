package environments.desert;

import interfaces.Environment;
import models.Enemy;
import models.desert.Machete;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;

import java.util.Locale;

public class CabinInside implements Environment {
    private String flavorText = "You enter the cabin, inside you see it is empty except for a machete sitting in the middle of the floor.";
    private Machete machete = new Machete();
    private Boolean macheteGot = false;
    @Override
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        Display.print(flavorText);
        Display.print("What will you do?");
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public Boolean start() {
        giveFlavorText();
        boolean keepGoing = true;
        while(keepGoing){
            String choice;
            if ((choice = inputRepair(InputTaker.getPlayerInput())) != null) {
                if(choice.equals("get machete")){
                    if(!macheteGot){
                        Display.print("Got the machete!");
                        macheteGot = true;
                    }
                    else{
                        Display.print("There is no machete...");
                    }
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
            }
            else{
                Display.print("Invalid input: try again.");
            }
        }
        return true;
    }
    private String inputRepair(String raw){
        if(raw.equals("get machete")){
            return "get machete";
        }
        if(raw.equals("leave") || raw.equals("go back")){
            return "go back";
        }
        else{
            return null;
        }
    }
}
