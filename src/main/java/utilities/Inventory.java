package utilities;

import interfaces.Item;

import java.util.ArrayList;

//maybe make item an abstract class to override imple of toString()
public class Inventory {
    //checkInventory will print a string output of the contents
    ArrayList<Item> inventory;
    public Inventory(){
        this.inventory = new ArrayList<>();
    }
    public void add(Item item){
        this.inventory.add(item);
    }
    public Item remove(Item item){
        if(this.inventory.contains(item)){
            return this.inventory.remove(this.inventory.indexOf(item));
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory{ ");
        for(Item i: this.inventory){
           sb.append(i.getName()).append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
