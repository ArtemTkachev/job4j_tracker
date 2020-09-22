package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction{
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter NAME: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("=== Item ID:" + id + " was edited with NAME:" + name + " ===");
        } else {
            System.out.println("=== Item ID:" + id + " is not found ===");
        }
        return true;
    }
}
