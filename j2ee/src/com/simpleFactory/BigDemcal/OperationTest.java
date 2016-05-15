package com.simpleFactory.BigDemcal;

public class OperationTest {
    public static void main(String[] args) {
        System.out.println(OperationFactory.getMinusOperation(1,2));
        System.out.println(OperationFactory.getMultiOperation(2.3, 3));
        System.out.println(OperationFactory.getDivideOperation(5, 10));
        System.out.println(OperationFactory.getMultiOperation(2.7, 3));
    }
}
