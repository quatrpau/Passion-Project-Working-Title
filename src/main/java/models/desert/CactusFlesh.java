package models.desert;

import interfaces.Obtainable;

//interface for flavor text? //ie describable
public class CactusFlesh implements Obtainable {
    @Override
    public String getName() {
        return "Cactus Flesh";
    }

    @Override
    public String getDescription() {
        return "Quenches your thirst and restores your health.";
    }
}
