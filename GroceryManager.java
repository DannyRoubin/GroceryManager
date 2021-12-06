
/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to act as a grocery manager where it loads inventory in,
checks inventory count, restocks, and any other tasks a real grocery manager would take care of.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class GroceryManager {
    // private arraylist used for keeping track of the inventory
    private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
    // hashSet used to keep track of what needs to be added to the restockingList
    private HashSet <String> restockingList = new HashSet<String>();

    // method that reads a file with the inventory and stocks the arraylist inventory with it
    public void loadInventory(String fileName) {
        Scanner S = null;
        try {
            S = new Scanner(new File(fileName));
            int dairyCount = S.nextInt();
            int ProduceCount = S.nextInt();
            int MeatCount = S.nextInt();

            S.nextLine();

            // adding the dairys first since they come first on the list
            for (int i = 0; i < dairyCount; i++) {
                Dairy newDairy = new Dairy(S.nextLine());
                inventory.add(newDairy);
            }

            // adding the produce next since thats next on the list
            for (int i = 0; i < ProduceCount; i++) {
                Produce newProduce = new Produce(S.nextLine());
                inventory.add(newProduce);
            }

            // adds meats last since it comes last
            for (int i = 0; i < MeatCount; i++) {
                Meat newMeat = new Meat(S.nextLine());
                inventory.add(newMeat);
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    // method that subtracts the quantity of the item from the inventory 
    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {

        for (int i = 0; i < order.size(); i++) {
            boolean existsInInventory = false;

            // scrolls through the inventory to find the item
            for (int j = 0; j < inventory.size(); j++) {
                if ((order.get(i).getName()).compareTo(inventory.get(j).getName()) == 0) {
                    existsInInventory = true;
                    // once the item is found, check to make sure we still have it in stock
                    if (inventory.get(j).getQuantity() > 0) {
                        inventory.get(j).setQuantity(inventory.get(j).getQuantity() - order.get(i).getQuantity());
                        if (inventory.get(j).getQuantity() <= 0) {
                            // once the quantity hits or falls below 0
                            // set the quantity to 0
                            inventory.get(j).setQuantity(0);
                            // add it to the restockingList
                            restockingList.add(inventory.get(j).getName());
                            // throw an exception to say we are out of that item
                            throw new GroceryException("out of " + inventory.get(j).getName());
                        }
                        // if we're out of stock, throw the exception
                    } else if (inventory.get(j).getQuantity() < 1) {
                        throw new GroceryException("out of " + inventory.get(j).getName());
                    }
                }
            }
            if (existsInInventory == false) {
                throw new GroceryException("Item was not found in inventory");
            }

        }

    }


    // finds an item by its name, returns null if the item is not found in the list
    public GroceryItem findItemByName(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().compareTo(name) == 0) {
                return inventory.get(i);
            }
        }
        return null;
    }


    // uses bubble sort to sort the inventory by name
    public void sortInventoryByName() {
        for (int i = 0; i < (inventory.size() - 1); i++) {
            for(int j = 0; j < (inventory.size() - 1 - i); j++) {
                if(inventory.get(j).getName().compareTo(inventory.get(j+1).getName()) > 0) {
                    GroceryItem temp = inventory.get(j);
                    inventory.set(j, inventory.get(j+1));
                    inventory.set(j+1, temp);
                }
            }
        }

    }

    // uses insertion sort to sort inventory by the price
    public void sortInventoryByPrice() {
        for(int i = 1; i <inventory.size(); i++) {
            GroceryItem valAtIndex = inventory.get(i);
            int prevIndex = i-1;
            
            while(prevIndex >= 0 && inventory.get(prevIndex).getPrice() > valAtIndex.getPrice()) {
                inventory.set(prevIndex + 1, inventory.get(prevIndex)); 
                prevIndex = prevIndex-1;
            }
            inventory.set(prevIndex+1, valAtIndex);
        }
        
    }

    // method to print out the restocking list using an iterator
    public void displayRestockingList() {
        Iterator itr = restockingList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
    }

    // prints out the inventory using a for loop to go through the list
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {

            System.out.println(inventory.get(i).toString());
        }
    }

}