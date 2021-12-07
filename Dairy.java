/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a subclass of grocery item for dairy products
*/
public class Dairy extends GroceryItem {
    // refrigeration temp is unique to dairy grocery items
    private int refrigerationTemperature;

    // constructor which allows us to create a dairy object
    public Dairy(String name, int quantity, double price, int refrigerationTemperature) {
        super(name, quantity, price);
        this.refrigerationTemperature = refrigerationTemperature;
    }

    // takes a line of input and parses it to create a dairy object
    public Dairy (String inputLine) {
        String useable = inputLine.substring(6);
        String tempArray[] = useable.split(" ", 4);
        name = tempArray[0];
        quantity = Integer.parseInt(tempArray[1]);
        price = Double.parseDouble(tempArray[2]);
        refrigerationTemperature = Integer.parseInt(tempArray[3]);

    }

    // setter for the refrigerationTemperature
    public void setRefrigerationTemperature(int refrigerationTemperature) {
        this.refrigerationTemperature = refrigerationTemperature;
    }

    // getter for the refrigerationTemperature
    public int getRefrigerationTemperature() {
        return this.refrigerationTemperature;
    }

    // toString method that calls the super toString and combines it with the local class toString
    public String toString() {
        String temp = super.toString();
        String temp2 = String.format("Temperature: %-15s ", getRefrigerationTemperature());
        return temp + temp2;
    }

    
}