import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GroceryManager {
    private ArrayList <GroceryItem> inventory = new ArrayList<GroceryItem>();

    public void loadInventory(String fileName) {
        Scanner S = null;
        try {
            S = new Scanner(new File (fileName));
            int dairyCount = S.nextInt();
            int ProduceCount = S.nextInt();
            int MeatCount = S.nextInt();

            S.nextLine();

            for (int i = 0; i < dairyCount; i++) {
                Dairy newDairy = new Dairy(S.nextLine());
                inventory.add(newDairy);
            }
            // System.out.println(inventory);
            // System.out.println("");
            // System.out.println("-----------------------");
            
            for (int i = 0; i < ProduceCount; i++) {
                Produce newProduce = new Produce(S.nextLine());
                inventory.add(newProduce);
            }
            // System.out.println(inventory);


        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
    }


    public void displayInventory() {
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).toString());
        }
    }


   

}