package utilities;

import models.Enemy;
import models.Player;

import java.util.Objects;

//have better text options
public final class Battle {
    private final Enemy opponent;
    private final Player you = Player.getYou();
    private final Boolean result;
    private static final String YOUR_TURN = "What will you do? \n 1.) Surrender \n 2.) Attack \n 3.) Block";
    public Battle(Enemy opponent) {
        this.opponent = opponent;
        this.result = this.start();
    }
    //chance of peace?
    public Boolean start(){
        boolean openToPeace = false;
        Turn intraTurnCommunicationStation;
        Action actionStorage;
        int magnitude;
        Turn interTurnCommunicationStation = null;
        boolean firstTurn = true;
        //check if opponent and you are alive every turn
        while(opponent.isAlive() && you.isAlive() && !openToPeace){
            boolean playerGoesFirst = you.getSpeed() > opponent.getSpeed();
            if(firstTurn){
                if(playerGoesFirst){
                    //can these go inside each other
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
            if(intraTurnCommunicationStation.getAction() == Action.SURRENDER && interTurnCommunicationStation.getAction() == Action.SURRENDER){
                openToPeace = true;
            }
        }
        if(openToPeace){
            return null;
        }
        return you.isAlive();
    }
    //1st Turns
    private Turn playerTurn(){
        Display.print(YOUR_TURN);
        //exception handler?
        Action actionStorage;
        while(true){
            if((actionStorage = getAction(InputTaker.getPlayerInput())) != null){
                return new Turn(actionStorage, this.you);
            }
            else{
                Display.print("Invalid input: try again");
            }
        }
    }
    private Turn opponentTurn(){
        Action actionStorage = getAction(String.valueOf(opponent.decideTime()));
        switch(Objects.requireNonNull(actionStorage)){
            case SURRENDER:
                Display.print("Your opponent attempts to surrender.");
                break;
            case ATTACK:
                Display.print("Your opponent attacks!");
                break;
            case BLOCK:
                Display.print("Your opponent prepares to block");
                break;
        }
        return new Turn(actionStorage,this.opponent);
    }
    //All Other Turns
    private Turn playerTurn(Turn opponentTurn){
        //battle has been won
        if(opponentTurn.getAction() == Action.DEFER){
            return new Turn(Action.DEFER,this.you);
        }
        if(opponentTurn.getAction() == Action.SURRENDER){
            Display.print("Do you accept your opponent's surrender?(y/n)");
            if(InputTaker.getYesOrNo()){
                Display.print("You accept and the battle ends.");
                return new Turn(Action.SURRENDER, this.you);
            }
            else{
                Display.print("You deny the request with a vicious attack! (x2 Damage)");
                return new Turn(Action.CHEAP_SHOT, this.you);
            }
        }
        if(opponentTurn.getAction() == Action.BLOCK){
            Turn returnal = playerTurn();
            if(returnal.getAction() == Action.ATTACK){
                returnal.setMagnitude(returnal.getMagnitude() / 2);
            }
            return returnal;
        }
        else{
            //print out toString of each being?
            you.takeDamage(opponentTurn.getMagnitude());
            Display.print("You take damage! Your health is now " + you.getHp() + ".");
            if(you.isAlive()){
                return playerTurn();
            }
            return new Turn(Action.DEFER,this.you);
        }
    }
    private Turn opponentTurn(Turn playerTurn){
        if(playerTurn.getAction() == Action.DEFER){
            return new Turn(Action.DEFER, this.opponent);
        }
        if(playerTurn.getAction() == Action.SURRENDER){
            if(opponent.surrenderDecision()){
                Display.print("They accept and the battle ends.");
                return new Turn(Action.SURRENDER, this.opponent);
            }
            else{
                Display.print("They deny your request with a vicious attack! (x2 Damage)");
                return new Turn(Action.CHEAP_SHOT, this.opponent);
            }
        }
        if(playerTurn.getAction() == Action.BLOCK){
            Turn returnal = opponentTurn();
            if(returnal.getAction() == Action.ATTACK){
                returnal.setMagnitude(returnal.getMagnitude() / 2);
            }
            return returnal;
        }
        else {
            //print out toString of each being?
            opponent.takeDamage(playerTurn.getMagnitude());
            Display.print("It lands successfully. Their health is now " + opponent.getHp() + ".");
            if (opponent.isAlive()) {
                return opponentTurn();
            }
            return new Turn(Action.DEFER, this.opponent);
        }
    }
    public Boolean getResult(){
        return this.result;
    }
    //can this functionality be put inside the enum?
    private Action getAction(String choice) {
        //maybe add check
        switch(choice){
            case "1":
                return Action.SURRENDER;
            case "2":
                return Action.ATTACK;
            case "3":
                return Action.BLOCK;
            default:
                Display.print("Invalid choice: try again");
                return null;
        }
    }
}

//block
//attack
//surrender
//check