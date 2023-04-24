package com.yl;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void list(List<String> shoppingList) {
        if (shoppingList.size() == 0) {
            System.out.println("Your cart is empty");

        } else {
            for (int i = 1; shoppingList.size() >= i; i++) {
                System.out.println(i + ". " + shoppingList.get(i - 1));
            }
        }

    }

    public static void add(String[] cartItems, List<String> shoppingList) {

        for (String item : cartItems) {
            item.trim();
            if (shoppingList.contains(item)) {
                System.out.println("You already have this in your cart.");
            } else {
                shoppingList.add(item);
            }
        }
    }

    public static void delete(String items, List<String> shoppingList) {
        int itemNo = Integer.parseInt(items) - 1; // -1 to match position in linkedlist
        if (itemNo > shoppingList.size() - 1 || itemNo < 0) {
            System.out.println("Item does not exist in list");
        } else {
            shoppingList.remove(itemNo);
        }
    }

    public static void main(String[] args) {
        List<String> shoppingList = new LinkedList<>();
        System.out.println("Welcome to your shopping cart");
        // Scanner input = new Scanner(System.in);

        // String userInput = input.nextLine();
        Console cons = System.console();
        String input = "";

        while (!input.equals("quit")) {
            input = cons.readLine(">");
            if (input.equals("list")) {
                list(shoppingList);
            }

            if (input.startsWith("add")) {
                String items = input.substring(3);
                String[] cartItems = items.split(",");
                add(cartItems, shoppingList);
            }

            if (input.startsWith("delete")) {
                String items = input.substring(7);
                delete(items,shoppingList);

            }

        }
    }

}
