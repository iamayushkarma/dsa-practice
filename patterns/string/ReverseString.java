package patterns.string;

public class ReverseString {

    /**
     * Problem: Reverse String
     * LeetCode Number: 344
     * Link: https://leetcode.com/problems/reverse-string/
     * Pattern: Two Pointers
     * Difficulty: Easy
     * Date Solved: 22-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Find the length of the character array.
     * - Iterate through the first half of the array.
     * - Swap the current character with its corresponding character
     * from the end.
     * - Continue until the middle of the array is reached.
     *
     * Optimal Approach:
     * - Use two pointers, one at the beginning and one at the end.
     * - Swap characters and move both pointers inward.
     *
     * Pattern Insight:
     * - Two pointers can reverse an array in place.
     * - Only half of the array needs to be traversed.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void reverseString(char[] s) {

        int n = s.length;

        for (int i = 0; i < n / 2; i++) {

            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {

        char[] arr1 = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(arr1);
        assert new String(arr1).equals("olleh");

        char[] arr2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(arr2);
        assert new String(arr2).equals("hannaH");

        char[] arr3 = { 'a' };
        reverseString(arr3);
        assert new String(arr3).equals("a");

        char[] arr4 = { 'a', 'b' };
        reverseString(arr4);
        assert new String(arr4).equals("ba");

        System.out.println("All test cases passed!");
    }
}