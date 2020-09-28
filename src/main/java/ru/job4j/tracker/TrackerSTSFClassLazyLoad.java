package ru.job4j.tracker;

public class TrackerSTSFClassLazyLoad {
    private static final class Holder {
        private static final TrackerSTSFClassLazyLoad INSTANCE = new TrackerSTSFClassLazyLoad();
    }
    private final Tracker tracker = new Tracker();

    private TrackerSTSFClassLazyLoad() {
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSTSFClassLazyLoad getInstance() {
        return Holder.INSTANCE;
    }
}
