package com.partern.insert;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {3, 44, 38, 2, 5, 33, 222, 13, 123, 555};
        InsertSort selectSort = new InsertSort();
        int[] sortedNums = selectSort.sort(numbers);
        System.out.println(Arrays.toString(sortedNums));
    }

    private int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sortedElement = numbers[i];
                int extractElement = numbers[j];
                if (sortedElement > extractElement) {

                } else {

                }
            }
        }
        return numbers;
    }
}
