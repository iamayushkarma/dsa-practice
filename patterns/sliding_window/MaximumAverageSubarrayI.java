package patterns.sliding_window;

public class MaximumAverageSubarrayI {
    /*
     * Problem : Maximum Average Subarray I
     * LeetCode : #643
     * Link: https://leetcode.com/problems/maximum-average-subarray-i/
     * Pattern : Sliding Window
     * Difficulty : Easy
     * Date Solved: 16-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was to calculate sum of every subarray of size k,
     * but that would take O(n*k) time which is slow.
     *
     * Optimal Approach:
     * Used sliding window technique.
     * - Calculate sum of first k elements
     * - Then move window forward:
     * add next element and remove previous element
     * - Track maximum sum during the process
     *
     * Pattern Insight:
     * Whenever we need fixed-size subarray (size k),
     * sliding window helps reduce repeated work.
     *
     * Mistake I Made:
     * Initially thought of recalculating sum every time instead of reusing previous
     * sum.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // You are given an integer array nums consisting of n elements, and an integer
    // k. Find a contiguous subarray whose length is equal to k that has the maximum
    // average value and return this value. Any answer with a calculation error less
    // than 10-5 will be accepted.
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 12, -5, -6, 50, 3, 5 };
        int k = 4;
        System.out.println("Max avg subrray is: " + findMaxAverage(arr, k));
    }
}
