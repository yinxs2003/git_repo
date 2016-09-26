package com.practise4.entity;

import java.util.ArrayList;

public class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Prepare " + name);
        System.out.println("Add options:");
        for (String s : toppings) {
            System.out.println(s);
        }
    }

    public void bake() {
        System.out.println("bake pizza...");
    }

    public void cut() {
        System.out.println("cut pizza...");
    }

    public void box() {
        System.out.println("box pizza...");
    }
}
