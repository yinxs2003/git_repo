package com.partern.select;

import java.util.Arrays;

/**
 * 选取最小的
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = {3, 44, 38, 2, 5, 33, 222, 13, 123, 555};
        SelectSort selectSort = new SelectSort();
        int[] sortedNums = selectSort.sort(numbers);
        System.out.println(Arrays.toString(sortedNums));
    }

    private int[] sort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
        return numbers;
    }
}
