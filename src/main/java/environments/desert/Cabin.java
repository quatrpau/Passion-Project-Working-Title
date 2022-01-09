package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.Door;
import models.desert.Rock;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;
//have cabin outside and inside?
//describable interface can be subbed with toString
public class Cabin implements Environment {
    //private boolean inside = false;
    private final Door door = new Door(); //inspect door
    private final CabinInside inside = new CabinInside();
    private final IOConsole console = AnsiColor.ORANGE.ioConsole;
    private String flavorText = "You approach the cabin. It seems to have been abandoned for quite some time. \n" +
            "The only point of entry is a metal door.";

    @Override
    //battle with raccoon living in home?
    public Battle triggerBattle(Challenger opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        console.println(flavorText);
        //maybe make this a different color? or have it print from IOConsole?
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
            if((input =  InputTaker.getPlayerInput()) != null && (choice = inputRepair(input)) != null){
                if(choice.equals("hit door")){
                    console.println("You throw your body weight into the door but it won't budge. \n"
                    + "Looks like you're missing something...");
                }
                else if(choice.equals("use rock on door")){
                    //test whether program crashes when player doesn't have rock
                    if(Player.getYou().hasItem("rock") && Player.getYou().peekItem("rock") instanceof Rock ){
                        if(door.getAffected((Rock) Player.getYou().peekItem("rock"))){
                            console.println("With one well-placed blow, you shatter the locking mechanism! The door swings open.");
                        }
                        else{
                            console.println("The door is already open!");
                        }
                    }
                    else{
                        console.println("You don't have a rock!");
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
                        console.println("The door is locked!");
                    }
                }
                else if(choice.equals("look")){
                    giveFlavorText();
                }
                else if(choice.equals("look door")){
                    door.giveFlavorText();
                }
            }
            else if(input == null) {
                giveFlavorText();
            }
            else{
                console.println("Invalid input: try again.");
            }
        }
        return true;
    }
    private String inputRepair(String raw){
        //knock on door
        if(raw.equals("hit door")){
            return "hit door";
        }
        else if(raw.equals("use rock on door")){
            return "use rock on door";
        }
        else if(raw.equals("leave") || raw.equals("go back") || raw.equals("exit")){
            return "go back";
        }
        else if(raw.equals("enter cabin") || raw.equals("enter") || raw.equals("enter door")
        || raw.equals("use door")){
            return "enter";
        }
        else if(raw.equals("look") || raw.equals("look around")){
            return "look";
        }
        else if(raw.equals("look door") || raw.equals("look at door")){
            return "look door";
        }
        else{
            return null;
        }
    }
}
