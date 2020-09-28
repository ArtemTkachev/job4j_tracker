package ru.job4j.tracker;

public enum TrackerSTEnumEagerLoad {
    INSTANCE;
    private final Tracker tracker = new Tracker();

    TrackerSTEnumEagerLoad() {
    }

    public Tracker getTracker() {
        return tracker;
    }

}
