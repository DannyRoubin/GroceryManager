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

    public boolean getIsGround() {
        return this.isGround;
    }

    public void setisGround(boolean isGround) {
        this.isGround = isGround;
    }
    
    
}
