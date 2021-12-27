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
    public Display display = new Display();
    public InputTaker inputTaker = new InputTaker();
    public Player player;
    private final LinkedList<Environment> environments = new LinkedList<>();
    //make generating environments into factory?
    //default currentEnvironment is 0
    private int currentEnvironment = 0;
    //brand new start
    public Game(){
        //create new Player;
        this.player = Player.getYou();
        display.print("What's your name?");
        player.setName(inputTaker.getPlayerInput());
        display.print("Your name is now: " + player.getName() + ". Welcome!");
        //add all environments
        environments.add(new FinalEnvironment());
    }
    //all this implementation will be inside the environments
    //serialization start?
    @Override
    public void run() {
        for(;currentEnvironment < environments.size(); currentEnvironment++){
            environments.get(currentEnvironment).start();
        }
    }
}
