package com.strategy;


public class CashierContextTest {
    public static void  main(String[] args){
        CashierContext cs = new CashierContext(CashierType.rebateCashier);
        System.out.println(cs.getPay(400));

        CashierContext cs1 = new CashierContext(CashierType.normalCashier);
        System.out.println(cs1.getPay(400));

        CashierContext cs2= new CashierContext(CashierType.discountCashier);
        System.out.println(cs2.getPay(400));
    }
}
