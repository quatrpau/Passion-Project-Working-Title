package models.desert;

import interfaces.Item;

public class Snakeskin implements Item {
    @Override
    public String getName() {
        return "Snakeskin";
    }

    @Override
    public String getDescription() {
        return "A rudimentary armor.";
    }
}
