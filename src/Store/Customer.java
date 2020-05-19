package Store;

import jdk.jfr.Unsigned;

import java.util.HashMap;

public class Customer extends User {
    private String username;
    private String password;



    private String customerCommands =   "\n" +
                                        "|-viewHistory: displays the history of past orders\n" +
                                        "|-addToBasket(item): adds item to the basket\n" +
                                        "|-removeFromBasket(item): removes item from basket\n" +
                                        "|-viewBasket: display the contents of the basket\n" +
                                        "|-placeOrder: sends the current basket to HQ";

    @Override//lists items
    public void listItems() {

    }

    @Override//displays item
    public void openItem(Item item) {
        System.out.println(item);
    }

    @Override
    public void help() {
        System.out.println(basicCommands + customerCommands);
    }


    Item Rosi = new Item("Rosi", 3);
}
