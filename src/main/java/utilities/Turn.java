package utilities;

import interfaces.Being;

public class Turn {
    private final Action action;
    private final Being owner;
    private int magnitude;
    public Turn(Action action, Being owner){
        this.action = action;
        this.owner = owner;
        if (action == Action.ATTACK) {
            magnitude = owner.giveDamage();
        }
        //debuff this and upgrade the opponent?
        else if (action == Action.CHEAP_SHOT){
            magnitude = owner.giveDamage() * 2;
        }
        else {
            magnitude = 0;
        }
    }
    public Action getAction() {
        return action;
    }
    public int getMagnitude(){
        return magnitude;
    }
    public Being getOwner(){
        return owner;
    }
    public void setMagnitude(int magnitude){
        this.magnitude = magnitude;
    }
}
