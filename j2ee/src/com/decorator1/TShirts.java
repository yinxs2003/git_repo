package com.decorator1;

/**
 * 服装类Thirts
 */


class TShirts extends Finery{
    @Override
    public void show(){
        System.out.println("大T恤");
        super.show();
    }
}

class BigTrousers extends Finery{
    @Override
    public void show(){
        System.out.println("大短裤");
        super.show();
    }
}

class Tie extends  Finery{
    @Override
    public void show(){
        System.out.println("花领带");
        super.show();
    }
}