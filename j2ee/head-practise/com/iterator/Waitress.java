package com.iterator;

import java.util.Iterator;
import java.util.List;

public class Waitress {
    List<Menu> menuList;

    public Waitress(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void printMenu() {
        for (Menu menu : menuList) {
            printMenu(menu.createIterator());
        }
    }

    public void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
