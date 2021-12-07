/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be the parent class for dairy, produce, and meat classes.
This class will create a grocery item which will be extended by one of its subclasses
*/
public abstract class GroceryItem implements Comparable {
    protected String name;
    protected int quantity;
    protected double price;

    public GroceryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public GroceryItem() {
        

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        String temp0 = "Name: " + getName() + "      Quantity: " + getQuantity() + "      Price: " + getPrice();
        String temp = String.format("Name: %-20s ", getName());
        String temp2 = String.format("Quantity: %-10s ", getQuantity());
        String temp3 = String.format("Price: %-15s ", getPrice());
        return temp + temp2 + temp3;
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
