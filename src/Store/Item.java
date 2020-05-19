package Store;

import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
