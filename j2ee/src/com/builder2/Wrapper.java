package com.builder2;

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper ...";
    }

    @Override
    public String toString() {
        return pack();
    }
}
