package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created.format(formatter) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(name, item.name) &&
                Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}