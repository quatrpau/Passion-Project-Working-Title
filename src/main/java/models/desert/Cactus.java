package models.desert;

import interfaces.Being;
import interfaces.Challenger;
import interfaces.Item;

import java.util.Random;

//cactus fight
public class Cactus implements Challenger {
    private int hp = 100;
    private int speed = 20;
    private int strength = 35;
    private boolean inBattle = true;
    private final String normalText = "Just a normal cactus.";
    private final String battleText = "A cactus with nothing to lose.";
    private final String name = "Cactus";
    @Override
    public int giveDamage() {
        return this.strength;
    }

    @Override
    public void takeDamage(int amt) {
        hp-=amt;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String toString(){
        if(inBattle){
            return this.battleText;
        }
        else{
            return this.normalText;
        }
    }

    @Override
    public Item giveReward() {
        return new CactusFlesh();
    }
    @Override
    public int decideTime(){
        //simple imple?
        //50-50
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    @Override
    public boolean surrenderDecision(){
        Random random = new Random();
        return random.nextBoolean();
    }
    public void setBattleStatus(){
        inBattle = true;
    }
}
