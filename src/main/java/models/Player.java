package models;

import interfaces.Being;

public final class Player implements Being {
    //strength
    //vitality
    //stamina
    //hp
    private int strength;
    private int hp;
    private static final Player YOU = new Player();
    private Player(){
        this.hp = 100;
        this.strength = 100;
    }
    @Override
    public int giveDamage() {
        return strength;
        //crit hits?
    }

    @Override
    public void takeDamage(int amt) {
        this.hp -= amt;
        //maybe check isAlive here and return boolean?
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getHp() {
        return 0;
    }
}
