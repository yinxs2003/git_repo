package com.decorator1;

public class ClothesTest {
    public static void main(String[] args){
        Clothes clothes = new Coat();
        Clothes redCoat = new RedClothesDecorator(clothes);
        clothes.dressedUp();
    }
}
