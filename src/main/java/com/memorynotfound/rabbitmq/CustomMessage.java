package com.memorynotfound.rabbitmq;

public class CustomMessage {

    private int id;
    private String name;

    public CustomMessage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
