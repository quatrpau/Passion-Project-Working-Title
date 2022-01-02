package models.desert;

import interfaces.Item;

public class WaterBottle implements Item {
    @Override
    public String getName() {
        return "Water Bottle";
    }

    @Override
    public String getDescription() {
        return "Quenches your thirst!";
    }
}
