package models.desert;

import interfaces.Being;

import java.util.Random;

//cactus fight
public class Cactus implements Being {
    private int hp;
    private int speed;
    private int strength;
    private String flavorText = "A cactus with nothing to lose.";
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
        //depends whether in battle or not
        return null;
    }
    public int decideTime(){
        //simple imple?
        //50-50
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    public boolean surrenderDecision(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
