public class Dairy extends GroceryItem {
    private int refrigerationTemperature;

    public Dairy(String name, int quantity, double price, int refrigerationTemperature) {
        super(name, quantity, price);
        this.refrigerationTemperature = refrigerationTemperature;
    }

    public Dairy (String inputLine) {
        String useable = inputLine.substring(6);
        String tempArray[] = useable.split(" ", 4);
        name = tempArray[0];
        quantity = Integer.parseInt(tempArray[1]);
        price = Double.parseDouble(tempArray[2]);
        refrigerationTemperature = Integer.parseInt(tempArray[3]);

    }


    public int getRefrigerationTemperature() {
        return this.refrigerationTemperature;
    }

    public void setRefrigerationTemperature(int refrigerationTemperature) {
        this.refrigerationTemperature = refrigerationTemperature;
    }

    
}