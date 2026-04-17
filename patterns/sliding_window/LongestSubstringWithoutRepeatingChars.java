package patterns.sliding_window;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {
    /*
     * Problem : Longest Substring Without Repeating Characters
     * LeetCode : #3
     * Link:
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * Pattern : Sliding Window / Hashing
     * Difficulty : Medium
     * Date Solved: 16-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used sliding window with HashSet.
     * - Expand window using we
     * - If duplicate found → shrink window from ws until valid
     * - Track max length during process
     *
     * This works but uses a while loop to remove elements,
     * which makes it slightly less efficient.
     *
     * Optimal Approach:
     * Used HashMap to store last index of each character.
     * - If duplicate found and index is within current window,
     * directly jump ws to lastIndex + 1
     * - This avoids removing elements one by one
     *
     * This makes the solution more efficient as we skip unnecessary steps.
     *
     * Pattern Insight:
     * This is a variable size sliding window problem.
     * Key idea: maintain a valid window with no duplicates.
     * If constraint breaks → adjust window start.
     *
     * Mistake I Made:
     * - Initially confused between using ws and we
     * - Didn’t realize we can jump ws directly using HashMap
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a string s, find the length of the longest substring without duplicate
    // characters.
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ws = 0, we = 0; // ws -> window start, we -> window end
        int max_len = Integer.MIN_VALUE;

        while (we < n) {
            char ch = s.charAt(we);
            if (map.containsKey(ch) && map.get(ch) >= ws) {
                ws = map.get(ch) + 1;
            }
            max_len = Math.max(max_len, we - ws + 1);
            map.put(ch, we);
            we++;
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest Substring Without Repeating Chars: " + lengthOfLongestSubstring(s));
    }
}
