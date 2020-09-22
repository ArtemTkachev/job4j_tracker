package ru.job4j.tracker;

public class CreateItemAction implements UserAction {
    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        String name = input.askStr("Enter name: ");
        tracker.add(new Item(name));
        System.out.println("=== Item \"" + name + "\" was created ===");
        return true;
    }
}
