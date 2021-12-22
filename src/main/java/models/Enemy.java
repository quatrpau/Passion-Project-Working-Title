package models;

import interfaces.Being;

public class Enemy implements Being {
    public int strength;
    public int hp;
    public Enemy(int hp, int strength){
        this.hp = hp;
        this.strength = strength;
    }
    @Override
    public int giveDamage() {
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
}
