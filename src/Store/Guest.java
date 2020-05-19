package Store;

public class Guest extends User{
    protected String username;
    protected String password;


    //List all items in the store
    public void listItems() {

    }

    //Display the name, price and description for given item
    public void openItem(Item item){
        System.out.println(item);
    }

    //Display commands
    public void help(){
        System.out.println(basicCommands);
    }
}
