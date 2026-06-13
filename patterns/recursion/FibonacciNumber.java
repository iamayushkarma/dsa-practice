package patterns.recursion;

public class FibonacciNumber {
    /*
     * Problem : Fibonacci Number
     * LeetCode : #509
     * Link:
     * https://leetcode.com/problems/fibonacci-number/
     * Pattern : Recursion
     * Difficulty : Easy
     * Date Solved: 13-June-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used recursion based on the Fibonacci definition.
     * - If n is 0, return 0
     * - If n is 1, return 1
     * - Otherwise return fib(n - 1) + fib(n - 2)
     * - Keep breaking the problem into smaller subproblems
     * until reaching the base cases
     *
     * Why It Works:
     * The Fibonacci sequence follows the recurrence:
     * F(n) = F(n - 1) + F(n - 2)
     *
     * Every recursive call computes the two previous
     * Fibonacci numbers and combines them to get the
     * current result. The base cases prevent infinite
     * recursion and provide the starting values.
     *
     * Pattern Insight:
     * This is a classic Recursion problem.
     * Key idea:
     * - Define the smallest solvable cases (base cases)
     * - Express the larger problem using smaller versions
     * of the same problem
     *
     * Mistake I Made:
     * - Forgot to define proper base cases.
     * - Returned 1 for n = 0 by mistake.
     * - Confused recursive relation with iterative logic.
     * - Ignored the repeated calculations caused by recursion.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */

    // Return the nth Fibonacci number.

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Fibonacci Number: " + fib(n));
    }
}
