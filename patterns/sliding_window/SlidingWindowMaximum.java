package patterns.sliding_window;

import java.util.*;

public class SlidingWindowMaximum {
    // TODO -> Need to be optimise
    /**
     * Problem : Sliding Window Maximum
     * LeetCode : #239
     * Link:
     * https://leetcode.com/problems/sliding-window-maximum/
     * Pattern : Sliding Window
     * Difficulty : Hard
     * Date Solved: 23-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used a fixed size sliding window.
     * - Start the window with ws = 0 and we = k - 1
     * - Find the maximum element inside the current window
     * - Store the maximum in an ArrayList
     * - Move both ws and we one position forward
     * - Convert the List<Integer> into int[] at the end
     *
     * Why It Works:
     * The window always contains exactly k elements.
     *
     * For every possible window, iterate through all k elements
     * and find the maximum value.
     *
     * After calculating the maximum, move the window one position
     * forward and repeat the same process.
     *
     * Pattern Insight:
     * This is a fixed size sliding window problem.
     *
     * Key idea: maintain a window of exactly k elements and
     * calculate the maximum value inside every window.
     *
     * The window moves one position at a time:
     *
     * [1, 3, -1] 3
     * [3, -1, -3] 3
     * [-1, -3, 5] 5
     *
     * Mistake I Made:
     * - Initially used the wrong starting index while finding max.
     * - The maximum should be searched from ws to we,
     * not from index 0 to we.
     * - Need to move both ws and we after processing each window.
     * - The result is stored in List<Integer>, so it needs to be
     * converted into int[] before returning.
     *
     * Time Complexity: O(n * k)
     * Space Complexity: O(n)
     */

    // Given an integer array nums and an integer k, find the maximum
    // value in each sliding window of size k.

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int ws = 0;
        int we = k - 1;

        List<Integer> list = new ArrayList<>();

        while (we < n) {

            int max = Integer.MIN_VALUE;

            // Find maximum element in current window
            for (int i = ws; i <= we; i++) {
                max = Math.max(max, nums[i]);
            }

            list.add(max);

            // Move window forward
            we++;
            ws++;
        }

        // Convert List<Integer> to int[]
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int k = 3;

        System.out.println(
                "Maximum of each sliding window: "
                        + Arrays.toString(maxSlidingWindow(arr, k)));
    }
}