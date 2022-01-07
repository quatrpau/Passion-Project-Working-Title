package models.desert;

import interfaces.Affectable;
import interfaces.EnvironmentAsset;
import models.Player;

import java.util.Locale;

public class Door implements Affectable<Rock>, EnvironmentAsset {
    private String flavorText = "Upon closer inspection, you see that the door is locked," +
            "\n but the lock is very rusty and could be forced open.";
    private boolean open = false;
    @Override
    public Boolean getAffected(Rock catalyst) {
        if(!open && Player.getYou().hasItem(catalyst.getName().toLowerCase(Locale.ROOT))){
            setFlavorText("The door no longer hinders you.");
            return open = true;
        }
        //false
        return false;
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
    public boolean isOpen(){
        return this.open;
    }
    @Override
    public String toString(){
        return flavorText;
    }

    @Override
    public void giveFlavorText() {
    }
}
