package com.simpleFactory.cashier;

public class NormalPayment implements Cashier {

    public NormalPayment() {
    }

    @Override
    public double acceptPay(double money) {
        return money;
    }
}
