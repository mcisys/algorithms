package main.java.com.mcisys.algorithms.util;

public class IntegerArrayUtils {

    public static void printArray(int[] array) {
        if (array == null) return;
        for (int o : array) {
            System.out.println(o + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) return true;
        if (array1 == null || array2 == null) return false;
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static int[] copyArray(int[] array) {
        if (array == null) return null;
        int[] res = new int[array.length];
        System.arraycopy(array, 0, res, 0, array.length);
        return res;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
