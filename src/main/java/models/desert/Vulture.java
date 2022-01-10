package models.desert;

import interfaces.Challenger;
import interfaces.Obtainable;
import utilities.AnsiColor;
import utilities.IOConsole;

import java.util.Random;

public class Vulture implements Challenger {
    private int hp = 100;
    private int speed = 500;
    private int damage = 35;
    private String name = "Vulture";
    private String flavorText = "Resembles a vulture, yet is fast as a hawk.";
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
        return hp>0;
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
        AnsiColor.RED.ioConsole.println("You got a Feather");
        Feather.statIncrease();
        return new Feather();
    }

    @Override
    public int decideTime() {
        //has no preference
        int rando = new Random().nextInt(100) + 1;
        if(hp > 30){
            if(rando >= 25 ){
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
                return 3;
            }
            else{
                return 2;
            }
        }
    }

    @Override
    public boolean surrenderDecision() {
        //no chance of surrender until lower
        if(hp > 50){
            return false;
        }
        else if(hp < 15){
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
