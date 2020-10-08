package ru.job4j.tracker;

import java.util.List;

public class ShowAllItemsAction implements UserAction {
    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== " + this.name() + " ===");
        List<Item> items = tracker.findAll();
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item + System.lineSeparator());
        }
        out.println(sb.length() == 0 ? "No items" : sb);
        return true;
    }
}
