public abstract class GroceryItem implements Comparable {
    protected String name;
    protected int quantity;
    protected double price;

    public GroceryItem(String name, int quantity, double price) {
        // reminder for self to make checkpoints to check for valid data
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        // return "Name: " + getName() + "      Quantity: " + getQuantity() + "      Price: " + getPrice();

        String temp = "Name: " + getName() + "      Quantity: " + getQuantity() + "      Price: " + getPrice();

        if(this instanceof Dairy) {
            Dairy tempDairy = (Dairy) this;
            return temp + "      Temperature: " +  tempDairy.getRefrigerationTemperature(); 
        } else if (this instanceof Produce) {
            Produce tempProduce = (Produce) this;
            return temp + "      Organic: " + tempProduce.getIsOrganic();
        } else if( this instanceof Meat) {
            Meat tempMeat = (Meat) this;
            return temp + "      Ground: " + tempMeat.getIsGround();
        }
        else {
            return "Nah";
        }
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
