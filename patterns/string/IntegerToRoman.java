package patterns.string;

public class IntegerToRoman {

    /**
     * Problem: Integer to Roman
     * LeetCode Number: 12
     * Link: https://leetcode.com/problems/integer-to-roman/
     * Pattern: Greedy
     * Difficulty: Medium
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Maintain two arrays: one for integer values and another for Roman symbols.
     * - Store values in descending order.
     * - Traverse the values array.
     * - While num is greater than or equal to the current value:
     * - Append the corresponding Roman symbol.
     * - Subtract the current value from num.
     *
     * Optimal Approach:
     * - Greedy approach using descending integer values.
     * - Match the largest possible Roman numeral at every step.
     * - Use two parallel arrays to maintain value-symbol mapping.
     *
     * Pattern Insight:
     * - Always choose the largest possible denomination first.
     * - Subtractive combinations (IV, IX, XL, XC, CD, CM)
     * must be included.
     * - Descending order ensures the correct Roman numeral is generated.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(1) for the given constraints (1 <= num <= 3999).
     * Space Complexity: O(1) auxiliary space, excluding the output.
     */

    public static String intToRoman(int num) {

        int[] values = {
                1000, 900, 500, 400, 100, 90, 50,
                40, 10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD", "C", "XC", "L",
                "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        assert intToRoman(3).equals("III");
        assert intToRoman(4).equals("IV");
        assert intToRoman(9).equals("IX");
        assert intToRoman(58).equals("LVIII");
        assert intToRoman(1994).equals("MCMXCIV");
        assert intToRoman(3999).equals("MMMCMXCIX");
        assert intToRoman(1000).equals("M");

        System.out.println("All test cases passed!");
    }
}