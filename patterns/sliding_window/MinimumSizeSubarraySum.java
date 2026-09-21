package patterns.sliding_window;

public class MinimumSizeSubarraySum {

    /**
     * Problem : Minimum Size Subarray Sum
     * LeetCode : #209
     * Link:
     * https://leetcode.com/problems/minimum-size-subarray-sum/
     * Pattern : Variable Size Sliding Window / Shrinking Window
     * Difficulty : Medium
     * Date Solved: 21-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used a variable-size sliding window.
     * - ws represents the start of the window
     * - we represents the end of the window
     * - sum stores the sum of elements inside the current window
     * - Expand the window by moving we forward
     * - Whenever sum >= target, shrink the window from the left
     * - During shrinking, update the minimum window length
     * - Continue until the window sum becomes smaller than target
     *
     * Why It Works:
     *
     * Since all numbers in nums are positive, expanding the window
     * increases the sum and shrinking the window decreases the sum.
     *
     * Therefore, whenever the current window has sum >= target,
     * we can safely try removing elements from the left to find
     * the smallest possible valid window ending at we.
     *
     * Pattern Insight:
     *
     * This is a variable-size sliding window problem.
     *
     * Unlike a fixed-size window, the window size changes depending
     * on whether the current sum satisfies the condition.
     *
     * General pattern:
     *
     * 1. Expand the window
     * 2. Check whether the condition is satisfied
     * 3. While the condition remains satisfied:
     * - Update the answer
     * - Shrink the window
     *
     * Mistake I Made:
     * - Initially considered sorting the array, but sorting destroys
     * the original subarray order and is not valid for this problem.
     * - Needed to keep shrinking while sum >= target instead of
     * shrinking only once.
     * - Needed to return 0 when no valid subarray exists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Each element is added to the window once and removed from
     * the window at most once.
     */

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int sum = 0;
        int res = Integer.MAX_VALUE;

        int ws = 0;
        int we = 0;

        while (we < n) {

            // Expand the window
            sum += nums[we];

            // Shrink the window while it is valid
            if (sum >= target) {

                while (sum >= target) {

                    res = Math.min(res, we - ws + 1);

                    sum -= nums[ws];
                    ws++;
                }
            }

            we++;
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
    }

    public static void main(String[] args) {

        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };

        System.out.println(minSubArrayLen(target, nums));
    }
}