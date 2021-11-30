public abstract class GroceryItem implements Comparable {
    private String name;
    private int quantity;
    private int price;

    public GroceryItem(String name, int quantity, double price) {

    }

    public GroceryItem() {

    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof GroceryItem) {
            GroceryItem otherGroceryItem = (GroceryItem) o;
            return this.name.compareTo(otherGroceryItem.name);
        }
        throw new ClassCastException();
    }


    
}
