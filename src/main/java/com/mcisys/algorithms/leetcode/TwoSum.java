package main.java.com.mcisys.algorithms.leetcode;

import main.java.com.mcisys.algorithms.util.IntegerArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> help = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (help.containsKey(target - nums[i])) {
                return new int[]{help.get(target - nums[i]), i};
            } else {
                help.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = IntegerArrayUtils.generateRandomArray(50, 100);
        int[] result = twoSum(nums, 30);
        if (result != null) {
            IntegerArrayUtils.printArray(nums);
            IntegerArrayUtils.printArray(result);
        } else {
            System.out.println("not match");
        }
    }
}
