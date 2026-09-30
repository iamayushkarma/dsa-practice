package patterns.prefix_sum;

public class WaysToSplitArray {

    /**
     * Problem : Ways to Split Array
     * LeetCode : #2270
     * Link: https://leetcode.com/problems/number-of-ways-to-split-array/
     * Pattern : Prefix Sum
     * Difficulty : Medium
     * Date Solved: 30-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     *
     * First calculate the prefix sum of the array.
     *
     * For every possible split, the left sum is the prefix sum
     * up to the current index.
     *
     * The right sum can be calculated by subtracting the left sum
     * from the total sum.
     *
     * If the left sum is greater than or equal to the right sum,
     * the split is valid.
     *
     * The split cannot be made after the last element because
     * the right side must contain at least one element.
     *
     * Optimal Approach:
     *
     * Use a prefix sum array to store the sum from index 0 to i.
     *
     * For every index i:
     *
     * leftSum = prefix_sum[i]
     *
     * rightSum = prefix_sum[n - 1] - prefix_sum[i]
     *
     * If leftSum >= rightSum, increment the answer.
     *
     * Use long for prefix sums because the total sum can exceed
     * the range of int.
     *
     * Pattern Insight:
     *
     * When a problem requires comparing the sum of the left and
     * right parts of an array for multiple split positions,
     * prefix sum can calculate both sides efficiently.
     *
     * Mistake I Made:
     *
     * Used int for the prefix sum array.
     *
     * The total sum can exceed the range of int, causing integer
     * overflow.
     *
     * Time Complexity:
     *
     * O(n)
     *
     * Space Complexity:
     *
     * O(n)
     */
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix_sum = new long[n];
        int totalSplit = 0;

        prefix_sum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            long rightPrefixSum = prefix_sum[n - 1] - prefix_sum[i];

            if (prefix_sum[i] >= rightPrefixSum) {
                totalSplit++;
            }
        }

        return totalSplit;
    }

    public static void main(String[] args) {
        System.out.println(
                waysToSplitArray(new int[] { 10, 4, -8, 7 })); // 2

        System.out.println(
                waysToSplitArray(new int[] { 2, 3, 1, 0 })); // 2
    }
}