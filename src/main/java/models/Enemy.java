package models;

import interfaces.Being;
import interfaces.Challenger;
import interfaces.Item;

import java.util.Random;

//replace with individual enemy classes
public class Enemy implements Challenger {
    public String name;
    public int speed;
    public int strength;
    public int hp;
    public Enemy(String name,int hp, int strength,int speed){
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.speed = speed;
    }
    @Override
    public int giveDamage() {
        //have this depend on multiple values
        return strength;
    }

    @Override
    public void takeDamage(int amt) {
        this.hp -= amt;
        //maybe check isAlive here and return boolean?
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public int getHp() {
        return hp;
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
    public int decideTime(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    @Override
    public boolean surrenderDecision(){
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public Item giveReward() {
        return null;
    }
}
