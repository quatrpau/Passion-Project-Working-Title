package models.desert;

import interfaces.Item;

public class Machete implements Item {

    @Override
    public String getName() {
        return "Machete";
    }

    @Override
    public String getDescription() {
        return "A bit rusty, but still does the job.";
    }

    public static int getDamageIncrease(){
        return 100;
    }
}
