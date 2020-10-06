package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.TrackerSTSFieldLazyLoad;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.hamcrest.Matchers.is;

public class TrackerSTSFieldLazyLoadTest {

    @Test
    public void whenCreateTrackerThenSingle() {
        TrackerSTSFieldLazyLoad trackerFirst = TrackerSTSFieldLazyLoad.getInstance();
        TrackerSTSFieldLazyLoad trackerSecond = TrackerSTSFieldLazyLoad.getInstance();

        assertSame(trackerFirst, trackerSecond);
    }
}