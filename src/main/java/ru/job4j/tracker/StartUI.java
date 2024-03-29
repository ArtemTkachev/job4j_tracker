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
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
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
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAction(output), new ShowAllItemsAction(output), new EditItemAction(output),
                                new DeleteItemAction(output), new FindItemByIdAction(output), new FindItemsByNameAction(output),
                                new ExitProgramAction()};
        new StartUI(output).init(input, tracker, actions);
    }
}
