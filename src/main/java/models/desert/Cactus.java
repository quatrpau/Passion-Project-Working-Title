package models.desert;

import interfaces.Being;

//cactus fight
public class Cactus implements Being {
    @Override
    public int giveDamage() {
        return 0;
    }

    @Override
    public void takeDamage(int amt) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getHp() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
