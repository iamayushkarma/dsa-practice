package patterns.prefix_sum;

public class MinimumValueToGetPositiveStepByStepSum {

    /**
     * Problem : Minimum Value to Get Positive Step by Step Sum
     * LeetCode : #1413
     * Link:
     * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
     * Pattern : Prefix Sum
     * Difficulty : Easy
     * Date Solved: 05-Oct-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     *
     * First calculate the prefix sum of the array.
     *
     * Find the minimum prefix sum because the starting value
     * must be large enough to keep every step positive.
     *
     * If the minimum prefix sum is negative, increase the
     * starting value until the minimum sum becomes at least 1.
     *
     * Optimal Approach:
     *
     * Use a prefix sum array to store the running sum.
     *
     * Track the minimum prefix sum while calculating the prefix sum.
     *
     * The starting value is increased until the minimum prefix
     * sum becomes positive.
     *
     * Pattern Insight:
     *
     * When a problem requires keeping a running sum above a
     * certain minimum value, prefix sum can be used to find
     * the lowest point of the running sum.
     *
     * Mistake I Made:
     *
     * None.
     *
     * Time Complexity:
     *
     * O(n)
     *
     * Space Complexity:
     *
     * O(n)
     */

    public static int minStartValue(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];

        int count = 1;
        int min = arr[0];

        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
            min = Math.min(min, arr[i]);
        }

        while (min < 0) {
            min++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                minStartValue(new int[] { -3, 2, -3, 4, 2 })); // 5

        System.out.println(
                minStartValue(new int[] { 1, 2 })); // 1
    }
}