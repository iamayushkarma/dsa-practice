package patterns.prefix_sum;

public class FindPivotIndex {

    /**
     * Problem : Find Pivot Index
     * LeetCode : #724
     * Link: https://leetcode.com/problems/find-pivot-index/
     * Pattern : Prefix Sum
     * Difficulty : Easy
     * Date Solved: 29-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * 
     * First calculate the prefix sum from the left.
     * Then calculate the suffix sum from the right.
     *
     * At every index, compare the sum of elements on the left
     * with the sum of elements on the right.
     *
     * If both sums are equal, that index is the pivot index.
     *
     * The pivot element itself is not included in either sum.
     *
     * Optimal Approach:
     *
     * Use two arrays:
     *
     * prefix[i] -> sum from index 0 to i
     * suffix[i] -> sum from index i to n - 1
     *
     * For every index i:
     *
     * leftSum = prefix[i - 1]
     * rightSum = suffix[i + 1]
     *
     * Handle the first and last index separately because
     * there are no elements on one side.
     *
     * If leftSum == rightSum, return i.
     *
     * Pattern Insight:
     *
     * When a problem asks for equal sum on both sides of an index,
     * prefix sum and suffix sum can be used.
     *
     * Mistake I Made:
     *
     * Tried to store prefix sum and suffix sum in the same array.
     *
     * This overwrote prefix values that were still needed.
     *
     * Time Complexity:
     *
     * O(n)
     *
     * Space Complexity:
     *
     * O(n)
     */

    public static int pivotIndex(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        suffix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {

            int leftSum = (i == 0) ? 0 : prefix[i - 1];

            int rightSum = (i == n - 1) ? 0 : suffix[i + 1];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 })); // 3

        System.out.println(
                pivotIndex(new int[] { 1, 2, 3 })); // -1

        System.out.println(
                pivotIndex(new int[] { 2, 1, -1 })); // 0
    }
}