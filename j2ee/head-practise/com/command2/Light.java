package com.command2;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("light on");
    }

    public void off() {
        System.out.println("light off");
    }
}
