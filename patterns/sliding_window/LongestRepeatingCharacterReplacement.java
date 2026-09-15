package patterns.sliding_window;

public class LongestRepeatingCharacterReplacement {

    /**
     * Problem : Longest Repeating Character Replacement
     * LeetCode : #424
     * Link:
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     * Pattern : Variable Size Sliding Window / Frequency Count
     * Difficulty : Medium
     * Date Solved: 15-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used a variable-size sliding window with a frequency array.
     * - freqArray stores character frequencies of the current window
     * - maxFrequency stores the highest frequency of any character
     * seen in the current window
     * - Expand the window by moving the right pointer
     * - Calculate characters that need to be replaced:
     * windowLength - maxFrequency
     * - If replacements needed are greater than k, shrink the window
     * by moving the left pointer
     * - Track the maximum valid window length
     *
     * Why It Works:
     * The most frequent character in the window should remain unchanged.
     * Every other character can be replaced with that character.
     *
     * Therefore:
     *
     * replacementsNeeded = windowLength - maxFrequency
     *
     * If replacementsNeeded <= k, the window is valid.
     * If replacementsNeeded > k, the window is invalid and we
     * shrink it from the left.
     *
     * maxFrequency is not decreased when the window shrinks.
     * This is intentional because we only need the maximum possible
     * window length, and keeping the historical maximum frequency
     * still gives the correct answer.
     *
     * Pattern Insight:
     * This is a variable-size sliding window problem.
     * The window size changes depending on whether the current
     * window satisfies the condition.
     *
     * The important condition is:
     *
     * windowLength - maxFrequency <= k
     *
     * This means we can replace at most k characters to make the
     * entire window contain the same character.
     *
     * Mistake I Made:
     * - Initially updated maxLength using maxFrequency unnecessarily
     * - Need to remember that maxLength represents the window length,
     * not the frequency of the most frequent character
     * - maxFrequency does not need to be decreased when the left
     * pointer moves
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * (Frequency array always has size 26)
     */

    // Find the length of the longest substring that can be converted
    // into a substring containing the same character using at most k replacements.
    public static int characterReplacement(String s, int k) {

        int ws = 0, we = 0;
        int n = s.length();

        int maxLength = 0;
        int maxFrequency = 0;

        int[] freqArray = new int[26];

        while (we < n) {

            char ch = s.charAt(we);

            freqArray[ch - 'A']++;

            maxFrequency = Math.max(
                    maxFrequency,
                    freqArray[ch - 'A']);

            int currentWindowLength = we - ws + 1;

            if (currentWindowLength - maxFrequency > k) {

                freqArray[s.charAt(ws) - 'A']--;
                ws++;

            } else {

                maxLength = Math.max(
                        maxLength,
                        currentWindowLength);
            }

            we++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}