package Store;

import java.util.Scanner;

abstract class User {


    protected String basicCommands =     "\nAvailable commands:\n" +
                                    "|-listItems: displays all available items\n" +
                                    "|-openItem(item name): display the name, price and description for an item";


    //List all items in the store
    abstract public void listItems(Stock stock);

    //Display the name, price and description for given item
    abstract public void openItem(Stock stock, String name);

    //Display commands
    public abstract void help();
}


