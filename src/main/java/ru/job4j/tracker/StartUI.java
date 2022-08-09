package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            run = actions[select].execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAction(output), new ShowAllItemsAction(output), new EditItemAction(output),
                                new DeleteItemAction(output), new FindItemByIdAction(output), new FindItemsByNameAction(output),
                                new ExitProgramAction()};
        new StartUI(output).init(input, tracker, actions);
    }
}
