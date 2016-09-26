package com.adapter;

public class DuckTest {
    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();

        WildTurkey w = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(w);

        testDuck(d);
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck) {
        duck.fly();
        duck.quack();
    }
}
