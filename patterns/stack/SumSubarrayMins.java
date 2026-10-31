package patterns.stack;

import java.util.Stack;

public class SumSubarrayMins {

    /*
     * Problem : Sum of Subarray Minimums
     * LeetCode : #907
     * Link: https://leetcode.com/problems/sum-of-subarray-minimums/
     * Pattern : Monotonic Stack
     * Difficulty : Medium
     * Date Solved: 31-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First, find the next smaller element and previous smaller
     * element for every index using monotonic stacks.
     *
     * For each element, calculate how many subarrays have that
     * element as their minimum:
     * left = i - pse[i]
     * right = nse[i] - i
     *
     * The contribution of arr[i] is left * right * arr[i].
     * Add every contribution while applying modulo 10^9 + 7.
     *
     * Optimal Approach:
     * Contribution technique using monotonic stacks.
     * Instead of calculating the minimum for every subarray,
     * count the subarrays in which each element is the minimum.
     *
     * Pattern Insight:
     * Monotonic Stack / Contribution Technique
     *
     * Mistake I Made:
     * No specific mistake was reported.
     * Important: Use different comparison conditions for NSE
     * and PSE to handle duplicate elements without counting
     * the same subarray more than once.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given an array of integers, find the sum of the minimum
    // values of every contiguous subarray.
    // Return the answer modulo 10^9 + 7.
    // - Optimal Approach

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallestElement(arr);
        int[] pse = previousSmallestElement(arr);
        int minSum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            minSum = (int) ((minSum
                    + (long) right * left % mod * (arr[i] % mod)) % mod);
        }

        return minSum;
    }

    // - Find the next smaller element's index

    public int[] nextSmallestElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return res;
    }

    // - Find the previous smaller element's index

    public int[] previousSmallestElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }
}