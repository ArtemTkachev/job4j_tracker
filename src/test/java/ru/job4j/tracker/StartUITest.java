package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenCreateItem() { ;
        Input input = new StubInput(new String[]{"0", "first", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAction(), new ExitProgramAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("first"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input= new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(),
                new ExitProgramAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new StubInput(
                new String[] {"0", String.valueOf(item.getId()) , "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitProgramAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }



}