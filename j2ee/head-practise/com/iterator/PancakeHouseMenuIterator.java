package com.iterator;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {
    List<MenuItem> items;
    int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }
}
