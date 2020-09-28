package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.hamcrest.Matchers.is;

public class TrackerSTEnumEagerLoadTest {

    @Test
    public void whenCreateTrackerThenSingle() {
        TrackerSTEnumEagerLoad trackerFirst = TrackerSTEnumEagerLoad.INSTANCE;
        TrackerSTEnumEagerLoad trackerSecond = TrackerSTEnumEagerLoad.INSTANCE;

        assertSame(trackerFirst, trackerSecond);
    }

}