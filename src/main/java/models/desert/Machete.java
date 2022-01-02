package models.desert;

import interfaces.Item;
import interfaces.Usable;

public class Machete implements Item, Usable {

    @Override
    public String getName() {
        return "Machete";
    }

    @Override
    public String getDescription() {
        return "A bit rusty, but still does the job.";
    }
}
