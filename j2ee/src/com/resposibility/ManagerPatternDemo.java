package com.resposibility;

public class ManagerPatternDemo {

    public static void main(String[] args) {
        int count = 4;
        int sum = getSum(count);
        System.out.println(sum);
    }

    private static int getSum(int count) {
        int temp = 1;
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            temp *= i;
            sum += temp;
        }

        return sum;
    }
}
