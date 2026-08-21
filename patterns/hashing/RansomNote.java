package patterns.hashing;

public class RansomNote {
    /*
     * Problem : Ransom Note
     * LeetCode : #383
     * Link: https://leetcode.com/problems/ransom-note/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 18-08-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a frequency array of size 26 to store the number of available
     * characters in the magazine.
     *
     * First, I count every character in magazine.
     * Then I process every character in ransomNote and decrease its frequency.
     * If any frequency becomes negative, it means the magazine does not have
     * enough copies of that character, so I return false.
     *
     * If all characters in ransomNote can be matched, I return true.
     *
     * Optimal Approach:
     * Use a single frequency array of size 26.
     * Store the available characters from magazine and consume them while
     * processing ransomNote.
     *
     * This is better than using two frequency arrays because we only need
     * to know whether the magazine has enough characters to construct
     * the ransom note.
     *
     * Pattern Insight:
     * This is a Hashing / Frequency Counting problem because:
     * - We need to count how many times each character occurs.
     * - The order of characters does not matter.
     * - We need to compare the required characters with the available characters.
     *
     * Trigger:
     * "Can one string be constructed using the characters of another string?"
     * → Think: frequency counting / hashing
     *
     * Mistake I Made:
     * - Initially used two frequency arrays.
     * - One array counted characters in ransomNote and another counted
     * characters in magazine.
     * - This works, but one array is enough.
     * - The magazine represents the available supply, so I can increment
     * for magazine and decrement while consuming characters for ransomNote.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) because the frequency array always has 26 elements.
     */

    // Given two strings ransomNote and magazine, return true if ransomNote can
    // be constructed by using the letters from magazine and false otherwise.
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        // Count available characters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Consume characters needed for ransomNote
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";

        System.out.println("Can construct ransom note: "
                + canConstruct(ransomNote, magazine));
    }
}