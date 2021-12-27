package utilities;

import models.Enemy;
import models.Player;

//have better text options
public class Battle {
    private Enemy opponent;
    private Display display= new Display();
    private InputTaker inputTaker = new InputTaker();
    private Player you = Player.getYou();
    private Boolean result;
    private static final String YOUR_TURN = "What will you do? \n 1.) Attack \n 2.) Surrender";
    public Battle(Enemy opponent) {
        this.opponent = opponent;
        this.result = this.start();
    }
    //chance of peace?
    public Boolean start(){
        boolean openToPeace = false;
        //why is this statement redundant
        int intraTurnCommunicationStation = 0;
        int interTurnCommunicationStation = 0;
        boolean firstTurn = true;
        //check if opponent and you are alive every turn
        while(opponent.isAlive() && you.isAlive() && !openToPeace){
            boolean playerGoesFirst = you.getSpeed() > opponent.getSpeed();
            if(firstTurn){
                if(playerGoesFirst){
                    intraTurnCommunicationStation = playerTurn();
                    interTurnCommunicationStation = opponentTurn(intraTurnCommunicationStation);
                }
                else{
                    intraTurnCommunicationStation = opponentTurn();
                    interTurnCommunicationStation = playerTurn(intraTurnCommunicationStation);
                }
                firstTurn = false;
            }
            else {
                if (playerGoesFirst) {
                    //can this be put inside each other
                    intraTurnCommunicationStation = playerTurn(interTurnCommunicationStation);
                    interTurnCommunicationStation = opponentTurn(intraTurnCommunicationStation);
                } else {
                    intraTurnCommunicationStation = opponentTurn(interTurnCommunicationStation);
                    interTurnCommunicationStation = playerTurn(intraTurnCommunicationStation);
                }
            }
            if(intraTurnCommunicationStation == -1 && interTurnCommunicationStation == -1){
                openToPeace = true;
            }
        }
        if(openToPeace){
            return null;
        }
        return you.isAlive();
    }
    //1st Turns
    private int playerTurn(){
        display.print(YOUR_TURN);
        if(inputTaker.getPlayerInput().equals("1")){
            //fight
            display.print("You throw a punch, but does it connect?");
            return you.giveDamage();
        }
        else{
            //surrender
            display.print("You decide to surrender, but does your opponent accept?");
            return -1;
        }
    }
    private int opponentTurn(){
        //decides to fight
        if(opponent.decideTime()){
            display.print("Your opponent attacks!");
            return opponent.giveDamage();
        }
        //decides to surrender
        else{
            display.print("Your opponent attempts to surrender.");
            return -1;
        }
    }
    //All Other Turns
    private int playerTurn(int countercode){
        //battle has been won
        if(countercode == -2){
           return -2;
        }
        //surrender
        if(countercode == -1){
            display.print("Do you accept your opponent's surrender?(y/n)");
            if(inputTaker.getYesOrNo()){
                display.print("You accept and the battle ends.");
                return -1;
            }
            else{
                display.print("You deny the request with a vicious attack! (x2 Damage)");
                return you.giveDamage() * 2;
            }
        }
        //miss
        if(countercode == 0){
            display.print("It misses.");
            return playerTurn();
        }
        else{
            //print out toString of each being?
            you.takeDamage(countercode);
            display.print("You take damage! Your health is now " + you.getHp() + ".");
            if(you.isAlive()){
                return playerTurn();
            }
            return -2;
        }
    }
    private int opponentTurn(int countercode){
        //battle has been won
        if(countercode == -2){
            return -2;
        }
        //surrender
        if(countercode == -1){
            if(opponent.decideTime()){
                display.print("They accept and the battle ends.");
                return -1;
            }
            else{
                display.print("They deny your request with a vicious attack! (x2 Damage)");
                return opponent.giveDamage() * 2;
            }
        }
        //miss
        if(countercode == 0){
            display.print("It does not land...");
            return playerTurn();
        }
        else{
            //print out toString of each being?
            opponent.takeDamage(countercode);
            display.print("It lands successfully. Their health is now " + opponent.getHp() + ".");
            if(opponent.isAlive()){
                return opponentTurn();
            }
            return -2;
        }
    }
    public Boolean getResult(){
        return this.result;
    }
}
