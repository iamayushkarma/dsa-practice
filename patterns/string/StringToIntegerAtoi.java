package patterns.string;

public class StringToIntegerAtoi {
    /*
     * Problem : String to Integer (atoi)
     * LeetCode : 8
     * Link: https://leetcode.com/problems/string-to-integer-atoi/
     * Pattern : String Traversal + Simulation
     * Difficulty : Medium
     * Date Solved: 29-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I processed the string exactly as described in the problem statement.
     * First, I skipped all leading spaces. Then I checked if the next character
     * was '+' or '-' to determine the sign. After that, I started reading digits
     * one by one, converting them into an integer using:
     *
     *      number = number * 10 + digit
     *
     * Before adding each digit, I checked whether the next operation would
     * overflow the integer range. If overflow was detected, I immediately
     * returned Integer.MAX_VALUE or Integer.MIN_VALUE depending on the sign.
     * Parsing stops as soon as a non-digit character is encountered.
     *
     * Optimal Approach:
     * 1. Skip all leading whitespaces.
     * 2. Determine the sign (+ or -).
     * 3. Traverse digit characters.
     * 4. Before updating the number, check for overflow.
     * 5. Stop at the first non-digit character.
     * 6. Return number * sign.
     *
     * Pattern Insight:
     * String Traversal
     * Simulation
     * Overflow Handling
     *
     * Mistake I Made:
     * Initially, I thought I needed to explicitly skip leading zeros. Later I
     * realized it happens automatically because multiplying 0 by 10 and adding
     * another 0 still results in 0. So inputs like "000123" naturally become 123
     * without any special handling.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * where:
     * n = length of the input string
     */

    // Convert a string to a 32-bit signed integer according to the atoi rules.
    public static int myAtoi(String s) {

        int n = s.length();
        int sign = 1;
        int number = 0;
        int i = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ')
            i++;

        // Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        // Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Overflow check
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digit;
            i++;
        }

        return number * sign;
    }

    public static void main(String[] args) {

        String s = "   -042abc";

        System.out.println("Converted Integer: " + myAtoi(s));
    }
}