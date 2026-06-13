package patterns.recursion;

public class PowXN {
    /*
     * Problem : Pow(x, n)
     * LeetCode : #50
     * Link:
     * https://leetcode.com/problems/powx-n/
     * Pattern : Recursion / Binary Exponentiation
     * Difficulty : Medium
     * Date Solved: June 2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Binary Exponentiation.
     * - Convert n to long to safely handle Integer.MIN_VALUE.
     * - For negative powers, invert x and make exponent positive.
     * - If exponent is odd, multiply answer by current x.
     * - Square x after every step.
     * - Divide exponent by 2.
     * - Continue until exponent becomes 0.
     *
     * Why It Works:
     * Every exponent can be represented in binary form.
     * Instead of multiplying x exactly n times,
     * we repeatedly square x and use only the
     * powers needed according to the binary
     * representation of n.
     *
     * Example:
     * x = 2, n = 13
     * 13 = (1101)₂
     *
     * 2¹ × 2⁴ × 2⁸ = 2¹³
     *
     * This reduces the number of operations
     * from O(n) to O(log n).
     *
     * Pattern Insight:
     * Binary Exponentiation is a Divide & Conquer pattern.
     * Key idea:
     * - Square the base repeatedly.
     * - Process one binary digit of the exponent
     * at a time.
     * - Use the current power only when the bit is 1.
     *
     * Mistake I Made:
     * - Used int for exponent and overflowed on
     * Integer.MIN_VALUE.
     * - Forgot to invert x for negative powers.
     * - Tried multiplying x n times leading to TLE.
     * - Missed the fact that exponent bits determine
     * which powers contribute to the answer.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    // Calculate x raised to the power n.

    public static double myPow(double x, int n) {
        long binaryForm = n;

        if (n < 0) {
            x = 1 / x;
            binaryForm = -binaryForm;
        }

        double ans = 1;

        while (binaryForm > 0) {
            if (binaryForm % 2 == 1) {
                ans *= x;
            }

            x *= x;
            binaryForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;

        System.out.println(myPow(x, n));
    }
}
