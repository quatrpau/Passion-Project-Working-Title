package environments.desert;

import interfaces.Challenger;
import interfaces.Environment;
import models.Player;
import models.desert.GiantScorpion;
import models.desert.Snake;
import models.desert.Vulture;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//maybe make desert display only orange and/or yellow depending
//on whether or not you are at the entrance
public class Desert implements Environment {
    //have you die of thirst if you go without the cactus
    private int day = 0;
    private final Random random = new Random();
    private final IOConsole console = AnsiColor.YELLOW.ioConsole;
    private String flavorText = "You see nothing but sand, and you hope it stays that way. You must keep heading north. \n" +
            "(NOTE: Each turn counts as a day passed.)\nDays to Dragon: ";
    @Override
    public Battle triggerBattle(Challenger opponent) {
        return new Battle(opponent);
    }

    @Override
    public void giveFlavorText() {
        console.print(flavorText);
        console.println(Integer.valueOf(3 - day).toString());
        console.println("What will you do?");
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
        //have a way to exit the thing
        while(keepGoing && day <= 3){
            if(((input = InputTaker.getPlayerInput()) != null) && (decision = inputRepair(input)) != null) {
                if(decision.equals("go north")){
                    if(Boolean.TRUE.equals(battleChanceCalculator())){
                        Challenger opponent = opponentSelector();
                        console.println("You encounter a " + opponent.getName() + "!");
                        Boolean outcome = triggerBattle(opponent).getResult();//vary opponent (have 3 different kinds)
                        if(outcome == null){
                            console.println("You reached an agreement"); //reward?
                            day++;
                        }
                        else if(outcome){
                            console.println("You won!");
                            Player.getYou().addToInventory(opponent.giveReward());
                            day++;
                        }
                        else{
                            day = 0;
                            return false;
                        }
                    }
                    else{
                        day++;
                        if(day <= 3){
                            giveFlavorText();
                        }
                    }
                }
                else if(decision.equals("go south")){
                    console.println("You have come so far, it would be foolish to turn back now!");
                }
                else if(decision.equals("look around")){
                    giveFlavorText();
                }
            }
            else if(input == null){
                giveFlavorText();
            }
            else{
                console.println("Invalid input: try again");
            }
        }
        if(day > 3){
            day = 0;
            return true;
        }
        return false;
    }

    private Boolean battleChanceCalculator() {
        if(day == 0){
            return true;
            //int twenty = random.nextInt(20);
            //return twenty == 1;
        }
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