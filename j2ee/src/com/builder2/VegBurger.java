package com.builder2;

class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger...";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 5;
    }
}
