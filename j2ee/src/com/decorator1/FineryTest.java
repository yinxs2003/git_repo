package com.decorator1;


public class FineryTest {
    public static void main(String[] args){
        Person person  = new Person("小菜");

        Tie tie = new Tie();
        BigTrousers bt = new BigTrousers();
        TShirts tShirts = new TShirts();

        tie.decorate(person);
        bt.decorate(person);
        tShirts.decorate(person);
        person.show();
    }
}
