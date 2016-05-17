package com.decorator1;

public abstract class CoatDecorator implements Clothes{
    protected Clothes decoratedCoat;
    public CoatDecorator(Clothes decoratedCoat){
        this.decoratedCoat = decoratedCoat;
    }

    @Override
    public void dressedUp(){
       System.out.println("clothes:Coat");
    }
}
