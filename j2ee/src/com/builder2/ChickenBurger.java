package com.builder2;

class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger..";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 10;
    }
}
