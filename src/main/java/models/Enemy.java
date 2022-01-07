package models;

import interfaces.Challenger;
import interfaces.Obtainable;

import java.util.Random;

//replace with individual enemy classes
public class Enemy implements Challenger {
    public String name;
    public int speed;
    public int damage;
    public int hp;
    public Enemy(String name, int hp, int damage, int speed){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }
    @Override
    public int giveDamage() {
        //have this depend on multiple values
        return damage;
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
    public Obtainable giveReward() {
        return null;
    }
}
