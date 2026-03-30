package patterns.two_pointers;

public class ValidPalindrome {
    /*
     * Problem : Valid Palindrome
     * LeetCode : #125
     * Link: https://leetcode.com/problems/valid-palindrome/description/
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 30-03-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Optimal Approach:
     * Take two pointers i and j, place i at start of string and j at end then check
     * if i and j are equal if at any point they are not equal, it means its not a
     * palindrome
     *
     * Pattern Insight:
     * Two Pointers
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    // Given a string s, return true if it is a palindrome, or false otherwise.
    public static boolean checkPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            char left = str.charAt(i);
            char right = str.charAt(j);

            if (Character.toLowerCase(left) != Character.toLowerCase(right))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "Markram";
        System.out.println("Is string palindrome: " + checkPalindrome(str));
    }
}
