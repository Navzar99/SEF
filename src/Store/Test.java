package Store;

public class Test {

    public static void main(String[] args) {
        Item sampon = new Item("Nivea", 3);
        Item cereale = new Item("Ovazus", 4);
        Guest alex = new Guest();
        Customer bob = new Customer();


        bob.addToBasket(sampon, 20);
        bob.addToBasket(cereale, 3);
        bob.viewBasket();
    }
}
