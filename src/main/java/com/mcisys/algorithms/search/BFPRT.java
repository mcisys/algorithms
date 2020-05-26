package main.java.com.mcisys.algorithms.search;

/**
 * 在一个无序数组中，找到第k小的数
 * 1、用大根堆来做，时间复杂度O(logk)
 * 2、改写快排，时间复杂度O(N)
 * 3、bfprt，时间复杂度O(N)
 */
public class BFPRT {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 22, 35, 7, -32, -1, 18, 56, -45};
        System.out.println(minKth(arr, 3));
    }

    private static int minKth(int[] arr, int k) {
        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    //在arr数组的L...R上，如果排序的话，位于k位置上的数，k必须是在L...R中间
    private static int bfprt(int[] arr, int L, int R, int k) {
        if (L == R) return arr[L];
        int pivot = medianOfMedians(arr, L, R); //改写快排的话，pivot为数组中随机一个数
        int[] res = partition(arr, L, R, pivot);
        if (k >= res[0] && k <= res[1]) {
            return arr[k];
        }
        if (res[0] > k) {
            return bfprt(arr, L, res[0] - 1, k);
        } else {
            return bfprt(arr, res[1] + 1, R, k);
        }
    }

    //arr[L..R] 五个数一组
    //每个小组内部排序
    //每个小组中位数取出，组成marr
    //marr中的中位数，返回
    private static int medianOfMedians(int[] arr, int L, int R) {
        int size = R - L + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mArr = new int[size / 5 + offset];
        for (int team = 0; team < mArr.length; team++) {
            int teamFirst = L + team * 5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(R, teamFirst + 4));
        }
        //在mArr中找到中位数
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int L, int R) {
        insertionSort(arr, L, R);
        return arr[(L + R) / 2];
    }

    private static void insertionSort(int[] arr, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            for (int j = i - 1; j >= L && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static int[] partition(int[] arr, int L, int R, int num) {
        if (L > R) return new int[]{-1, -1};
        if (L == R) return new int[]{L, R};
        int less = L - 1;
        int more = R + 1;
        int inx = L;
        while (inx < more) {
            if (arr[inx] == num) {
                inx++;
            } else if (arr[inx] > num) {
                swap(arr, inx, --more);
            } else {
                swap(arr, inx++, ++less);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
