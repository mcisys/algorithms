package main.java.com.mcisys.algorithms.sort;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 0~n-1：if arr[0]>arr[1] swap, if arr[1]>arr[2] swap ... if arr[n-2]>arr[n-2] swap
     * 0~n-2
     * .
     * .
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) return;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    IntegerArrayUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = IntegerArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = IntegerArrayUtils.copyArray(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!IntegerArrayUtils.isEqual(arr1, arr2)) {
                succeed = false;
                IntegerArrayUtils.printArray(arr1);
                IntegerArrayUtils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "nice" : "fucking fucked");
    }
}
