package test.java.com.mcisys.algorithms;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

public class MyTest {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 3};
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
        IntegerArrayUtils.printArray(array);
    }
}
