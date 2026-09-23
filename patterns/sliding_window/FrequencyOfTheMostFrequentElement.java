package patterns.sliding_window;

import java.util.*;

public class FrequencyOfTheMostFrequentElement {
    /*
     * Problem : Frequency of the Most Frequent Element
     * LeetCode : #1838
     * Link:
     * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
     * Pattern : Sliding Window + Sorting
     * Difficulty : Medium
     * Date Solved: 23-09-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First sort the array so that elements inside a window
     * can be increased toward nums[we].
     *
     * - Sort the array
     * - Maintain a sliding window using ws and we
     * - Keep the sum of elements inside the window
     * - Treat nums[we] as the value we want all elements
     * in the current window to become
     * - Calculate whether the available k operations are
     * enough to make every element equal to nums[we]
     * - If the window requires more than k operations,
     * shrink it from the left
     * - Keep track of the maximum valid window size
     *
     * Why It Works:
     * After sorting, nums[we] is the largest element in
     * the current window.
     *
     * To make every element in the window equal to nums[we],
     * the required operations are:
     *
     * nums[we] * windowSize - windowSum
     *
     * If this value is <= k, the entire window can be
     * converted to the same value.
     *
     * Therefore, the window size represents a possible
     * frequency of the most frequent element.
     *
     * Pattern Insight:
     * This is a combination of:
     *
     * 1. Sorting
     * 2. Sliding Window
     * 3. Frequency / Cost calculation
     *
     * The key idea is:
     *
     * "For a sorted window, make every element equal to
     * the largest element in that window."
     *
     * Mistake I Made:
     * - Used int for total sum.
     * - Multiplication between nums[we] and window size
     * can overflow int.
     * - The window sum can also exceed Integer.MAX_VALUE.
     *
     * Correction:
     * Use long for total and cast the multiplication:
     *
     * (long) nums[we] * windowSize
     *
     * Time Complexity:
     * O(n log n)
     * Sorting takes O(n log n)
     * Sliding window takes O(n)
     *
     * Space Complexity:
     * O(1) auxiliary space
     * (ignoring the sorting implementation)
     */

    // Returns the maximum possible frequency after
    // performing at most k increment operations.

    public static int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int ws = 0;
        int we = 0;
        int n = nums.length;

        int res = 0;
        long total = 0;

        while (we < n) {

            total += nums[we];

            // Cost to make every element in the window
            // equal to nums[we] is greater than k.
            while ((long) nums[we] * (we - ws + 1) > total + k) {
                total -= nums[ws];
                ws++;
            }

            res = Math.max(res, we - ws + 1);

            we++;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 4 };
        int k = 5;

        System.out.println(
                "Maximum Frequency: " + maxFrequency(nums, k));
    }
}