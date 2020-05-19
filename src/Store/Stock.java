package Store;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private HashMap<Item, Integer> stock = new HashMap<Item, Integer>(50);

    public void add(Item item, Integer quantity) {
        stock.put(item, quantity);
    }

    //Removes item from basket
    public void remove(Item item){
        stock.remove(item);
    }

    public void setQuantity(Item item, Integer newValue) {
        for (Map.Entry<Item, Integer> pair : stock.entrySet()) {
            if (pair.getKey().equals(item)) {
                pair.setValue(newValue);
                break;
            }
        }
    }

    public void editItem(Item oldItem, Item newItem, Integer quantity) {
        stock.remove(oldItem);
        stock.put(newItem, quantity);
    }

}
