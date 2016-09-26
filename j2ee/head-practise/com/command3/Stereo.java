package com.command3;

public class Stereo {
    String name;
    private int volume;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Stereo is on");
    }

    public void off() {
        System.out.println("Stereo is off");
    }

    public void setCD() {
        System.out.println("Stereo set cd ");
    }

    public void setDVD() {
        System.out.println("Stereo set dvd ");
    }

    public void setRadio() {
        System.out.println("Stereo set radio");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
