package patterns.hashing;

public class ValidAnagram {
    /*
     * Problem : Valid Anagram
     * LeetCode : #242
     * Link: https://leetcode.com/problems/valid-anagram/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 09-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used two HashMaps to store frequency of characters for both strings.
     * Then compared both maps using equals().
     * If frequencies match → strings are anagrams.
     *
     * Optimal Approach:
     * Instead of using two maps, we can use a single frequency array (size 26 for
     * lowercase letters).
     * Increment count for characters in s and decrement for t.
     * If all values are zero at the end → valid anagram.
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need to compare frequency of elements
     * - Order does not matter, only counts matter
     *
     * Trigger:
     * "Check if two strings are rearrangements of each other"
     * → Think: frequency counting (hashing)
     *
     * Mistake I Made:
     * - Used extra space (two HashMaps instead of one structure)
     * - Slightly overcomplicated solution for a simple frequency problem
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (if using array) / O(n) (if using HashMap)
     */
    // Given two strings s and t, return true if t is an anagram of s, and false
    // otherwise.
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Is valid anagram: " + isAnagram(s, t));
    }
}
