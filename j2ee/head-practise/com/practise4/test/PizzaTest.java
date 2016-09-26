package com.practise4.test;

import com.practise4.entity.Pizza;
import com.practise4.simple_factory.NYStylePizzaStore;
import com.practise4.simple_factory.PizzaStore;

public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYStylePizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("cheese");

    }
}
