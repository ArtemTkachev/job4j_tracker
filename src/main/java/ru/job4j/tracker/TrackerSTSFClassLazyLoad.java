package ru.job4j.tracker;

public class TrackerSTSFClassLazyLoad {
    private static final class Holder {
        private static final TrackerSTSFClassLazyLoad INSTANCE = new TrackerSTSFClassLazyLoad();
    }

    private TrackerSTSFClassLazyLoad() {
    }

    public static TrackerSTSFClassLazyLoad getInstance() {
        return Holder.INSTANCE;
    }
}
