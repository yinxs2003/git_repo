package com.iterator;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
        return !(position >= items.length || items[position] == null);
    }
}
