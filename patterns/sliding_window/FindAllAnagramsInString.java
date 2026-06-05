package patterns.sliding_window;

import java.util.*;

public class FindAllAnagramsInString {
    /*
     * Problem : Find All Anagrams in a String
     * LeetCode : #438
     * Link:
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     * Pattern : Fixed Size Sliding Window / Frequency Count
     * Difficulty : Medium
     * Date Solved: 29-May-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Used a fixed-size sliding window with two frequency arrays.
     * - freq1 stores character frequencies of the current window in s
     * - freq2 stores character frequencies of string p
     * - Build frequencies for the first window
     * - Compare both frequency arrays
     * - Slide the window by removing the left character
     * and adding the next character on the right
     * - If frequencies match, the current window is an anagram
     *
     * Why It Works:
     * Two strings are anagrams if their character frequencies
     * are exactly the same.
     * By maintaining frequencies for each window of size p.length(),
     * we can efficiently check whether the window is an anagram of p.
     *
     * Pattern Insight:
     * This is a fixed-size sliding window problem.
     * The window size is always equal to p.length().
     * Instead of generating and sorting every substring,
     * we maintain character counts and update them while sliding.
     *
     * Mistake I Made:
     * - Forgot to handle the case when p.length() > s.length()
     * - Missed checking the last window after the sliding loop
     * - Initially used incorrect loop boundaries and skipped
     * the final possible anagram window
     *
     * Time Complexity: O(26 * n) ≈ O(n)
     * Space Complexity: O(1)
     * (Frequency arrays always have size 26)
     */

    // Find all starting indices in a string s where a substring is an anagram of
    // another string p.

    // helper function
    public static boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        List<Integer> res = new ArrayList<>();
        int windowLen = p.length();

        for (int i = 0; i < p.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);

            freq1[c1 - 'a']++;
            freq2[c2 - 'a']++;
        }
        for (int i = 0; i < s.length() - windowLen; i++) {
            if (match(freq1, freq2))
                res.add(i);
            freq1[s.charAt(i) - 'a']--;
            freq1[s.charAt(i + windowLen) - 'a']++;
        }
        if (match(freq1, freq2)) {
            res.add(s.length() - windowLen);
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "abab", b = "ab";
        System.out.println();

    }
}