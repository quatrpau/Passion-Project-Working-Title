package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.Machete;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;


public class CabinInside implements Environment {
    private String flavorText = "You enter the cabin, inside you see it is empty except for a machete sitting in the middle of the floor.";
    private Boolean macheteGot = false;
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        IOConsole.printlin(flavorText);
        IOConsole.printlin("What will you do?");
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
                        IOConsole.printlin("Got the machete!");
                        Player.getYou().addToInventory(new Machete());
                        macheteGot = true;
                        setFlavorText("Nothing is left...");
                    }
                    else{
                        IOConsole.printlin("There is no machete...");
                    }
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
                else if(choice.equals("look")){
                    giveFlavorText();
                }
            }
            else{
                IOConsole.printlin("Invalid input: try again.");
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
        if(raw.equals("look around") || raw.equals("look")){
            return "look";
        }
        else{
            return null;
        }
    }
}
