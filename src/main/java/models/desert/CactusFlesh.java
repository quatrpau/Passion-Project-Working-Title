package models.desert;

import interfaces.Affectable;
import interfaces.Item;

//interface for flavor text? //ie describable
public class CactusFlesh implements Item {
    @Override
    public String getName() {
        return "Cactus Flesh";
    }

    @Override
    public String getDescription() {
        return "Quenches your thirst and restores your health.";
    }
}
