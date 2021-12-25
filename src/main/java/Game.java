import environments.FinalEnvironment;
import interfaces.Environment;
import models.Player;
import utilities.Display;
import utilities.InputTaker;

import java.util.LinkedList;
//demo
//singleton?
public class Game {
    //private static final Game INSTANCE;
    //private Game(){}
    //initialize player in player class?
    public Player player;
    private LinkedList<Environment> environments;
    //make generating environments into factory?
    private int currentEnvironment;
    //serialization start?
    public Game(Player player){
        this.player = player;
        environments.add(new FinalEnvironment());
        currentEnvironment = 0;
    }
    //all this implementation will be inside the environments
    public void embark(){
        environments.get(currentEnvironment).start();
    }

}
