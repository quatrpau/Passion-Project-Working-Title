package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.Cactus;
import models.desert.Rock;
import models.desert.WaterBottle;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//remove get flavor text replace with toString();
public class CactusArea implements Environment {
    private Cactus cactus;
    private Boolean cactusCutDown = false;
    private Boolean rockIsGone = false;
    private String flavorText =  "You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that. \n" +
            "A large rock is propped up at the base of the cactus.";
    //battle cactus maybe?
    //have text explaining why rock is not usable on cactus
    public Battle triggerBattle(Challenger opponent) {
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

    public Boolean getCactusStatus(){
        return this.cactusCutDown;
    }
    @Override
    public Boolean start() {
        giveFlavorText();
        Display.print("What will you do?");
        boolean keepGoing = true;
        while(keepGoing) {
            String choice;
            //take rock//get rock//pick up rock
            //if rock
            if ((choice = inputRepair(InputTaker.getPlayerInput())) != null) {
                if (choice.equals("take rock") && !rockIsGone) {
                    Player.getYou().addToInventory(new Rock());
                    setFlavorText("You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that.");
                    Display.print("Got the rock!");
                    rockIsGone = true;
                }
                else if(choice.equals("go back")){
                    keepGoing = false;
                }
                //use machete on cactus
                else if(choice.equals("use machete on cactus"){
                    if(Player.getYou().hasItem("machete")){
                        Boolean outcome = triggerBattle(this.cactus).getResult();
                        if (outcome == null) {
                            //something better here//cactus gives you water or something
                            Display.print("You came to an agreement.");
                            //may return null here
                            Display.print("You got a water bottle!");
                            Player.getYou().addToInventory(new WaterBottle());
                        } else if (outcome) {
                            Display.print("You defeated the cactus.");
                            cactusCutDown = true;
                            Display.print("You got the cactus flesh!");
                            this.setFlavorText("The stump of a once-prominent cactus.");
                            Player.getYou().addToInventory(cactus.giveReward());
                        } else {
                            //game over screen?
                            return false;
                        }
                    }
                    else{
                        Display.print("You don't have the machete.");
                    }
                }
                //use rock on cactus
                //repeat
                //confused
            }
        }
        return true;
    }
    private String inputRepair(String raw){
        if(raw.equals("take rock") || raw.equals("get rock")){
            return "take rock";
        }
        else if(raw.equals("go back")){
            return "go back";
        }
        else if(raw.equals("use machete on cactus")){
            return "use machete on cactus";
        }
        else{
            return null;
        }
    }
}
