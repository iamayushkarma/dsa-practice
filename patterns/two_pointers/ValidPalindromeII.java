package patterns.two_pointers;

public class ValidPalindromeII {

    /**
     * Problem : Valid Palindrome II
     * LeetCode : 680
     * Link: https://leetcode.com/problems/valid-palindrome-ii/
     * Pattern : Two Pointers + Greedy
     * Difficulty : Easy
     * Date Solved: 20-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used two pointers, one starting from the left and one from the right.
     *
     * If both characters are equal, move both pointers towards the center.
     *
     * If a mismatch is found, we are allowed to delete at most one character.
     * Therefore, we try both possibilities:
     *
     * 1. Skip the left character.
     * 2. Skip the right character.
     *
     * If either remaining substring is a palindrome, return true.
     *
     * Pattern Insight:
     * Until the first mismatch, the string must behave like a palindrome.
     *
     * At the first mismatch, there are only two possible characters
     * that can be removed: the left character or the right character.
     *
     * We don't need to try deleting every character.
     *
     * Mistake I Made:
     * Initially thought the solution required recursion.
     * But the helper method is just a normal method call.
     *
     * The actual solution uses:
     * Two Pointers + Helper Method + While Loop.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a string s, return true if the string can become a palindrome
    // after deleting at most one character.

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                // Delete left character OR delete right character
                return check(s, left + 1, right)
                        || check(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean check(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abca";

        System.out.println(validPalindrome(s));
    }
}
