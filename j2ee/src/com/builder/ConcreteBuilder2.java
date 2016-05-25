package com.builder;

class ConcreteBuilder2 implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("part x");
    }

    @Override
    public void buildPartB() {
        product.add("part y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
