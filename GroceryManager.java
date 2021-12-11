
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
    private HashSet<String> restockingList = new HashSet<String>();

    // method that reads a file with the inventory and stocks the arraylist
    // inventory with it
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
        } finally {
            S.close();
        }
    }

    // method that subtracts the quantity of the item from the inventory
    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {
        // for each loop for all three of the parts of the order
        for (GroceryItem partOrder : order) {
            try {
                // calls the helper method with the part of the order
                processOrderPart2(partOrder);
            } catch (GroceryException e) {
                // catches the exception from helper method 
                System.out.println(e.getMessage());
            }
        }

    }

    public void processOrderPart2(GroceryItem partOrder) throws GroceryException {
        // checks if the order quantity is greater than 0, if it is then we can continue 
        if (partOrder.getQuantity() > 0) {

            // uses find item by name to find the object from the inventory
            GroceryItem inventoryObj = findItemByName(partOrder.getName());
            // if the item was not found throw an exception
            if (inventoryObj == null) {
                throw new GroceryException("Item was not found in inventory");
            }

            if (inventoryObj.getQuantity() > 0) {
                // if the quantity is greater than 0 then we can subtract
                inventoryObj.setQuantity(inventoryObj.getQuantity() - partOrder.getQuantity());
                // if the item quantity got reduced to or less than 0, set it to 0, and add to restockingList
                if (inventoryObj.getQuantity() <= 0) {
                    inventoryObj.setQuantity(0);
                    restockingList.add(inventoryObj.getName());
                    throw new GroceryException("out of " + inventoryObj.getName());

                }
                // if the quantity is less than 1, throw an exception
            } else if (inventoryObj.getQuantity() < 1) {
                throw new GroceryException("out of " + inventoryObj.getName());
            }
        }
    }

    // finds an item by its name, returns null if the item is not found in the list
    public GroceryItem findItemByName(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().compareTo(name) == 0) {
                return inventory.get(i);
            }
        }
        return null;
    }

    // uses bubble sort to sort the inventory by name
    public void sortInventoryByName() {
        for (int i = 0; i < (inventory.size() - 1); i++) {
            for (int j = 0; j < (inventory.size() - 1 - i); j++) {
                if (inventory.get(j).getName().compareTo(inventory.get(j + 1).getName()) > 0) {
                    GroceryItem temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }

    }

    // uses insertion sort to sort inventory by the price
    public void sortInventoryByPrice() {
        for (int i = 1; i < inventory.size(); i++) {
            GroceryItem valAtIndex = inventory.get(i);
            int prevIndex = i - 1;

            while (prevIndex >= 0 && inventory.get(prevIndex).getPrice() > valAtIndex.getPrice()) {
                inventory.set(prevIndex + 1, inventory.get(prevIndex));
                prevIndex = prevIndex - 1;
            }
            inventory.set(prevIndex + 1, valAtIndex);
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