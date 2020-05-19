package Store;

import java.util.Scanner;

abstract class User {


    protected String basicCommands =     "\nAvailable commands:\n" +
                                    "|-listItems: displays all available items\n" +
                                    "|-openItem(item name): display the name, price and description for an item";


    //List all items in the store
    abstract public void listItems();

    //Display the name, price and description for given item
    abstract public void openItem(Item item);

    //Display commands
    public abstract void help();
}


