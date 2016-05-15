package com.simpleFactory.cashier;

public class NormalPayment implements Cashier {

    private double result;

    public NormalPayment(double money) {
        this.result = money;
    }

    @Override
    public double acceptPay(double money) {
        return result;
    }
}
