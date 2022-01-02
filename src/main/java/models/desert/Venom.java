package models.desert;

import interfaces.Item;

public class Venom implements Item {
    @Override
    public String getName() {
        return "Venom";
    }

    @Override
    public String getDescription() {
        return "A potent concoction of poison from the stinger of a scorpion.";
    }
}
