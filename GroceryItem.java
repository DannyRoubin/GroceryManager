/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be the parent class for dairy, produce, and meat classes.
This class will create a grocery item which will be extended by one of its subclasses
*/
// parent class for all "grocery items"
public abstract class GroceryItem implements Comparable {
    // all grocery items will have a name, quantity, and price
    protected String name;
    protected int quantity;
    protected double price;

    // constructor which takes an item name, quantity, and price
    public GroceryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // empty no input constructor since we don't want to use it
    public GroceryItem() {
        
    }

    // setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // getter for the name
    public String getName() {
        return this.name;
    }

    // setter for the price
    public void setPrice(double price) {
        this.price = price;
    }

    // getter for the price
    public double getPrice() {
        return this.price;
    }

    // setter for the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // getter for the quantity
    public int getQuantity() {
        return this.quantity;
    }

    // to string which formats the data to make it more presentable
    @Override
    public String toString() {
        String temp = String.format("Name: %-20s ", getName());
        String temp2 = String.format("Quantity: %-10s ", getQuantity());
        String temp3 = String.format("Price: %-15s ", getPrice());
        return temp + temp2 + temp3;
    }


    // compare to method which allows us to compare two grocery items
    @Override
    public int compareTo(Object o) {
        if (o instanceof GroceryItem) {
            GroceryItem otherGroceryItem = (GroceryItem) o;
            return this.name.compareTo(otherGroceryItem.name);
        }
        throw new ClassCastException();
    }


    
}
