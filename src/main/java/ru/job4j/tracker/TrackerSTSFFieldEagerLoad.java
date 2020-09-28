package ru.job4j.tracker;

public class TrackerSTSFFieldEagerLoad {
    private static final TrackerSTSFFieldEagerLoad INSTANCE = new TrackerSTSFFieldEagerLoad();

    private TrackerSTSFFieldEagerLoad() {
    }

    public static TrackerSTSFFieldEagerLoad getInstance() {
        return INSTANCE;
    }
}
