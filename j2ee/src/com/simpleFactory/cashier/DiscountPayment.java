package com.simpleFactory.cashier;

public class DiscountPayment implements Cashier {
    private double discount;

    public DiscountPayment(double discount) {

        if (discount < 0 && discount > 1) {
            throw new IllegalArgumentException("discount is between 0 and 1 !!");
        }
        this.discount = discount;
    }

    @Override
    public double acceptPay(double money) {
        return money * discount;
    }
}
