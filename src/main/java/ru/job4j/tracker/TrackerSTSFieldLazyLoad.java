package ru.job4j.tracker;

public class TrackerSTSFieldLazyLoad {
    private static TrackerSTSFieldLazyLoad instance;
    private final Tracker tracker = new Tracker();

    private TrackerSTSFieldLazyLoad() {
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSTSFieldLazyLoad getInstance() {
        if(instance == null) {
            instance = new TrackerSTSFieldLazyLoad();
        }
        return instance;
    }

}
