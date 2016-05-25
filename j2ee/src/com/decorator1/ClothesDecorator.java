package com.decorator1;

abstract class ClothesDecorator implements Clothes {
    protected Clothes decoratedCoat;

    ClothesDecorator(Clothes decoratedCoat) {
        this.decoratedCoat = decoratedCoat;
    }

    @Override
    public void dressedUp(){
//       System.out.println("clothes:Coat");
        decoratedCoat.dressedUp();
    }
}
