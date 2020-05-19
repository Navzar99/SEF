package Store;

import java.util.Map;

public class Admin extends User{
    private String username;
    private String password;
    private String adminCommands = " ";

    @Override
    public void listItems(Stock stock) {
        for (Map.Entry<Item, Integer> pair : stock.getStock().entrySet()) {
            System.out.println("Item: " + pair.getKey().getName() +
                                "\tPrice: " + pair.getKey().getPrice() +
                                "\tStock:" + pair.getValue());
        }
    }

    @Override
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

    @Override
    public void help() {
        System.out.println(basicCommands + adminCommands);
    }
}
