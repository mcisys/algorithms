package main.java.com.mcisys.algorithms.sort;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.Arrays;

public class InsertionSort {

    /**
     * 0~0 有序 0~1有序 0~2有序 。。。
     * if arr[i]<arr[i-1] swap
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) return;
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j + 1] < array[j]; j--) {
                IntegerArrayUtils.swap(array, j + 1, j);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = IntegerArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = IntegerArrayUtils.copyArray(arr1);
            insertionSort(arr1);
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
