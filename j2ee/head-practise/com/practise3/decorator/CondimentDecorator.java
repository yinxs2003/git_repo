package com.practise3.decorator;

import com.practise3.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }
}
