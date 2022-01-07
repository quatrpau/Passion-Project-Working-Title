package utilities;

import interfaces.Obtainable;

import java.util.HashMap;
import java.util.Locale;

//maybe make item an abstract class to override imple of toString()
public final class Inventory {
    //checkInventory will print a string output of the contents
    HashMap<String, Obtainable> inventory;
    public Inventory(){
        this.inventory = new HashMap<>();
    }
    public void add(Obtainable obtainable){
        this.inventory.put(obtainable.getName().toLowerCase(Locale.ROOT), obtainable);
    }
    public void remove(String item){
        this.inventory.remove(item);
    }
    public Obtainable peek(String item){
        if(inventory.containsKey(item)){
            return inventory.get(item);
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory{ ");
        for(String i: this.inventory.keySet()){
           sb.append(inventory.get(i).getName()).append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
