package Store;

import jdk.jfr.Unsigned;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Order {
    private HashMap<Item, Integer> basket = new HashMap<Item, Integer>(5);
    private int totalPrice;

    public Order(){
        totalPrice = 0;
    }


    //Adds item to basket with quantity
    public void add(Item item, Integer quantity) {
        basket.put(item, quantity);
        totalPrice += item.getPrice() * quantity;
    }

    //Removes item from basket
    public void remove(Item item){
        totalPrice -= item.getPrice() * basket.get(item);
        basket.remove(item);
    }


    @Override
    public String toString() {
        String buffer = "Item\t\t\tNumber\t\tPrice\n";
        buffer += "----------------------------------\n";
        //basket.forEach((key, value) -> buffer += key.getName() + );

        for (Map.Entry<Item, Integer> pair : basket.entrySet()) {
            buffer += pair.getKey().getName() + "\t\t\t\t" + pair.getValue() + "\t\t" + pair.getKey().getPrice() * pair.getValue() + " ron\n";
        }

        buffer += "----------------------------------\n";
        buffer += "Total price:\t\t\t\t" + totalPrice +" ron\n";

        return buffer;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public HashMap<Item, Integer> getBasket() {
        return basket;
    }
}
