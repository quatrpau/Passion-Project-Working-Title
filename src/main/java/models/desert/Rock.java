package models.desert;

import interfaces.Obtainable;
import interfaces.Usable;

public class Rock implements Obtainable, Usable {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public String getDescription() {
        return "A sizable hunk of solidified lava. Pretty heavy. \n" ;
    }

}
