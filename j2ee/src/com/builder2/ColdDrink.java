package com.builder2;

abstract class ColdDrink implements Item {
    @Override
    public String toString() {
        return name() + " " + packing() + " " + price();
    }
}
