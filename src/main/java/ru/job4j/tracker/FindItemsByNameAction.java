package ru.job4j.tracker;

import java.util.List;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== " + this.name() + " ===");
        String name = input.askStr("Enter NAME: ");
        List<Item> items = tracker.findByName(name);
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item + System.lineSeparator());
        }
        out.println(sb.length() == 0 ? "No items with NAME:" + name : sb);
        return true;
    }
}
