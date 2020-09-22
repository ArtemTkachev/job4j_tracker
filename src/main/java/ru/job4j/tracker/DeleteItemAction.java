package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Delete the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("=== Item ID:" + id + " was deleted ===");
        } else {
            System.out.println("=== ID:" + id + " is not found ===");
        }
        return true;
    }
}
