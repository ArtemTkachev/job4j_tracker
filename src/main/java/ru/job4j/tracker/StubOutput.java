package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void println(Object object) {
        if (object != null) {
            sb.append(object.toString());
        } else {
            sb.append("null");
        }
        sb.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
