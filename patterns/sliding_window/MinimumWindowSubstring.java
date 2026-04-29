package patterns.sliding_window;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /*
     * Problem : Minimum Window Substring
     * LeetCode : #76
     * Link: https://leetcode.com/problems/minimum-window-substring/
     * Pattern : Sliding Window + HashMap
     * Difficulty : Hard
     * Date Solved: 18-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initially tried using a HashMap to track frequencies of characters in t
     * and used two pointers (ws, we) to expand and shrink the window.
     * Used a variable (uniqueCharCount) to track when all characters are matched.
     *
     * Optimal Approach:
     * Use Sliding Window + frequency map.
     * Maintain a variable `required = t.length()` to track total characters needed.
     * Expand window (we pointer):
     * - Decrease frequency in map
     * - If character was needed (freq > 0), reduce required
     *
     * When required == 0 → valid window:
     * - Try shrinking (ws pointer)
     * - Update minimum window length
     * - If removing a char makes it invalid (freq > 0), increase required
     *
     * This works because we track total required characters, not just unique ones.
     *
     * Pattern Insight:
     * Whenever problem asks for:
     * - "smallest substring"
     * - "contains all characters"
     * - "minimum window"
     *
     * → Think Sliding Window + Frequency Map
     *
     * Trigger:
     * Need dynamic window + condition validation → classic sliding window
     *
     * Mistake I Made:
     * - Used `uniqueCharCount = map.size()` before building map (wrong
     * initialization)
     * - Misinterpreted requirement by tracking only unique characters instead of
     * total count
     * - This fails for duplicate characters in t (e.g., "AABC")
     *
     * Time Complexity: O(n + m) ≈ O(n)
     * Space Complexity: O(1) (since map size is at most 52 / 128 chars)
     */

    // Given two strings s and t of lengths m and n respectively, return the minimum
    // window substring of s such that every character in t (including duplicates)
    // is included in the window. If there is no such substring, return the empty
    // string "".
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int ws = 0, we = 0;
        int uniqueCharCount = map.size();

        while (we < n) {
            // Expansion Phase
            char ch = s.charAt(we);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    uniqueCharCount--;

            }
            // Shriking Phase
            while (uniqueCharCount == 0) {
                int len = we - ws + 1;
                if (len < minLen) {
                    startIdx = ws;
                    minLen = len;
                }
                ch = s.charAt(ws);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }
                ws++;
            }
            we++;
        }
        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANCASC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }
}
