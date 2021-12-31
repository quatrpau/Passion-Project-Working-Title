package models.desert;

import interfaces.Item;
import interfaces.Usable;

public class Rock implements Item, Usable {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public String getFlavorText() {
        return "A sizable hunk of solidified lava. Could be sedimentary, igneous, or metamorphosis but you don't know, or care. \n" ;
    }

}
