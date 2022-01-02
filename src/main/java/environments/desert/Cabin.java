package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Enemy;
import models.Player;
import models.desert.Door;
import models.desert.Rock;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//have cabin outside and inside?
//describable interface can be subbed with toString
public class Cabin implements Environment {
    //private boolean inside = false;
    private Door door = new Door();
    private CabinInside inside = new CabinInside();
    private String flavorText = "You approach the cabin. It seems to have been abandoned for quite some time. \n" +
            "The only point of entry is a metal door.";

    @Override
    //battle with raccoon living in home?
    public Battle triggerBattle(Challenger opponent) {
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
            if((choice = inputRepair(InputTaker.getPlayerInput())) != null){
                if(choice.equals("hit door")){
                    Display.print("You throw your body weight into the door but it won't budge. \n"
                    + "Looks like you're missing something...");
                }
                else if(choice.equals("use rock on door")){
                    //test whether program crashes when player doesn't have rock
                    if(Player.getYou().hasItem("rock") && Player.getYou().peekItem("rock") instanceof Rock ){
                        if(door.getAffected((Rock) Player.getYou().peekItem("rock"))){
                            Display.print("With one well-placed blow, you shatter the locking mechanism! The door swings open.");
                        }
                        else{
                            Display.print("The door is already open!");
                        }
                    }
                    else{
                        Display.print("You don't have a rock!");
                    }
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
                else if(choice.equals("enter")){
                    if(door.isOpen()){
                        inside.start();
                    }
                    else{
                        Display.print("The door is locked!");
                    }
                }
            }
            else{
                Display.print("Invalid input: try again.");
            }
        }
        return true;
    }
    private String inputRepair(String raw){
        if(raw.equals("hit door")){
            return "hit door";
        }
        else if(raw.equals("use rock on door")){
            return "use rock on door";
        }
        else if(raw.equals("leave") || raw.equals("go back")){
            return "go back";
        }
        else if(raw.equals("enter cabin") || raw.equals("enter") || raw.equals("enter door")){
            return "enter";
        }
        else{
            return null;
        }
    }
}
