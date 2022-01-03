package models.desert;

import interfaces.Challenger;
import interfaces.Item;

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
    public Item giveReward() {
        Venom.statIncrease();
        return new Venom();
    }

    @Override
    public int decideTime() {
        //favors attack
        Random random = new Random();
        int rando = random.nextInt(100) + 1;
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
        Random random = new Random();
        if(hp > 50){
            return false;
        }
        else if(hp < 25){
            return true;
        }
        return random.nextBoolean();
    }
}
