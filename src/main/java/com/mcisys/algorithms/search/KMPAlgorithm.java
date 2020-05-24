package main.java.com.mcisys.algorithms.search;

public class KMPAlgorithm {

    public static void main(String[] args) {
        String str = "aabaaaabaas";
        String match = "aaaa";
        System.out.println(getIndexOf(str, match));
        System.out.println(str.indexOf(match));
    }

    private static int getIndexOf(String str, String match) {
        if (str == null || match == null || match.length() < 1 || str.length() < match.length()) {
            return -1;
        }
        char[] strArr = str.toCharArray();
        char[] matchArr = match.toCharArray();
        int x = 0;  //strArr中当前比对到的位置
        int y = 0;  //matchArr中当前比对到的位置
        int[] nextArr = getNextArr(matchArr);
        while (x < strArr.length && y < matchArr.length) {
            if (strArr[x] == matchArr[y]) {
                x++;
                y++;
            } else if (nextArr[y] == -1) { //y==0
                x++;
            } else {
                y = nextArr[y];
            }
        }
        return y == matchArr.length ? x - y : -1;
    }

    private static int[] getNextArr(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < match.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
