package models.desert;

import interfaces.Challenger;
import interfaces.Obtainable;
import utilities.IOConsole;

import java.util.Random;

public class Snake implements Challenger {
    private int hp = 200;
    private int speed = 20;
    private int damage = 35;
    private String name = "Snake";
    private final String flavorText = "A normal snake in all respects except for its thick armour-like skin";
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
        Snakeskin.statIncrease();
        return new Snakeskin();
    }

    @Override
    public int decideTime() {
        //favors blocking
        Random random = new Random();
        int rando = random.nextInt(100) + 1;
        if(hp > 30){
            if(rando >= 25 ){
                return 3;
            }
            else{
                return 2;
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
        Random random = new Random();
        if(hp > 100){
            return false;
        }
        else if(hp < 25){
            return true;
        }
        return random.nextBoolean();
    }

    @Override
    public void giveFlavorText() {
        IOConsole.printlin(name + ":");
        IOConsole.printlin(flavorText);
    }
}
