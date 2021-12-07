/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a subclass of grocery item for meat products
*/
public class Meat extends GroceryItem {
    // isGround is unique to meat grocery items
    private boolean isGround;

    // Constructor which allows us to create a Meat object
    public Meat (String name, int quantity, double price, boolean isGround) {
        super(name, quantity, price);
        this.isGround = isGround;
    }

    // takes a line of input and parses it to create a meat object
    public Meat (String inputLine) {
        String useable = inputLine.substring(5);
        String tempArray[] = useable.split(" ", 4);
        name = tempArray[0];
        quantity = Integer.parseInt(tempArray[1]);
        price = Double.parseDouble(tempArray[2]);
        if(tempArray[3].equals("true")) {
            isGround = true;
        } else {
            isGround =  false;
        }
    }

    // setter for is ground
    public void setIsGround(boolean isGround) {
        this.isGround = isGround;
    }

    // getter for is ground
    public boolean getIsGround() {
        return this.isGround;
    }

    // toString method that calls the super toString and combines it with the local class toString
    public String toString() {
        String temp = super.toString();
        String temp2 = String.format("Ground: %-15s ", getIsGround());
        return temp + temp2;
    }
    
    
}
