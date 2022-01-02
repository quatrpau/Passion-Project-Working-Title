package models;

import interfaces.Being;

import java.util.Random;

//replace with individual enemy classes
public class Enemy implements Being {
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

    public int decideTime(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    //give reward
    public boolean surrenderDecision(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
