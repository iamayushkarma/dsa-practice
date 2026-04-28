package patterns.sliding_window;

public class PermutationString {
    /*
     * Problem : Permutation in String
     * LeetCode : #567
     * Link: https://leetcode.com/problems/permutation-in-string/
     * Pattern : Sliding Window + Frequency Count (Hashing)
     * Difficulty : Medium
     * Date Solved: 18-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Tried brute force by generating all permutations of s1 and checking in s2,
     * but it was too slow due to factorial complexity.
     *
     * Optimal Approach:
     * Applied sliding window of size equal to s1 length on s2.
     * Used two frequency arrays to track characters:
     * - One for s1
     * - One for current window in s2
     *
     * Steps:
     * 1. Fill both arrays for initial window.
     * 2. Compare both arrays.
     * 3. Slide window:
     * - Decrease count of outgoing char
     * - Increase count of incoming char
     * - Compare again
     * 4. If match found, return true.
     *
     * Why it works:
     * Matching frequency arrays means same characters with same count,
     * which implies a permutation.
     *
     * Pattern Insight:
     * When checking if a string’s permutation exists in another string,
     * use fixed-size sliding window with frequency comparison.
     *
     * Mistake I Made:
     * - Considered brute force initially.
     * - Missed edge case when s1 length > s2 length.
     * - Made error in window update (wrong increment/decrement).
     *
     * Time Complexity: O(m * 26)
     * Space Complexity: O(1)
     */
    // Given two strings s1 and s2, return true if s2 contains a permutation of s1,
    // or false otherwise. In other words, return true if one of s1's permutations
    // is the substring of s2.
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        if (isMatched(map1, map2))
            return true;
        for (int i = 1; i <= m - n; i++) {
            map2[s2.charAt(i - 1) - 'a']--;
            map2[s2.charAt(i + n - 1) - 'a']++;
            if (isMatched(map1, map2))
                return true;
        }
        return false;
    }

    // helper fn
    public static boolean isMatched(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaoooo";
        System.out.println("Is Permutation in String: " + checkInclusion(s1, s2));
    }
}
