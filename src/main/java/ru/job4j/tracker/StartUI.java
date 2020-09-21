package ru.job4j.tracker;

import java.awt.event.ItemEvent;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String ls = System.lineSeparator();
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                tracker.add(new Item(name));
                System.out.println("=== Item \"" + name + "\" was created ===" + ls);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                StringBuilder sb = new StringBuilder();
                for (Item item : items) {
                    sb.append("ID:" + item.getId() +
                            " NAME:" + item.getName() +
                            " CREATED:" + item.getCreated().format(formatter) + ls);
                }
                System.out.println(sb.length() == 0 ? "No items" + ls : sb);
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = input.askInt("Enter ID: ");
                String name = input.askStr("Enter NAME: ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("=== Item ID:" + id + " was edited with NAME:" + name + " ===" + ls);
                } else {
                    System.out.println("=== Item ID:" + id + " is not found ===" + ls);
                }
            } else if (select == 3) {
                System.out.println("=== Delete the item ===");
                int id = input.askInt("Enter ID: ");
                if (tracker.delete(id)) {
                    System.out.println("=== Item ID:" + id + " was deleted ===" + ls);
                } else {
                    System.out.println("=== ID:" + id + " is not found ===" + ls);
                }
            } else if (select == 4) {
                System.out.println("=== Find item by ID ===");
                int id = input.askInt("Enter ID: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("ID:" + item.getId() +
                            " NAME:" + item.getName() +
                            " CREATED:" + item.getCreated().format(formatter) + ls);
                } else {
                    System.out.println("=== Item ID:" + id + " is not found ===" + ls);
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                String name = input.askStr("Enter NAME: ");
                Item[] items = tracker.findByName(name);
                StringBuilder sb = new StringBuilder();
                for (Item item : items) {
                    if (item.getName().equals(name)) {
                        sb.append("ID:" + item.getId() +
                                " NAME:" + item.getName() +
                                " CREATED:" + item.getCreated().format(formatter) + ls);
                    }
                }
                System.out.println(sb.length() == 0 ? "No items with NAME:" + name + ls : sb);
            } else if (select == 6) {
                run = false;
            }
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

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
