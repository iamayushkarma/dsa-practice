package patterns.hashing;

public class FirstUniqueCharacter {
    /*
     * Problem : First Unique Character in a String
     * LeetCode : #387
     * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
     * Pattern : Hashing / Frequency Count
     * Difficulty : Easy
     * Date Solved: 16-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First I used a HashMap to store frequency of each character.
     * Then I looped again to find the first character with frequency < 2.
     * This works fine but uses extra overhead of HashMap.
     *
     * Optimal Approach:
     * Instead of HashMap, use an array of size 26 to store frequency.
     * - First pass → count frequency of each character
     * - Second pass → return index where frequency == 1
     *
     * Array is faster than HashMap because:
     * - No hashing
     * - Direct index access
     *
     * Pattern Insight:
     * This is a classic frequency counting problem.
     * Whenever characters are limited (like lowercase a–z), use array instead of
     * HashMap.
     *
     * Mistake I Made:
     * - Initially used HashMap without thinking about constraints
     * - Didn’t optimize even though characters are only lowercase letters
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a string s, find the first non-repeating character in it and return its
    // index. If it does not exist, return -1.
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("First unique char is at index: " + firstUniqChar(s));
    }
}
