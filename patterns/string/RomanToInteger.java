package patterns.string;

public class RomanToInteger {

    /**
     * Problem: Roman to Integer
     * LeetCode Number: 13
     * Link: https://leetcode.com/problems/roman-to-integer/
     * Pattern: String Traversal / Conditional Subtraction
     * Difficulty: Easy
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Traverse the Roman numeral from left to right.
     * - Get the numeric value of the current character using switch-case.
     * - If the current value is smaller than the next value,
     * subtract the current value.
     * - Otherwise, add the current value.
     *
     * Optimal Approach:
     * - Single-pass traversal.
     * - Use conditional subtraction to handle special Roman numeral cases.
     * - Use switch-case to retrieve character values.
     *
     * Pattern Insight:
     * - Normally, Roman numerals are written in descending order.
     * - When a smaller value appears before a larger value,
     * subtract the smaller value.
     * - Otherwise, add the current value.
     *
     * Mistake I Made:
     * - Initially used the character directly instead of converting
     * it into its corresponding numeric value.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int romanToInt(String s) {

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {

            int currentVal = getVal(s.charAt(i));

            // If current value is smaller than next value, subtract it
            if (i < length - 1 && currentVal < getVal(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }

        return total;
    }

    // Returns the numeric value of a Roman numeral character
    private static int getVal(char c) {

        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

        assert romanToInt("III") == 3;
        assert romanToInt("LVIII") == 58;
        assert romanToInt("MCMXCIV") == 1994;
        assert romanToInt("IV") == 4;
        assert romanToInt("IX") == 9;
        assert romanToInt("XL") == 40;
        assert romanToInt("CD") == 400;
        assert romanToInt("MMMCMXCIX") == 3999;

        System.out.println("All test cases passed!");
    }
}