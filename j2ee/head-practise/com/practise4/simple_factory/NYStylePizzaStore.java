package com.practise4.simple_factory;

import com.practise4.entity.*;

public class NYStylePizzaStore extends PizzaStore {
    Pizza pizza = null;

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
