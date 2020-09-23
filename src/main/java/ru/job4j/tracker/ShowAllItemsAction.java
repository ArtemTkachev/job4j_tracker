package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class ShowAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        Item[] items = tracker.findAll();
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item + System.lineSeparator());
        }
        System.out.println(sb.length() == 0 ? "No items" : sb);
        return true;
    }
}
