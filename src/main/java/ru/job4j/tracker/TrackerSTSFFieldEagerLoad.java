package ru.job4j.tracker;

public class TrackerSTSFFieldEagerLoad {
    private static final TrackerSTSFFieldEagerLoad INSTANCE = new TrackerSTSFFieldEagerLoad();
    private final Tracker tracker = new Tracker();

    private TrackerSTSFFieldEagerLoad() {
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSTSFFieldEagerLoad getInstance() {
        return INSTANCE;
    }
}
