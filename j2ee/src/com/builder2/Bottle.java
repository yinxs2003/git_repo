package com.builder2;

class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle ...";
    }

    @Override
    public String toString() {
        return pack();
    }
}
