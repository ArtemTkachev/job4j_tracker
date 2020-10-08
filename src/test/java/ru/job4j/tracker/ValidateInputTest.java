package ru.job4j.tracker;

import org.junit.Test;


import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput vInput = new ValidateInput(out, input);
        int selected = vInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"5"}
        );
        ValidateInput vInput = new ValidateInput(out, input);
        int selected = vInput.askInt("Enter menu:");
        assertThat(selected, is(5));
    }

    @Test
    public void whenInvalidInputZero0() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"zero", "0"}
        );
        new StartUI(out).init(new ValidateInput(out, input), new Tracker(),
                List.of(new ExitProgramAction()));
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Please enter validate data again.%n"
                )
        ));
    }
}