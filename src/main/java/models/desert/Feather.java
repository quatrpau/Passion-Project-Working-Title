package models.desert;

import interfaces.Item;

public class Feather implements Item {

    @Override
    public String getName() {
        return "Feather";
    }

    @Override
    public String getDescription() {
        return "A feather from a vulture.";
    }
}
