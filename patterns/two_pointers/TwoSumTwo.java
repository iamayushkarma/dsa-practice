package patterns.two_pointers;

import java.util.Arrays;

public class TwoSumTwo {
    /*
     * Problem : Two Sum II
     * LeetCode : #167
     * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
     * Pattern : Two Pointers
     * Difficulty : Medium
     * Date Solved: 29-03-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Optimal Approach:
     * Take two pointers i and j, place i at start of array and j at end the
     * calculate their sum if the sum is smaller them targer move i forward and if
     * the sum is greater then traget move j towords start of array and at any point
     * sum = target return i+1 and j+1 as question says its a 1 based index
     *
     * Pattern Insight:
     * Two Pointers
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    // You are given a sorted (non-decreasing) 1-indexed array of integers and a
    // target value. Your task is to find two different elements such that their sum
    // equals the target and return their indices as a pair [index1, index2], where
    // index1 < index2. Each index should follow 1-based indexing. You cannot use
    // the same element twice, and it is guaranteed that exactly one valid pair
    // exists. The solution must use constant extra space.

    public static int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum > target)
                j--;
            else if (sum < target)
                i++;
            else
                return new int[] { i + 1, j + 1 };
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println("Elements matches to target after sum are: " + Arrays.toString(twoSum(arr, target)));
    }
}
