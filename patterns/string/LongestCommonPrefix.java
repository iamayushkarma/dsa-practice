package patterns.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    /*
     * Problem : Longest Common Prefix
     * LeetCode : 14
     * Link: https://leetcode.com/problems/longest-common-prefix/
     * Pattern : Sorting + String Comparison
     * Difficulty : Easy
     * Date Solved: 28-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * At first, I was thinking about comparing every string character by character,
     * but that would require checking each string repeatedly. After learning the
     * optimal approach, I realized that sorting the array places the most different
     * strings at the beginning and the end. Therefore, the longest common prefix
     * of the entire array must be the common prefix between the first and last
     * strings after sorting.
     *
     * Optimal Approach:
     * 1. Sort the array of strings lexicographically.
     * 2. Compare only the first and last strings character by character.
     * 3. Append matching characters until a mismatch occurs.
     * 4. Return the accumulated prefix.
     *
     * Pattern Insight:
     * Sorting
     * Lexicographical Ordering
     * String Traversal
     *
     * Mistake I Made:
     * I initially thought every string needed to be compared with every other
     * string. I missed the observation that after sorting, the first and last
     * strings are the most different, so their common prefix automatically
     * represents the common prefix of the entire array.
     *
     * Time Complexity: O(n log n * m)
     * Space Complexity: O(m)
     *
     * where:
     * n = number of strings
     * m = average length of a string
     */

    // Given an array of strings, return the longest common prefix among them.
    // If there is no common prefix, return an empty string "".
    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int len = Math.min(first.length, last.length);

        for (int i = 0; i < len; i++) {
            if (first[i] != last[i])
                break;

            sb.append(first[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}