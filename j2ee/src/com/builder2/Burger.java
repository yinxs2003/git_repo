package com.builder2;

abstract class Burger implements Item {
    @Override
    public String toString() {
        return name() + " " + packing() + " " + price();
    }
}










