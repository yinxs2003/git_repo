package com.builder2;

class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke..";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 2;
    }


}
