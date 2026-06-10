package patterns.stack;

public class LargestRectangleInHistogram {
    /*
     * Problem : Largest Rectangle in Histogram
     * LeetCode : #84
     * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
     * Pattern : Monotonic Increasing Stack
     * Difficulty : Hard
     * Date Solved: 10-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Initial Approach:
     * Calculated Previous Smaller Element (PSE)
     * and Next Smaller Element (NSE) separately.
     *
     * Formula:
     * width = NSE - PSE - 1
     * area = height * width
     *
     * This worked but required:
     * - Two extra arrays
     * - Two separate traversals
     * - Additional space O(n)
     *
     * Optimal Approach:
     * Use a single Monotonic Increasing Stack.
     *
     * Store indices of bars in increasing order.
     *
     * Whenever a smaller height is found:
     * - Current bar becomes NSE
     * - Stack top after popping becomes PSE
     * - Calculate area immediately
     *
     * Add a virtual bar of height 0 at the end
     * to force processing of all remaining bars.
     *
     * Steps:
     * 1. Traverse histogram from left to right.
     * 2. Maintain increasing stack of indices.
     * 3. If current height is smaller than stack top:
     * - Pop index.
     * - Calculate height.
     * - Find previous smaller element.
     * - Calculate width.
     * - Update maximum area.
     * 4. Push current index.
     * 5. Continue until virtual height 0 processes
     * all remaining bars.
     *
     * Why it works:
     * For every bar:
     * - NSE is discovered when it gets popped.
     * - PSE is the new stack top after popping.
     *
     * Thus width can be calculated instantly:
     *
     * width = NSE - PSE - 1
     *
     * without storing separate NSE/PSE arrays.
     *
     * Pattern Insight:
     * Whenever a problem asks:
     * - Previous Smaller Element
     * - Next Smaller Element
     * - Largest Area / Range Contribution
     * - Nearest Greater / Smaller
     *
     * Think Monotonic Stack.
     *
     * If both PSE and NSE are required,
     * try calculating them during popping
     * instead of storing them separately.
     *
     * Mistakes I Made:
     * - Used:
     * width = PSE - NSE - 1
     * instead of:
     * width = NSE - PSE - 1
     *
     * - Returned -1 as NSE when no smaller
     * element existed on the right.
     * Correct boundary should be n.
     *
     * - Initially used Stack<Integer>,
     * which adds object overhead.
     *
     * - Later optimized using an int[]
     * as a manual stack.
     *
     * Optimization:
     * Replace Stack<Integer> with:
     *
     * int[] stack = new int[n + 1];
     * int top = -1;
     *
     * Benefits:
     * - No boxing/unboxing
     * - Faster push/pop
     * - Lower memory overhead
     *
     * Time Complexity: O(n)
     * Each index is pushed once
     * and popped once.
     *
     * Space Complexity: O(n)
     * Stack stores at most n indices.
     */
    // Given an array of integers heights representing the histogram's bar height
    // where the width of each bar is 1, return the area of the largest rectangle in
    // the histogram.

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        int[] stack = new int[n + 1];
        int idx = -1;

        for (int i = 0; i <= n; i++) {
            int el = (i == n) ? 0 : heights[i];
            while (idx != -1 && heights[stack[idx]] > el) {
                int h = heights[stack[idx--]];
                int ps = (idx == -1) ? -1 : stack[idx];
                int w = i - ps - 1;
                max = Math.max(max, h * w);
            }
            stack[++idx] = i;
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        // System.out.print(Arrays.toString(nextSmallerElement(arr)));
        System.out.print("Largest histogram area is: " + largestRectangleArea(arr));
    }
}