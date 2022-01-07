import interfaces.Obtainable;
import models.Enemy;
import models.desert.Door;
import models.desert.Rock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void rockTest(){
        Obtainable rock = new Rock();
        Door door = new Door();
        Assertions.assertTrue(rock instanceof Rock);
    }
    @Test
    public void decideTimeTest(){
        Enemy enemy = new Enemy("a",1,1,1);
        //Assertions.assertTrue(enemy.decideTime());
    }
}
