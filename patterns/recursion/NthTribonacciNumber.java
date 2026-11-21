package patterns.recursion;

public class NthTribonacciNumber {

    /*
     * Problem : N-th Tribonacci Number
     * LeetCode : #1137
     * Link: https://leetcode.com/problems/n-th-tribonacci-number/
     * Pattern : Dynamic Programming / Recursion
     * Difficulty : Easy
     * Date Solved: 21-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Use recursion to calculate the Tribonacci number.
     * - Base cases:
     * T(0) = 0
     * T(1) = 1
     * T(2) = 1
     * - For n >= 3:
     * T(n) = T(n-1) + T(n-2) + T(n-3)
     *
     * Optimal Approach:
     * - Dynamic Programming using memoization or tabulation.
     * - Store previously calculated results to avoid repeated work.
     *
     * Pattern Insight:
     * - Each state depends on the previous three states.
     * - Overlapping subproblems make this suitable for DP.
     *
     * Mistake I Made:
     * - Recursive implementation recalculates the same subproblems
     * multiple times.
     *
     * Time Complexity: O(3^n) for the recursive implementation.
     * Space Complexity: O(n) due to the recursion stack.
     */

    /*
     * Problem Statement:
     * The Tribonacci sequence is defined as:
     *
     * T(0) = 0
     * T(1) = 1
     * T(2) = 1
     *
     * T(n) = T(n-1) + T(n-2) + T(n-3), for n >= 3.
     *
     * Given n, return the value of T(n).
     */

    public static int tribonacci(int n) {
        if (n == 0)
            return n;
        if (n == 1 || n == 2)
            return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static void main(String[] args) {

        // Test Case 1
        assert tribonacci(0) == 0;

        // Test Case 2
        assert tribonacci(1) == 1;

        // Test Case 3
        assert tribonacci(2) == 1;

        // Test Case 4
        assert tribonacci(4) == 4;

        // Test Case 5
        assert tribonacci(5) == 7;

        // Test Case 6
        assert tribonacci(25) == 1389537;

        System.out.println("All test cases passed!");
    }
}