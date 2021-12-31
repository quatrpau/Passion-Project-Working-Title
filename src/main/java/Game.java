import environments.FinalEnvironment;
import interfaces.Environment;
import models.Player;
import utilities.Display;
import utilities.InputTaker;

import java.util.LinkedList;
//demo
//singleton?
public class Game implements Runnable {
    //private static final Game INSTANCE;
    //private Game(){}
    //initialize player in player class?
    public Player player;
    private final LinkedList<Environment> environments = new LinkedList<>();
    //make generating environments into factory?
    //default currentEnvironment is 0
    private int currentEnvironment = 0;
    //brand new start
    public Game(){
        //create new Player;
        this.player = Player.getYou();
        Display.print("What's your name?");
        player.setName(InputTaker.getPlayerInput());
        Display.print("Your name is now: " + player.getName() + ". Welcome!");
        Display.print("If this is your first time playing, try typing help to get information on availiable commands.");
        //add all environments
        environments.add(new FinalEnvironment());
    }
    //all this implementation will be inside the environments
    //serialization start?
    @Override
    public void run() {
        //for(;currentEnvironment < environments.size(); currentEnvironment++){
        boolean keepGoing = true;
        while(keepGoing && currentEnvironment < environments.size()){
            Boolean playerSurvived = environments.get(currentEnvironment).start();
            if(!playerSurvived){
                Display.print("GAME OVER. Retry?(y/n)");
                keepGoing = InputTaker.getYesOrNo();
            }
            else{
                currentEnvironment++;
            }
        }
    }
}
//VERBS
//go (progression; location based)
  //GO BACK
//look/inspect
//status
//use
//use on
//get/pick up

//GO BACK

//in help section encourage player to try some commands of their own

//interfaces
    //takeable
    //usable
    //actionable
    //wearable

    //battleable
//interf