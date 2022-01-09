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
    private IOConsole console = AnsiColor.ORANGE.ioConsole;
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        console.println(flavorText);
        console.println("What will you do?");
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
            String input;
            if ((input = InputTaker.getPlayerInput()) != null && ((choice = inputRepair(input)) != null)){
                if(choice.equals("get machete")){
                    if(!macheteGot){
                        console.println("Got the machete!");
                        Player.getYou().addToInventory(new Machete());
                        macheteGot = true;
                        setFlavorText("Nothing is left...");
                    }
                    else{
                        console.println("There is no machete...");
                    }
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
                else if(choice.equals("look")){
                    giveFlavorText();
                }
                else if(choice.equals("look machete")){
                    if(macheteGot){
                        console.println("An old, forgotten machete.");
                    }
                    else{
                        console.println("Try using 'check' for items in your inventory.");
                    }
                }
            }
            else if(input == null){
                giveFlavorText();
            }
            else{
                console.println("Invalid input: try again.");
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
        if(raw.equals("look machete") || raw.equals("look at machete")){
            return "look machete";
        }
        else{
            return null;
        }
    }
}
