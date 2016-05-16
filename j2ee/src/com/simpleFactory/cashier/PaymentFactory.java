package com.simpleFactory.cashier;


public class PaymentFactory {
    public static Cashier getNormalPaymentInstance() {
        return new NormalPayment();
    }

    public static Cashier getDiscountPaymentInstance(double discount) {
        return new DiscountPayment(discount);
    }

    public static Cashier getRebatePaymentInstance(double conditionMoney, double returnMoney) {
        return new RebatePayment(conditionMoney, returnMoney);
    }
}
