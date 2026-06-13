package patterns.recursion;

import java.util.Arrays;

public class ReverseString {
    /*
     * Problem : Reverse String
     * LeetCode : #344
     * Link:
     * https://leetcode.com/problems/reverse-string/
     * Pattern : Recursion
     * Difficulty : Easy
     * Date Solved: June 2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used recursion with two pointers.
     * - Start with left pointer at the beginning
     * and right pointer at the end.
     * - Swap the characters at both pointers.
     * - Move left forward and right backward.
     * - Continue recursively until both pointers
     * meet or cross each other.
     *
     * Why It Works:
     * Each recursive call correctly places two
     * characters in their final reversed positions.
     * When the pointers meet or cross, the entire
     * array has been reversed.
     *
     * Pattern Insight:
     * This is a Recursion + Two Pointers problem.
     * Key idea:
     * - Solve a small part of the problem
     * (swap outer characters).
     * - Delegate the remaining work to a recursive call.
     *
     * Mistake I Made:
     * - Forgot the base condition.
     * - Used extra array instead of modifying in-place.
     * - Moved only one pointer after swapping.
     * - Returned a new array instead of updating
     * the original character array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) // recursion stack
     */

    // Reverse the character array in-place using recursion.

    public static void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverse(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        reverseString(s);

        System.out.println(Arrays.toString(s));
    }
}
