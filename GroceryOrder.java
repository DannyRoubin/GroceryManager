/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a list of grocery items which extends arraylist
but only allows items that are of type groceryItem in
*/
import java.util.ArrayList;

// making groceryOrder be an arraylist that can only contain items of time GroceryItem
public class GroceryOrder <T extends GroceryItem> extends ArrayList <T> {
    
}
