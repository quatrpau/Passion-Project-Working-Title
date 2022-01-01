import interfaces.Item;
import models.desert.Door;
import models.desert.Rock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RockTest {
    @Test
    public void rockTest(){
        Item rock = new Rock();
        Door door = new Door();
        //door.getAffected(rock);
        Assertions.assertTrue(rock instanceof Rock);
    }
}
