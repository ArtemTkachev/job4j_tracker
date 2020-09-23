package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("=== Item ID:" + id + " is not found ===");
        }
        return true;
    }
}
