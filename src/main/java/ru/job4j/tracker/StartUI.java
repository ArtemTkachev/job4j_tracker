package ru.job4j.tracker;

import java.awt.event.ItemEvent;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker, formatter);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemByID(input, tracker, formatter);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker, formatter);
            } else if (select == 6) {
                run = false;
            }
            System.out.println();
        }
    }

    private void showMenu() {
        String ls = System.lineSeparator();
        StringBuilder sb = new StringBuilder("Menu." + ls +
                "0. Add new Item" + ls +
                "1. Show all items" + ls +
                "2. Edit item" + ls +
                "3. Delete item" + ls +
                "4. Find item by Id" + ls +
                "5. Find items by name" + ls +
                "6. Exit Program" + ls);
        System.out.print(sb);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        tracker.add(new Item(name));
        System.out.println("=== Item \"" + name + "\" was created ===");
    }

    public static void showAllItems(Input input, Tracker tracker, DateTimeFormatter formatter) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append("ID:" + item.getId() +
                    " NAME:" + item.getName() +
                    " CREATED:" + item.getCreated().format(formatter));
        }
        System.out.println(sb.length() == 0 ? "No items" : sb);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter NAME: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("=== Item ID:" + id + " was edited with NAME:" + name + " ===");
        } else {
            System.out.println("=== Item ID:" + id + " is not found ===");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete the item ===");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("=== Item ID:" + id + " was deleted ===");
        } else {
            System.out.println("=== ID:" + id + " is not found ===");
        }
    }

    public static void findItemByID(Input input, Tracker tracker, DateTimeFormatter formatter) {
        System.out.println("=== Find item by ID ===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("ID:" + item.getId() +
                    " NAME:" + item.getName() +
                    " CREATED:" + item.getCreated().format(formatter));
        } else {
            System.out.println("=== Item ID:" + id + " is not found ===");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker, DateTimeFormatter formatter) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter NAME: ");
        Item[] items = tracker.findByName(name);
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                sb.append("ID:" + item.getId() +
                        " NAME:" + item.getName() +
                        " CREATED:" + item.getCreated().format(formatter));
            }
        }
        System.out.println(sb.length() == 0 ? "No items with NAME:" + name : sb);
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
