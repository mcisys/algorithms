package main.java.com.mcisys.algorithms;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.Arrays;

public class SelectionSort {

    private static void selectionSort(int[] array) {
        if (array == null || array.length < 2) return;
        //0~n-1
        //1~n-1
        //2~n-1
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            if (i != minIndex) {
                swap(array, i, minIndex);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = IntegerArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = IntegerArrayUtils.copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
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
