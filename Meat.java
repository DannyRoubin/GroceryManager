/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a subclass of grocery item for dairy products
*/
public class Meat extends GroceryItem {
    private boolean isGround;

    public Meat (String name, int quantity, double price, boolean isGround) {
        super(name, quantity, price);
        this.isGround = isGround;
    }

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

    public void setIsGround(boolean isGround) {
        this.isGround = isGround;
    }

    public boolean getIsGround() {
        return this.isGround;
    }

    public String toString() {
        String temp = super.toString();
        String temp2 = String.format("Ground: %-15s ", getIsGround());
        return temp + temp2;
    }
    
    
}
