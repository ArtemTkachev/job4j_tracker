package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        /*
        Item item = new Item(10, "Sting");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(dateTimeFormatter));
        System.out.println(item);
        */

        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        System.out.println(tracker.findById(3));
        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println(Arrays.toString(tracker.findByName("second")));
        Boolean result = tracker.replace(2, new Item("third2"));
        System.out.println(Arrays.toString(tracker.findAll()));
    }
}
