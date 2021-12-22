package utilities;

import models.Enemy;

//have battle interface
public class Battle {
    private Enemy opponent;
    public Battle(Enemy opponent) {
        this.opponent = opponent;
        this.start();
    }
    public boolean start(){
        return false;
        //while()
    }
}
