package ru.job4j.tracker;

public class CreateItemAction implements UserAction {
    private final Output out;

    public CreateItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Added item: " + item);
        return true;
    }
}
