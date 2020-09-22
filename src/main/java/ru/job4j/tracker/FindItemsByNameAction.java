package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class FindItemsByNameAction implements UserAction{
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("=== " + this.name() + " ===");
        String name = input.askStr("Enter NAME: ");
        Item[] items = tracker.findByName(name);
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                sb.append("ID:" + item.getId() +
                        " NAME:" + item.getName() +
                        " CREATED:" + item.getCreated().format(formatter) + System.lineSeparator());
            }
        }
        System.out.println(sb.length() == 0 ? "No items with NAME:" + name : sb);
        return true;
    }
}
