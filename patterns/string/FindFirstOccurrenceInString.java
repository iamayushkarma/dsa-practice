package patterns.string;

public class FindFirstOccurrenceInString {
    /*
     * Problem : Find the Index of the First Occurrence in a String
     * LeetCode : 28
     * Link:
     * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-
     * string/
     * Pattern : String Traversal + Brute Force
     * Difficulty : Easy
     * Date Solved: 29-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I treated every valid index in the haystack as a possible starting point
     * for the needle. From each starting position, I compared characters of both
     * strings one by one. If all characters matched, I returned the current
     * starting index. If a mismatch occurred, I moved to the next possible
     * starting position and repeated the process.
     *
     * Optimal Approach:
     * 1. Iterate through every possible starting index in the haystack.
     * 2. Compare the needle character by character with the substring starting
     * at the current index.
     * 3. If all characters match, return the current index.
     * 4. If no match is found after checking all positions, return -1.
     *
     * Pattern Insight:
     * String Traversal
     * Brute Force
     * Two Pointers (i + j)
     *
     * Mistake I Made:
     * Initially, I tried solving this problem using a frequency array and
     * sliding window, which is suitable for anagram problems (LeetCode 438,
     * 567). However, this problem requires matching characters in the exact
     * order, not just matching frequencies. Therefore, direct character
     * comparison is the correct approach.
     *
     * Time Complexity: O((n - m + 1) * m)
     * Space Complexity: O(1)
     *
     * where:
     * n = length of haystack
     * m = length of needle
     */

    // Return the index of the first occurrence of needle in haystack.
    // If needle does not exist, return -1.
    public static int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m == 0)
            return 0;

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println("First Occurrence Index: " + strStr(haystack, needle));
    }
}