package com.simpleFactory.cashier;

/**
 * 定义收银员接口
 * <p/>
 * Created by yinxuesong on 2016/5/15.
 */
public interface Cashier {
    /**
     * 结账时候收到多少钱
     *
     * @param money 不打折时候应该收的钱
     * @return 返回打折扣后需要收取的钱
     */
    public double acceptPay(double money);
}
