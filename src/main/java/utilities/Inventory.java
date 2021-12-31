package utilities;

import interfaces.Item;

import java.util.HashMap;
import java.util.Locale;

//maybe make item an abstract class to override imple of toString()
public class Inventory {
    //checkInventory will print a string output of the contents
    HashMap<String, Item> inventory;
    public Inventory(){
        this.inventory = new HashMap<>();
    }
    public void add(Item item){
        this.inventory.put(item.getName().toLowerCase(Locale.ROOT), item);
    }
    public void remove(String item){
        this.inventory.remove(item);
    }
    public Item has(String item){
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
