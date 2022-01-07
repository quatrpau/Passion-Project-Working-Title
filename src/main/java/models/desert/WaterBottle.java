package models.desert;

import interfaces.Obtainable;

public class WaterBottle implements Obtainable {
    @Override
    public String getName() {
        return "Water Bottle";
    }

    @Override
    public String getDescription() {
        return "Quenches your thirst!";
    }
}
