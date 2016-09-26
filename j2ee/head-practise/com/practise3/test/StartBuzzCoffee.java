package com.practise3.test;


import com.practise3.beverage.Beverage;
import com.practise3.beverage.DarkRoast;
import com.practise3.beverage.Espresso;
import com.practise3.decorator.Mocha;
import com.practise3.decorator.Whip;

public class StartBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription() + " $" + mocha.cost());


        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());


    }
}
