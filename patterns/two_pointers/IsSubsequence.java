package patterns.two_pointers;

public class IsSubsequence {

    /**
     * Problem : Is Subsequence
     * LeetCode : #392
     * Link: https://leetcode.com/problems/is-subsequence/
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 24-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     *
     * My Approach:
     * I used two pointers to check whether all characters of s
     * appear in t while maintaining their relative order.
     *
     * Pointer i represents the current character of s that we
     * are looking for.
     *
     * Pointer j scans through t from left to right.
     *
     * If s[i] and t[j] match, both pointers are moved because
     * that character has been successfully matched.
     *
     * If they do not match, only j is moved because the current
     * character of t can be skipped.
     *
     *
     * Optimal Approach:
     * 1. Place i at the beginning of s.
     * 2. Place j at the beginning of t.
     * 3. Compare s[i] with t[j].
     * 4. If they match, move both i and j.
     * 5. If they don't match, move only j.
     * 6. Continue until either string is exhausted.
     * 7. If i reaches the end of s, return true.
     * 8. Otherwise, return false.
     *
     *
     * Pattern Insight:
     * Two Pointers
     *
     *
     * The key idea is:
     * We need to find the characters of s inside t in the
     * same relative order.
     *
     * We are allowed to skip characters from t, so when the
     * characters don't match, only the t pointer moves.
     *
     * When the characters match, both characters are consumed,
     * so both pointers move forward.
     *
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */

    // Given two strings s and t, return true if s is a
    // subsequence of t.
    //
    // A subsequence is formed by deleting some characters
    // without changing the relative order of the remaining
    // characters.

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        int n = s.length();
        int m = t.length();

        while (i < n && j < m) {

            char ich = s.charAt(i);
            char jch = t.charAt(j);

            if (ich == jch) {
                i++;
                j++;
            }

            else {
                j++;
            }
        }
        return i == n;
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(
                "Is subsequence: " + isSubsequence(s, t));
    }
}