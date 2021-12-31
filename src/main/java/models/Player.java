package models;

import interfaces.Being;
import utilities.Inventory;

public final class Player implements Being {
    //strength
    //vitality
    //speed
    //hp
    private String name;
    private int speed;
    private int strength;
    private int hp;
    private Inventory inventory;
    private static final Player YOU = new Player();
    private Player(){
        this.hp = 100;
        this.strength = 100;
        this.speed = 100;
        this.inventory = new Inventory();
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
        return hp > 0;
    }
    @Override
    public int getHp() {
        return Math.max(hp, 0);
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }
    public static Player getYou(){
        return YOU;
    }
    public void setName(String name) { this.name = name;}
    public String getName(){ return this.name;}
    //statusUpdate will print of string output of players current inventory and stats and name
}
