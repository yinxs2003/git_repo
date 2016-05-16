package com.simpleFactory.cashier;

public class PaymentFactoryTest {
    public static void main(String[] args) {
        Cashier normalCashier = PaymentFactory.getNormalPaymentInstance();
        System.out.println(normalCashier.acceptPay(300));

        Cashier discountCashier = PaymentFactory.getDiscountPaymentInstance(0.8);
        System.out.println(discountCashier.acceptPay(300));

        Cashier rebatePayCashier = PaymentFactory.getRebatePaymentInstance(300, 100);
        System.out.println(rebatePayCashier.acceptPay(300));
    }
}
