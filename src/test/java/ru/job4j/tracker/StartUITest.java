package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[]{"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgramAction()
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] userActions = {new ExitProgramAction()};
        new StartUI(out).init(input, tracker, userActions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        String ls = System.lineSeparator();
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        Item fItem = tracker.add(new Item("first"));
        Item sItem = tracker.add(new Item("second"));
        UserAction[] userActions = {new ShowAllItemsAction(out), new ExitProgramAction()};
        new StartUI(out).init(input, tracker, userActions);
        assertThat(out.toString(), is("Menu." + ls +
                "0. Show all items" + ls +
                "1. Exit Program" + ls +
                "=== Show all items ===" + ls +
                fItem + ls +
                sItem + ls + ls +
                "Menu." + ls +
                "0. Show all items" + ls +
                "1. Exit Program" + ls));
    }

    @Test
    public void whenFindByIdAction() {
        String ls = System.lineSeparator();
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1", "1"});
        Tracker tracker = new Tracker();
        Item fItem = tracker.add(new Item("first"));
        Item sItem = tracker.add(new Item("second"));
        UserAction[] userActions = {new FindItemByIdAction(out), new ExitProgramAction()};
        new StartUI(out).init(input, tracker, userActions);
        assertThat(out.toString(), is("Menu." + ls +
                "0. Find item by ID" + ls +
                "1. Exit Program" + ls +
                "=== Find item by ID ===" + ls +
                fItem + ls +
                "Menu." + ls +
                "0. Find item by ID" + ls +
                "1. Exit Program" + ls));
    }

    @Test
    public void whenFindByNameAction() {
        String ls = System.lineSeparator();
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0", "second", "1"});
        Tracker tracker = new Tracker();
        Item fItem = tracker.add(new Item("first"));
        Item sItem = tracker.add(new Item("second"));
        UserAction[] userActions = {new FindItemsByNameAction(out), new ExitProgramAction()};
        new StartUI(out).init(input, tracker, userActions);
        assertThat(out.toString(), is("Menu." + ls +
                "0. Find items by name" + ls +
                "1. Exit Program" + ls +
                "=== Find items by name ===" + ls +
                sItem + ls + ls +
                "Menu." + ls +
                "0. Find items by name" + ls +
                "1. Exit Program" + ls));
    }

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "first", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAction(output), new ExitProgramAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("first"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}