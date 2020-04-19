package main.java.com.mcisys.algorithms.search;

public class BinarySearch {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return false;
        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1); // mid = (l + r) / 2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sortedArr[l] == num;
    }
}
