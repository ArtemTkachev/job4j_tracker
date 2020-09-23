package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction{
    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== " + this.name() + " ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter NAME: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("=== Item ID:" + id + " was edited with NAME:" + name + " ===");
        } else {
            out.println("=== Item ID:" + id + " is not found ===");
        }
        return true;
    }
}
