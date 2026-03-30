
public interface MaxSubArray {
    /*
     * Problem : Max Sub Array
     * LeetCode : #53
     * Link: https://leetcode.com/problems/maximum-subarray/
     * Pattern : Dynamic Programming (Greedy variant)
     * Difficulty : Medium
     * Date Solved: 26-03-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Kadane's algorithm
     *
     * Optimal Approach:
     * Kadane's algorithm
     *
     * Pattern Insight:
     * Dynamic Programming (Greedy variant)
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    // Given an integer array nums, find the subarray with the largest sum, and
    // return its sum.
    // - Optimal approch
    public static int maxSubArray(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int el : arr) {
            sum += el;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Sum of maximum sub array is: " + maxSubArray(arr));
    }

}
