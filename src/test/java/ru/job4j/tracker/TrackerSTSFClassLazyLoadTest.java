package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.TrackerSTSFClassLazyLoad;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.hamcrest.Matchers.is;

public class TrackerSTSFClassLazyLoadTest {

    @Test
    public void whenCreateTrackerThenSingle() {
        TrackerSTSFClassLazyLoad trackerFirst = TrackerSTSFClassLazyLoad.getInstance();
        TrackerSTSFClassLazyLoad trackerSecond = TrackerSTSFClassLazyLoad.getInstance();

        assertSame(trackerFirst, trackerSecond);
    }
}