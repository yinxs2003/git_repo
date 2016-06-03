package com.parttern.strategy;

import com.simpleFactory.cashier.Cashier;
import com.simpleFactory.cashier.DiscountPayment;
import com.simpleFactory.cashier.NormalPayment;
import com.simpleFactory.cashier.RebatePayment;


public class CashierContext {
    private Cashier cs = null;
//    private CashierType type;

    CashierContext(CashierType type) {
        switch (type) {//这里可以用多太
            case normalCashier:
                cs = new NormalPayment();
                break;
            case rebateCashier:
                cs = new RebatePayment(300, 100);
                break;
            case discountCashier:
                cs = new DiscountPayment(0.8);
                break;
        }
    }

    public double getPay(double money){
        return cs.acceptPay(money);
    }
}
