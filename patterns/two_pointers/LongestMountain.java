package patterns.two_pointers;

public class LongestMountain {

    /**
     * Problem : Longest Mountain in Array
     * LeetCode : #845
     * Link: https://leetcode.com/problems/longest-mountain-in-array/
     * Pattern : Two Pointers + Peak Expansion
     * Difficulty : Medium
     * Date Solved: 25-Aug-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was to check every possible starting point
     * and try to determine whether a valid mountain exists.
     *
     * Then optimized the thinking by finding the peak of a mountain.
     * A valid mountain must have:
     * - Strictly increasing elements before the peak
     * - A peak
     * - Strictly decreasing elements after the peak
     *
     * For every index, I check whether it is a peak.
     * If it is a peak:
     * - Use one pointer (p) to expand toward the left.
     * - Use another pointer (q) to expand toward the right.
     * - Count the total length of the mountain.
     *
     * Optimal Approach:
     * 1. Iterate through every index.
     * 2. Check whether the current index is a peak:
     * - arr[i] > arr[i - 1]
     * - arr[i] > arr[i + 1]
     * 3. If it is a peak:
     * - Set p = i and q = i.
     * - Move p left while the array is strictly increasing.
     * - Move q right while the array is strictly decreasing.
     * 4. Calculate the mountain length.
     * 5. Update maxLen.
     *
     * Pattern Insight:
     * A mountain can be identified by its peak.
     *
     * peak
     * /\
     * / \
     * / \
     *
     * Left side -> strictly increasing
     * Right side -> strictly decreasing
     *
     * Mistake I Made:
     * - Initially tried to scan from every starting index using
     * a boolean flag to determine whether the peak was reached.
     * - That approach made the logic complicated because increasing
     * and decreasing phases were mixed together.
     * - The cleaner approach is to first identify the peak and then
     * expand in both directions.
     *
     * Time Complexity: O(n^2) in the worst case
     * Space Complexity: O(1)
     *
     * Note:
     * This solution is correct, but it is not the optimal O(n)
     * solution because the left/right expansion can repeatedly
     * scan elements for different peaks.
     */

    // Find the length of the longest valid mountain
    public static int longestMountain(int[] arr) {

        int n = arr.length;
        int i = 0;
        int maxLen = 0;

        while (i < n) {

            // Find the peak
            int j = i;

            if (j > 0 && j < n - 1) {

                // Current element must be greater than both neighbors
                if (arr[j] > arr[j - 1] && arr[j] > arr[j + 1]) {

                    int count = 1;

                    int p = j;
                    int q = j;

                    // Expand towards the left
                    while (p > 0 && arr[p] > arr[p - 1]) {
                        count++;
                        p--;
                    }

                    // Expand towards the right
                    while (q < n - 1 && arr[q] > arr[q + 1]) {
                        count++;
                        q++;
                    }

                    maxLen = Math.max(maxLen, count);
                }
            }

            i++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 1, 4, 7, 3, 2, 5 };

        System.out.println(
                "Length of the longest mountain is: "
                        + longestMountain(arr));
    }
}