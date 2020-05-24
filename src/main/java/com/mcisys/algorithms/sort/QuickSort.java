package main.java.com.mcisys.algorithms.sort;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.Arrays;
import java.util.Random;

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

    private static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        //随机从arr中取一个数作为划分值，时间复杂度能收敛到O(N*logN)
        int[] res = partition(arr, L, R, arr[L + new Random().nextInt(R - L + 1)]);
        process(arr, L, res[0] - 1);
        process(arr, res[1] + 1, R);
    }

    //在arr[L...R]范围上，以num做划分进行partition，将arr分成三个区域，小于num区，等于num区，大于num区
    private static int[] partition(int[] arr, int L, int R, int num) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (index < more) {
            if (arr[index] == num) {
                index++;
            } else if (arr[index] < num) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
