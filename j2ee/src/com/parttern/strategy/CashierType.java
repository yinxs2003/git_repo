package com.parttern.strategy;


import com.simpleFactory.cashier.Cashier;

public enum CashierType {
    normalCashier,
    rebateCashier,
    discountCashier;
    private Cashier cs = null;

    public double getPay(double money) {
        return cs.acceptPay(money);
    }
}
