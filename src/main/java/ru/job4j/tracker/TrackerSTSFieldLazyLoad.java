package ru.job4j.tracker;

public class TrackerSTSFieldLazyLoad {
    private static TrackerSTSFieldLazyLoad instance;

    private TrackerSTSFieldLazyLoad() {
    }

    public static TrackerSTSFieldLazyLoad getInstance() {
        if(instance == null) {
            instance = new TrackerSTSFieldLazyLoad();
        }
        return instance;
    }

}
