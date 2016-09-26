package com.my_menu_component;


public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void del(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public String getName(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public double getPrice(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
