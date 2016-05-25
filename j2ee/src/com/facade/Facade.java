package com.facade;

class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    void methodA() {
        System.out.println("Method A ------");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    void methodB() {
        System.out.println("Method B -------");
        two.methodTwo();
        three.methodThree();
    }
}
