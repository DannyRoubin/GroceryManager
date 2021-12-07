/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a subclass of grocery item for produce products
*/
public class Produce extends GroceryItem {
    // is organic is unique to produce items
    private boolean isOrganic;

    // constructor which allows us to create a produce object
    public Produce (String name, int quantity, double price, boolean isOrganic) {
        super(name, quantity, price);
        this.isOrganic = isOrganic;
    }

    // takes a line of input and parses it to create a produce object
    public Produce (String inputLine) {
        String useable = inputLine.substring(8);
        String tempArray[] = useable.split(" ", 4);
        name = tempArray[0];
        quantity = Integer.parseInt(tempArray[1]);
        price = Double.parseDouble(tempArray[2]);
        if(tempArray[3].equals("true")) {
            isOrganic = true;
        } else {
            isOrganic =  false;
        }
    }

    // setter for isOrganic
    public void setIsOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    // getter for is organic
    public boolean getIsOrganic() {
        return this.isOrganic;
    }

    // toString method that calls the super toString and combines it with the local class toString
    public String toString() {
        String temp = super.toString();
        String temp2 = String.format("Organic: %-15s ", getIsOrganic());
        return temp + temp2;
    }
    
}
