package Store;

import java.util.Map;

public class Guest extends User{
    //List all items in the store
    public void listItems(Stock stock) {
        for (Map.Entry<Item, Integer> pair : stock.getStock().entrySet()) {
            System.out.println("Item: " + pair.getKey().getName() +
                    "\tPrice: " + pair.getKey().getPrice() +
                    "\tStock:" + pair.getValue());
        }
    }

    //Display the name, price and description for given item
    public void openItem(Stock stock, String name){
        for (Map.Entry<Item, Integer> pair : stock.getStock().entrySet()) {
            if (pair.getKey().getName().equals(name)) {
                System.out.println("Item: " + pair.getKey().getName() +
                        "\tPrice: " + pair.getKey().getPrice() +
                        "\tStock:" + pair.getValue());
                break;
            }
        }
    }

    //Display commands
    public void help(){
        System.out.println(basicCommands);
    }
}
