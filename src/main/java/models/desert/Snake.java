package models.desert;

import interfaces.Challenger;
import interfaces.Item;

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
    public Item giveReward() {
        Snakeskin.statIncrease();
        return new Snakeskin();
    }

    @Override
    public int decideTime() {
        //favors blocking
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    @Override
    public boolean surrenderDecision() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
