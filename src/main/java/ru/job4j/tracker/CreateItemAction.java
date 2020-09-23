package ru.job4j.tracker;

public class CreateItemAction implements UserAction {
    private final Output out;

    public CreateItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== " + this.name() + " ===");
        String name = input.askStr("Enter name: ");
        tracker.add(new Item(name));
        out.println("=== Item \"" + name + "\" was created ===");
        return true;
    }
}
