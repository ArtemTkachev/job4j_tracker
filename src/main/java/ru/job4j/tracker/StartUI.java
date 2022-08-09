package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            run = actions[select].execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAction(), new ShowAllItemsAction(), new EditItemAction(),
                                new DeleteItemAction(), new FindItemByIdAction(), new FindItemsByNameAction(),
                                new ExitProgramAction()};
        new StartUI().init(input, tracker, actions);
    }
}
