package main.java.com.mcisys.algorithms.sort;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = IntegerArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = IntegerArrayUtils.copyArray(arr1);
            quickSort(arr1);
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

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l >= r) return;
        int[] res = netherlandsFlag(arr, l, r);
        process(arr, l, res[0] - 1);
        process(arr, res[1] + 1, r);
    }

    //arr[l...r] 荷兰国旗问题的划分，以arr[r]做划分值
    private static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int i = l;
        while (i < more) {
            if (arr[i] == arr[r]) {
                i++;
            } else if (arr[i] < arr[r]) {
                swap(arr, i++, ++less);
            } else {
                swap(arr, i, --more);
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
