package com.partern.bubble;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] numList = {3, 4, 2, 222, 3, 1111, 555, 2};
        int[] sortedList = bubbleSort.sort(numList);
        System.out.println(Arrays.toString(sortedList));
    }

    public int[] sort(int[] numList) {
        int temp;
        for (int i = 0; i < numList.length; i++) {
            for (int j = i; j < numList.length; j++) {
                if (numList[i] > numList[j]) {
                    temp = numList[i];
                    numList[i] = numList[j];
                    numList[j] = temp;
                }
            }
        }
        return numList;
    }
}