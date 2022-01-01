package models.desert;

import interfaces.Item;
import interfaces.Usable;

public class Rock implements Item, Usable {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public String getDescription() {
        return "A sizable hunk of solidified lava. \n" ;
    }

}
