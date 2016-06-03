package com.parttern.strategy;

import com.simpleFactory.cashier.Cashier;
import com.simpleFactory.cashier.DiscountPayment;
import com.simpleFactory.cashier.NormalPayment;
import com.simpleFactory.cashier.RebatePayment;

public class CashierFactory {
    private CashierFactory() {
    }

    public static Cashier getNormalCashier() {
        return new NormalPayment();
    }

    public static Cashier getRebatePayment(double conditionMoney, double returnMoney) {
        return new RebatePayment(conditionMoney, returnMoney);
    }

    public static Cashier getDiscountPayment(double discount) {
        return new DiscountPayment(discount);
    }
}
