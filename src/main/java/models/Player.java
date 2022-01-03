package models;

import interfaces.Being;
import interfaces.Item;
import utilities.Display;
import utilities.Inventory;

public final class Player implements Being {
    //damage
    //vitality
    //speed
    //hp
    private String name;
    private int speed;
    private int damage;
    private int hp;
    private int maxHp;
    private final Inventory inventory;
    private static final Player YOU = new Player();
    private Player(){
        this.maxHp = 30;
        this.hp = 30;
        this.damage = 15;
        this.speed = 30;
        this.inventory = new Inventory();
    }
    @Override
    public int giveDamage() {
        return damage;
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
    public void addDamage(int increase){
        this.damage += increase;
    }
    public void addMaxHp(int increase) {this.maxHp += increase;}
    public void addSpeed(int increase) {this.speed += increase;}
    public static Player getYou(){
        return YOU;
    }
    public void setName(String name) { this.name = name;}
    @Override
    public String getName(){ return this.name;}
    public Boolean hasItem(String item){
        return this.inventory.peek(item) != null;
    }
    public Item peekItem(String item){
        return this.inventory.peek(item);
    }
    //inventory
    //returns whether it was successful
    public void addToInventory(Item item){
        this.inventory.add(item);
    }
    //statusUpdate will print of string output of players current inventory and stats and name
    public void statusUpdate(){
        Display.print(this.name + ": ");
        Display.print("Speed: " + this.speed);
        Display.print("Damage: " + this.damage);
        Display.print("HP: " + this.hp);
        Display.print(this.inventory.toString());
    }
    //describe item
    public void describeItem(String item){
        Item output = inventory.peek(item);
        if(output == null){
            Display.print("You do not have" + item + ".");
        }
        Display.print("Name: " + output.getName());
        Display.print("Description: " + output.getDescription());

    }

}
