package patterns.string;

public class LongestPalindromicSubstring {

    /**
     * Problem: Longest Palindromic Substring
     * LeetCode Number: 5
     * Link: https://leetcode.com/problems/longest-palindromic-substring/
     * Pattern: Expand Around Center
     * Difficulty: Medium
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Consider every index as a possible palindrome center.
     * - Expand outward for odd-length palindromes.
     * - Expand outward between adjacent characters for even-length palindromes.
     * - Update the longest palindrome whenever a longer one is found.
     *
     * Optimal Approach:
     * - Expand Around Center.
     * - Check both odd and even length palindromes at every index.
     *
     * Pattern Insight:
     * - Odd-length palindrome has one center.
     * - Even-length palindrome has two centers.
     * - Expand in both directions while characters match.
     *
     * Mistake I Made:
     * - Initially didn't understand why separate checks are needed
     * for odd-length and even-length palindromes.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) auxiliary space
     */

    public static String longestPalindrome(String s) {

        int n = s.length();
        int maxLen = 0;
        String str = "";

        for (int i = 0; i < n; i++) {

            // Odd length
            int l = i, r = i;

            while ((l >= 0 && r < n) && (s.charAt(l) == s.charAt(r))) {
                if (r - l + 1 >= maxLen) {
                    maxLen = r - l + 1;
                    str = s.substring(l, r + 1);
                }

                l--;
                r++;
            }

            // Even length
            l = i;
            r = i + 1;

            while ((l >= 0 && r < n) && (s.charAt(l) == s.charAt(r))) {
                if (r - l + 1 >= maxLen) {
                    maxLen = r - l + 1;
                    str = s.substring(l, r + 1);
                }

                l--;
                r++;
            }
        }

        return str;
    }

    public static void main(String[] args) {

        assert longestPalindrome("babad").equals("aba");
        assert longestPalindrome("cbbd").equals("bb");
        assert longestPalindrome("a").equals("a");
        assert longestPalindrome("ac").equals("c");
        assert longestPalindrome("racecar").equals("racecar");
        assert longestPalindrome("aaaa").equals("aaaa");
        assert longestPalindrome("").equals("");

        System.out.println("All test cases passed!");
    }
}