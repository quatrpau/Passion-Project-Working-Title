package models.desert;

import interfaces.Item;

public class Rock implements Item {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public String getFlavorText() {
        return "A sizable hunk of solidified lava. Could be sedimentary, igneous, or metamorphosis but you don't know, or care. \n" +
                "Found near a cactus.";
    }
}
