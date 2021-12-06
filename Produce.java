public class Produce extends GroceryItem {
    private boolean isOrganic;

    public Produce (String name, int quantity, double price, boolean isOrganic) {
        super(name, quantity, price);
        this.isOrganic = isOrganic;
    }

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

    public void setIsOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    public boolean getIsOrganic() {
        return this.isOrganic;
    }
    
}
