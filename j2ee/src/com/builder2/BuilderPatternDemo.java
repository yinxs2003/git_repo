package com.builder2;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal m1 = mealBuilder.prepareVegMeal();
        m1.showItems();
        System.out.println(m1.getCost());

        Meal m2 = mealBuilder.prepareNonVegMeal();
        m2.showItems();
        System.out.println(m2.getCost());

    }
}
