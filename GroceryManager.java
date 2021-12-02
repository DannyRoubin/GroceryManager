
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
import java.util.Scanner;

public class GroceryManager {
    private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();

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
                            // add to restock list
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

    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {

            System.out.println(inventory.get(i).toString());
        }
    }

}