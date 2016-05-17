package com.decorator1;

public abstract class ClothesDecorator implements Clothes{
    protected Clothes decoratedCoat;
    public ClothesDecorator(Clothes decoratedCoat){
        this.decoratedCoat = decoratedCoat;
    }

    @Override
    public void dressedUp(){
//       System.out.println("clothes:Coat");
        decoratedCoat.dressedUp();
    }
}
