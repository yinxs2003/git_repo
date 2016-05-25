package com.builder;

class Director {
    void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
