package com.builder;

import java.util.ArrayList;
import java.util.List;

class Product {
    private List<String> parts = new ArrayList<String>();

    void add(String part) {
        parts.add(part);
    }

    void show() {
        System.out.println("create product");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
