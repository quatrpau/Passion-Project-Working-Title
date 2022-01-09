package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.Cactus;
import models.desert.Rock;
import models.desert.WaterBottle;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;
//remove get flavor text replace with toString();
public class CactusArea implements Environment {
    private Cactus cactus;
    private Boolean cactusCutDown = false;
    private Boolean rockIsGone = false;
    private IOConsole console = AnsiColor.ORANGE.ioConsole;
    private String flavorText =  "You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that. \n" +
            "A large rock is propped up at the base of the cactus.";
    //battle cactus maybe?
    //have text explaining why rock is not usable on cactus
    public Battle triggerBattle(Challenger opponent) {
        return new Battle(opponent);
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

    public Boolean getCactusStatus(){
        return this.cactusCutDown;
    }
    @Override
    public Boolean start() {
        giveFlavorText();
        console.println("What will you do?");
        boolean keepGoing = true;
        while(keepGoing) {
            String choice;
            String input;
            //take rock//get rock//pick up rock
            //if rock
            if ((input = InputTaker.getPlayerInput()) != null && (choice = inputRepair(input)) != null) {
                if (choice.equals("take rock") && !rockIsGone) {
                    Player.getYou().addToInventory(new Rock());
                    setFlavorText("You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that.");
                    console.println("Got the rock!");
                    rockIsGone = true;
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
                //use machete on cactus
                else if(choice.equals("use machete on cactus")){
                    if(Player.getYou().hasItem("machete")){
                        cactus.setBattleStatus(true);
                        Boolean outcome = triggerBattle(this.cactus).getResult();
                        if (outcome == null) {
                            //something better here//cactus gives you water or something
                            console.println("You came to an agreement.");
                            //may return null here
                            console.println("You got a water bottle!");
                            Player.getYou().addToInventory(new WaterBottle());
                        } else if (outcome) {
                            console.println("You defeated the cactus.");
                            cactusCutDown = true;
                            console.println("You got the cactus flesh!");
                            this.setFlavorText("The stump of a once-prominent cactus.");
                            Player.getYou().addToInventory(cactus.giveReward());
                        } else {
                            //game over screen?
                            return false;
                        }
                    }
                    else{
                        console.println("You don't have the machete.");
                    }
                }
                //use rock on cactus
                else if(choice.equals("use rock on cactus")){
                    if(Player.getYou().hasItem("rock")){
                        console.println("You try and hit the cactus with the rock but it just bounces off.\n" +
                                "Looks like you'll need something else.");
                    }
                    else{
                        console.println("You don't have the rock");
                    }
                }
                //repeat
                else if(choice.equals("look")){
                    giveFlavorText();
                }
                else if(choice.equals("look cactus")){
                    if(!cactusCutDown){
                        cactus.giveFlavorText();
                    }
                    else{
                        console.println("The stump of a once-prominent cactus.");
                    }
                }
                else if(choice.equals("look rock"));
                    if(!rockIsGone){
                        console.println("A big rock");
                    }
                    else{
                        console.printCheckError();
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
        if(raw.equals("take rock") || raw.equals("get rock")){
            return "take rock";
        }
        else if(raw.equals("go back") || raw.equals("leave") || raw.equals("exit")){
            return "go back";
        }
        else if(raw.equals("use machete on cactus")){
            return "use machete on cactus";
        }
        else if(raw.equals("use rock on cactus")){
            return "use rock on cactus";
        }
        else if(raw.equals("look around") || raw.equals("look")){
            return "look";
        }
        else if(raw.equals("look at cactus") || raw.equals("look cactus")){
            return "look cactus";
        }
        else if(raw.equals("look at rock") || raw.equals("look rock")){
            return "look rock";
        }
        else{
            return null;
        }
    }
}
