/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Grocery Manager assignment

Purpose of this file/class is to be a specialized exception class to handle any
exceptions thrown by any of my classes for this project
*/
public class GroceryException extends Exception {

    public GroceryException() {

    }

    public GroceryException(String errorMessage) {
        super(errorMessage);
    }
    
}
