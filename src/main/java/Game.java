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
    private final Display display = new Display();
    private final InputTaker inputTaker = new InputTaker();
    private Player player;
    private LinkedList<Environment> environments;
    //make generating environments into factory?
    private int currentEnvironment;
    //serialization start?
    public Game(Player player){
        this.player = player;
        environments.add(new FinalEnvironment());
    }
    //all this implementation will be inside the environments
    public void embark(){
        Environment envy = environments.get(0);
        display.print(envy.giveFlavorText());
        if(inputTaker.getPlayerInput().equals("y")){
            display.print("ok here we go");
            envy.triggerBattle(new Enemy
        }
    }

}
