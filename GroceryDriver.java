/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a driver to make sure all methods are working as intended
*/

/*
* CSS 143 Final Assignment: Grocery Manager
* Instructor: Lesley Kalmin
*
*
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Driver for Grocery Manager:  Read files, process orders, sort and print results
*/
public class GroceryDriver {
	static ArrayList<GroceryOrder<GroceryItem>> orders = new ArrayList<>();

	public static void main(String[] args) {
		GroceryManager manager = new GroceryManager();

		// stock store

		manager.loadInventory("groceryInventory.txt");

		System.out.println("******** Initial Inventory ********");
		manager.displayInventory();

		// purchase items
		System.out.println("\n******** Processing Orders ********");
		readOrders();
		// int counter = 1;
		for (GroceryOrder<GroceryItem> order : orders) {
			try {
				// System.out.println("Order " + counter);
				manager.processOrder(order);
				// counter++;
			} catch (GroceryException e) {
				System.out.println(e.getMessage());
			}
		}
		

	// 	// sort inventory
	// 	manager.sortInventoryByName();
	// 	System.out.println("\n******** Sort by name ********");
	// 	manager.displayInventory();

	// 	manager.sortInventoryByPrice();
	// 	System.out.println("\n******** Sort by price ********");
	// 	manager.displayInventory();

		System.out.println("\n********  Restocking List ********");
		manager.displayRestockingList();
	}

	public static void readOrders() {
		Scanner input = null;
		String line;
		String[] parts;
		try {
			input = new Scanner(new FileInputStream("groceryOrders.txt"));

			while (input.hasNext()) {
				GroceryOrder<GroceryItem> list = new GroceryOrder<>();
				input.nextLine();// ORDER
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Dairy(parts[1], Integer.parseInt(parts[2]), 0, 0));
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Produce(parts[1], Integer.parseInt(parts[2]), 0, false));
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Meat(parts[1], Integer.parseInt(parts[2]), 0, false));

				orders.add(list);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			input.close();
		}
	}
}
