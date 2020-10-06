package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.TrackerSTSFFieldEagerLoad;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.hamcrest.Matchers.is;

public class TrackerSTSFFieldEagerLoadTest {

    @Test
    public void whenCreateTrackerThenSingle() {
        TrackerSTSFFieldEagerLoad trackerFirst = TrackerSTSFFieldEagerLoad.getInstance();
        TrackerSTSFFieldEagerLoad trackerSecond = TrackerSTSFFieldEagerLoad.getInstance();

        assertSame(trackerFirst, trackerSecond);
    }
}