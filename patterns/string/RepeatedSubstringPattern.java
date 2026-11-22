package patterns.string;

public class RepeatedSubstringPattern {

    /**
     * Problem: Repeated Substring Pattern
     * LeetCode Number: 459
     * Link: https://leetcode.com/problems/repeated-substring-pattern/
     * Pattern: String Manipulation / Brute Force
     * Difficulty: Easy
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Iterate through possible substring lengths from n/2 down to 1.
     * - Only consider lengths that divide the original string length.
     * - Extract the prefix substring.
     * - Repeat the substring n/i times using StringBuilder.
     * - Compare the generated string with the original string.
     * - Return true if both strings match.
     *
     * Optimal Approach:
     * - Use the string concatenation technique:
     * Concatenate s with itself, remove the first and last characters,
     * and check whether the original string exists in the result.
     *
     * Pattern Insight:
     * - A repeated string must have a repeating substring whose length
     * divides the original string length.
     * - Only substring lengths up to n/2 need to be checked.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */

    public static boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int i = n / 2; i >= 1; i--) {

            if (n % i == 0) {

                String subStr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                for (int j = 1; j <= n / i; j++) {
                    sb.append(subStr);
                }

                if (sb.toString().equals(s))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        assert repeatedSubstringPattern("abab") == true;
        assert repeatedSubstringPattern("aba") == false;
        assert repeatedSubstringPattern("abcabcabcabc") == true;
        assert repeatedSubstringPattern("aaaa") == true;
        assert repeatedSubstringPattern("a") == false;
        assert repeatedSubstringPattern("abcd") == false;

        System.out.println("All test cases passed!");
    }
}