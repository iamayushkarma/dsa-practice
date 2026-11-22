package patterns.string;

public class PalindromicSubstrings {

    /**
     * Problem: Palindromic Substrings
     * LeetCode Number: 647
     * Link: https://leetcode.com/problems/palindromic-substrings/
     * Pattern: Expand Around Center
     * Difficulty: Medium
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Consider each index as a possible palindrome center.
     * - Count odd-length palindromes by expanding from (i, i).
     * - Count even-length palindromes by expanding from (i, i + 1).
     * - Use a helper method to count palindromes around a given center.
     *
     * Optimal Approach:
     * - Expand Around Center.
     * - Check both odd and even length palindromes.
     * - Count every valid palindrome during expansion.
     *
     * Pattern Insight:
     * - Every palindrome has a center.
     * - Odd-length palindrome: one center.
     * - Even-length palindrome: two adjacent centers.
     * - Each successful expansion represents one palindromic substring.
     *
     * Mistake I Made:
     * - Initially wrote the expansion logic twice.
     * - Extracted it into a helper method to avoid duplication.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) auxiliary space
     */

    public static int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {

            // Odd length
            int l = i, r = i;
            count += countPalindrome(s, l, r);

            // Even length
            l = i;
            r = i + 1;
            count += countPalindrome(s, l, r);
        }

        return count;
    }

    public static int countPalindrome(String s, int l, int r) {

        int count = 0;
        int n = s.length();

        while ((l >= 0 && r < n) && (s.charAt(l) == s.charAt(r))) {
            count++;
            l--;
            r++;
        }

        return count;
    }

    public static void main(String[] args) {

        assert countSubstrings("abc") == 3;
        assert countSubstrings("aaa") == 6;
        assert countSubstrings("a") == 1;
        assert countSubstrings("abccba") == 9;
        assert countSubstrings("racecar") == 10;
        assert countSubstrings("") == 0;

        System.out.println("All test cases passed!");
    }
}