package com.simpleFactory.BigDemcal;

import java.math.BigDecimal;
import java.math.MathContext;


public class OperationFactory {
    public static double getPlusOperation(double a, double b) {
        BigDecimal v1 = new BigDecimal(a);
        BigDecimal v2 = new BigDecimal(b);
        return v1.add(v2).doubleValue();
    }

    public static double getMinusOperation(double a, double b) {
        BigDecimal v1 = new BigDecimal(a, new MathContext(2));
        BigDecimal v2 = new BigDecimal(b, new MathContext(2));
        return v1.subtract(v2).doubleValue();
    }

    public static double getMultiOperation(double a, double b) {
        BigDecimal v1 = new BigDecimal(a, new MathContext(2));
        BigDecimal v2 = new BigDecimal(b, new MathContext(2));
        return v1.multiply(v2).doubleValue();
    }

    public static double getDivideOperation(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("divide can't be zero!");
        }
        BigDecimal v1 = new BigDecimal(a, new MathContext(4));
        BigDecimal v2 = new BigDecimal(b, new MathContext(4));
        return v1.divide(v2, 4, 1).doubleValue();
    }
}
