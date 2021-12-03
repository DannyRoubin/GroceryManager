
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
    private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
    public HashSet <String> restockingList = new HashSet<String>();

    public void loadInventory(String fileName) {
        Scanner S = null;
        try {
            S = new Scanner(new File(fileName));
            int dairyCount = S.nextInt();
            int ProduceCount = S.nextInt();
            int MeatCount = S.nextInt();

            S.nextLine();

            for (int i = 0; i < dairyCount; i++) {
                Dairy newDairy = new Dairy(S.nextLine());
                inventory.add(newDairy);
            }

            for (int i = 0; i < ProduceCount; i++) {
                Produce newProduce = new Produce(S.nextLine());
                inventory.add(newProduce);
            }

            for (int i = 0; i < MeatCount; i++) {
                Meat newMeat = new Meat(S.nextLine());
                inventory.add(newMeat);
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {
        String[] orderParts;

        for (int i = 0; i < order.size(); i++) {
            boolean existsInInventory = false;
            // System.out.println(order.get(i).toString());

            for (int j = 0; j < inventory.size(); j++) {
                if ((order.get(i).getName()).compareTo(inventory.get(j).getName()) == 0) {
                    existsInInventory = true;
                    // System.out.println("great success!");
                    if (inventory.get(j).getQuantity() > 0) {
                        inventory.get(j).setQuantity(inventory.get(j).getQuantity() - order.get(i).getQuantity());
                        if (inventory.get(j).getQuantity() <= 0) {
                            inventory.get(j).setQuantity(0);
                            restockingList.add(inventory.get(j).getName());
                            // throw new GroceryException("out of " + inventory.get(j).getName());
                            System.out.println("out of " + inventory.get(j).getName());
                        }
                    } else if (inventory.get(j).getQuantity() < 1) {
                        // throw new GroceryException("out of " + inventory.get(j).getName());
                        System.out.println("out of " + inventory.get(j).getName());

                    }
                }
            }
            if (existsInInventory == false) {
                // throw new GroceryException("Item was not found in inventory");
                System.out.println("Item not found in inventory");
            }

        }

        // System.out.println("----------------------------------");
        // System.out.println("");

    }


    public GroceryItem findItemByName(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().compareTo(name) == 0) {
                return inventory.get(i);
            }
        }
        return null;
    }

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

    public void displayRestockingList() {
        Iterator itr = restockingList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
    }

    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {

            System.out.println(inventory.get(i).toString());
        }
    }

}