package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== " + this.name() + " ===");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            out.println("=== Item ID:" + id + " was deleted ===");
        } else {
            out.println("=== ID:" + id + " is not found ===");
        }
        return true;
    }
}
