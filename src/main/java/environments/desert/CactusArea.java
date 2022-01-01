package environments.desert;

import interfaces.Environment;
import models.Enemy;
import models.Player;
import models.desert.Rock;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//remove get flavor text replace with toString();
public class CactusArea implements Environment {
    private Boolean cactusCutDown = false;
    private Boolean rockIsGone = false;
    private String flavorText =  "You approach the cactus. You've heard that you can extract water from the cactus by cutting it open. If only you had a way to do that. \n" +
            "A large rock is propped up at the base of the cactus.";
    //battle cactus maybe?
    //have text explaining why rock is not usable on cactus
    public Battle triggerBattle(Enemy opponent) {
        return null;
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
                //use rock on cactus
                //if leave (go back, exit)
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
        else{
            return null;
        }
    }
}
