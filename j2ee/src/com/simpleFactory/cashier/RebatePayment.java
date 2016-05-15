package com.simpleFactory.cashier;

/**
 * 返利，比如满300，送100，你需要支付的金额为200
 * <p/>
 * Created by yinxuesong on 2016/5/15.
 */
public class RebatePayment implements Cashier {
    private double conditionMoney;
    private double returnMoney;
    private double result;

    public RebatePayment(double conditionMoney, double returnMoney) {
        this.conditionMoney = conditionMoney;
        this.returnMoney = returnMoney;
    }

    @Override
    public double acceptPay(double money) {
        if (money >= conditionMoney) {
            result = money - returnMoney;
        }
        return result;
    }
}
