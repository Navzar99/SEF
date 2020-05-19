package Store;

import jdk.jfr.Unsigned;

import java.util.HashMap;

public class Order {
    private HashMap<Item, Integer> basket = new HashMap<Item, Integer>(5);
    private int totalPrice;

    public Order(){
        totalPrice = 0;
    }

    //Adds item to basket with quantity
    public void addItem(Item item, Integer quantity) {
        basket.put(item, quantity);
        totalPrice += item.getPrice() * quantity;
    }

    public void removeItem (Item item){
        totalPrice -= item.getPrice() * basket.get(item);
        basket.remove(item);
    }

    

    public int getTotalPrice() {
        return totalPrice;
    }
}
