package Store;

import jdk.jfr.Unsigned;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    private String username;
    private String password;

    private Order order = new Order();
    private ArrayList<Order> history = new ArrayList<Order>();


    @Override//lists items from the store
    public void listItems(Stock stock) {
        for (Map.Entry<Item, Integer> pair : stock.getStock().entrySet()) {
            System.out.println("Item: " + pair.getKey().getName() +
                    "\tPrice: " + pair.getKey().getPrice() +
                    "\tStock:" + pair.getValue());
        }
    }

    @Override//displays item
    public void openItem(Stock stock, String name) {
        for (Map.Entry<Item, Integer> pair : stock.getStock().entrySet()) {
            if (pair.getKey().getName().equals(name)) {
                System.out.println("Item: " + pair.getKey().getName() +
                        "\tPrice: " + pair.getKey().getPrice() +
                        "\tStock:" + pair.getValue());
                break;
            }
        }
    }

    //places order and sends it to HQ
    void placeOrder() {
        history.add(order);
    }

    @Override//Displays the commands available to the customer
    public void help() {
        String customerCommands = "\n" +
                "|-viewHistory: displays the history of past orders\n" +
                "|-addToBasket(item): adds item to the basket\n" +
                "|-removeFromBasket(item): removes item from basket\n" +
                "|-viewBasket: display the contents of the basket\n" +
                "|-placeOrder: sends the current basket to HQ";
        System.out.println(basicCommands + customerCommands);
    }


    //ads products to basket
    public void addToBasket(Item item, Integer quantity) {
        if (quantity < 0) {
            System.out.println("Quantity must be positive");
        }
        else {
            order.add(item, quantity);
        }
    }

    //removes item from basket
    public void removeFromBasket(Item item) {
        order.remove(item);
    }

    //prints the basket
    public void viewBasket() {
        System.out.println(order);
    }

    public void viewHistory() {
        for(Order i : history) {
            System.out.println(i);
        }
    }

}
