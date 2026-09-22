package patterns.sliding_window;

public class MaxConsecutiveOnesIII {

    /**
     * Problem : Max Consecutive Ones III
     * LeetCode : #1004
     * Link:
     * https://leetcode.com/problems/max-consecutive-ones-iii/
     * Pattern : Sliding Window
     * Difficulty : Medium
     * Date Solved: 22-Sep-2026
     * Revision : [] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used sliding window with a count of zeros.
     * - Expand window using we
     * - Count the number of zeros inside the window
     * - If zeros become greater than k,
     * shrink window from ws until zeros are <= k
     * - Track maximum window size during the process
     *
     * Why It Works:
     * We are allowed to flip at most k zeros into ones.
     * Therefore, a valid window can contain at most k zeros.
     *
     * The sliding window maintains a valid range where
     * the number of zeros is always <= k.
     *
     * Pattern Insight:
     * This is a variable size sliding window problem.
     *
     * Key idea: maintain a window containing at most k zeros.
     *
     * When the number of zeros becomes greater than k,
     * shrink the window from the left until it becomes valid again.
     *
     * Mistake I Made:
     * - Incremented ws before checking nums[ws].
     * - This caused the wrong element to be removed from the window.
     * - Updated the window size in multiple places unnecessarily.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a binary array nums and an integer k, find the maximum number
    // of consecutive 1s in the array if you can flip at most k 0s.

    public static int longestOnes(int[] nums, int k) {

        int max_ones = 0;
        int ws = 0;
        int zeroUsed = 0;

        for (int we = 0; we < nums.length; we++) {

            // Expand window
            if (nums[we] == 0) {
                zeroUsed++;
            }

            // Shrink window if more than k zeros are present
            while (zeroUsed > k) {

                if (nums[ws] == 0) {
                    zeroUsed--;
                }

                ws++;
            }

            // Update maximum valid window size
            max_ones = Math.max(max_ones, we - ws + 1);
        }

        return max_ones;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };

        int k = 2;

        System.out.println(
                "Maximum consecutive ones: " + longestOnes(arr, k));
    }
}