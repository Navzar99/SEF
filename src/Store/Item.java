package Store;

public class Item {

    private String name;
    private int price;
    private String description;



    public Item(String name, int price) {
        this.name = name;
        this.price = price;

        description = "Description";
    }

    public Item(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "\n" +
                price + " ron\n" +
                description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
}
