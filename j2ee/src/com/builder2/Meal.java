package com.builder2;

import java.util.ArrayList;
import java.util.List;

class Meal {
    private List<Item> items = new ArrayList<Item>();

    void addItem(Item item) {
        items.add(item);
    }

    float getCost() {
        float cost = 0;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }


    void showItems() {
        for (Item item : items)
            System.out.println(item);
    }
}
