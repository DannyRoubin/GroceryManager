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
	// arraylist that holds grocerOrders
	static ArrayList<GroceryOrder<GroceryItem>> orders = new ArrayList<>();

	public static void main(String[] args) {
		GroceryManager manager = new GroceryManager();

		// stock store

		// stocks the store by passing the filename into loadInventory
		manager.loadInventory("groceryInventory.txt");

		System.out.println("******** Initial Inventory ********");
		// prints out the inventory
		manager.displayInventory();

		// purchase items
		System.out.println("\n******** Processing Orders ********");
		//
		readOrders();
		// for each order, have the manager process the order
		for (GroceryOrder<GroceryItem> order : orders) {
			try {
				manager.processOrder(order);
			} catch (GroceryException e) {
				System.out.println(e.getMessage());
			}
		}
		manager.displayInventory();

		// sort inventory
		// sorts the inventory by name
		manager.sortInventoryByName();
		System.out.println("\n******** Sort by name ********");
		manager.displayInventory();

		// sort inventory by price
		manager.sortInventoryByPrice();
		System.out.println("\n******** Sort by price ********");
		manager.displayInventory();

		System.out.println("\n********  Restocking List ********");
		// displays the restocking list
		manager.displayRestockingList();
	}

	// populates the araylist (groceryOrder) with orders read from files
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
