package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {
    @Test
    public void SortItemByName() {
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        Item fourth = new Item("fourth");
        List<Item> items = Arrays.asList(first, second, third, fourth);
        Collections.sort(items, new SortByItemName());
        assertThat(items,is(Arrays.asList(first, fourth, second, third)));
    }

    @Test
    public void SortItemByNameDesc() {
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        Item fourth = new Item("fourth");
        List<Item> items = Arrays.asList(first, second, third, fourth);
        Collections.sort(items, new SortByNameItemDesc());
        assertThat(items,is(Arrays.asList(third, second, fourth, first)));
    }
}