package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.GiantScorpion;
import models.desert.Snake;
import models.desert.Vulture;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;

import java.util.Random;

//maybe make desert display only orange and/or yellow depending
//on whether or not you are at the entrance
public class Desert implements Environment {
    //have you die of thirst if you go without the cactus
    private int day = 1;
    private final Random random = new Random();
    private String flavorText = "You see nothing but sand, and you hope it stays that way. You must keep heading north. \n" +
            "Days to Dragon:" + (3 - day) + "NOTE: Each turn counts as a day passed.";
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return new Battle(opponent);
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
        String decision;
        String input;
        boolean keepGoing = true;
        while(keepGoing && day <= 3){
            if(((input = InputTaker.getPlayerInput()) != null) && (decision = inputRepair(input)) != null) {
                if(decision.equals("go north")){
                    if(Boolean.TRUE.equals(battleChanceCalculator())){
                        Challenger opponent = opponentSelector();
                        Boolean outcome = triggerBattle(opponent).getResult();//vary opponent (have 3 different kinds)
                        if(outcome == null){
                            IOConsole.printlin("You reached an agreement"); //reward?
                            day++;
                        }
                        else if(outcome){
                            IOConsole.printlin("You won!");
                            Player.getYou().addToInventory(opponent.giveReward());
                            day++;
                        }
                        else{
                            return false;
                        }
                    }
                }
                else if(decision.equals("go south")){
                    IOConsole.printlin("You have come so far, it would be foolish to turn back now!");
                }
                else if(decision.equals("look around")){
                    giveFlavorText();
                }
            }
            else if(input == null){
                giveFlavorText();
            }
            else{
                IOConsole.printlin("Invalid input: try again");
            }

        }
        if(day > 3){
            return true;
        }
        return false;
    }

    private Boolean battleChanceCalculator() {
        if(day == 1){
            int ten = random.nextInt(10);
            return ten == 1;
        }
        if(day == 2){
            int five = random.nextInt(5);
            return five == 1;
        }
        if(day == 3){
            int two = random.nextInt(2);
            return two == 1;
        }
        else{
            return null;
        }
    }
    //function which returns a random type of challenger
    private Challenger opponentSelector(){
        int choice = random.nextInt(3);
        if(choice == 0){
            return new GiantScorpion();
        }
        else if(choice == 1){
            return new Snake();
        }
        else{
            return new Vulture();
        }
    }
    private String inputRepair(String raw){
        if(raw.equals("go north")){
            return "go north";
        }
        else if(raw.equals("go south")){
            return "go south";
        }
        else if(raw.equals("look around") || raw.equals("look")){
            return "look around";
        }
        else{
            return null;
        }
    }
}

//desert enemies
    //snake //snakeskin
    //giant scorpion //venom
    //vulture //feather