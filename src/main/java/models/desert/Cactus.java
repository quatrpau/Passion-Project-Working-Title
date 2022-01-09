package models.desert;

import interfaces.Challenger;
import interfaces.EnvironmentAsset;
import interfaces.Obtainable;
import utilities.AnsiColor;
import utilities.IOConsole;

import java.util.Random;

//cactus fight
public class Cactus implements Challenger {
    private int hp = 100;
    private int speed = 20;
    private int damage = 35;
    private boolean inBattle = false;
    private final String normalText = "Just a normal cactus.";
    private final String battleText = "A cactus with nothing to lose.";
    private final String name = "Cactus";
    private final IOConsole console = AnsiColor.YELLOW.ioConsole;
    @Override
    public int giveDamage() {
        return this.damage;
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
    public Obtainable giveReward() {
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
    public void setBattleStatus(Boolean status){
        inBattle = status;
    }

    @Override
    public void giveFlavorText() {
        if(inBattle){
            console.println(name + ":");
            console.println(this.battleText);
        }
        else{
            console.println(this.normalText);
        }
    }
}
