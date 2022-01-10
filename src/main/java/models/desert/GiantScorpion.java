package models.desert;

import interfaces.Challenger;
import interfaces.Obtainable;
import utilities.AnsiColor;
import utilities.IOConsole;

import java.util.Random;

public class GiantScorpion implements Challenger {
    private int hp = 100;
    private int speed = 20;
    private int damage = 80;
    private String name = "Giant Scorpion";
    private String flavorText = "A monstrous scorpion towering over 7 feet tall.";
    @Override
    public int giveDamage() {
        return damage;
    }

    @Override
    public void takeDamage(int amt) {
        hp-=amt;
    }

    @Override
    public boolean isAlive() {
        return hp >0;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Obtainable giveReward() {
        AnsiColor.RED.ioConsole.println("You got Venom!");
        Venom.statIncrease();
        return new Venom();
    }

    @Override
    public int decideTime() {
        //favors attack
        int rando = new Random().nextInt(100) + 1;
        if(hp > 30){
            if(rando <= 60 ){
                return 2;
            }
            else{
                return 3;
            }
        }
        else{
            if(rando <= 33){
                return 1;
            }
            else if(rando <= 88){
                return 2;
            }
            else{
                return 3;
            }
        }
    }

    @Override
    public boolean surrenderDecision() {
        if(hp > 50){
            return false;
        }
        else if(hp < 25){
            return true;
        }
        return new Random().nextBoolean();
    }

    @Override
    public void giveFlavorText() {
        AnsiColor.YELLOW.ioConsole.println(name + ":");
        AnsiColor.YELLOW.ioConsole.println(flavorText);
    }
}
