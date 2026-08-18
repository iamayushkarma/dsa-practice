package patterns.hashing;

import java.util.*;

public class WordPattern {
    /*
     * Problem : Word Pattern
     * LeetCode : #290
     * Link: https://leetcode.com/problems/word-pattern/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 18-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a HashMap to store the mapping between each character in the
     * pattern and its corresponding word.
     * I also used a HashSet to make sure that two different characters
     * cannot map to the same word.
     *
     * First, I check if the number of characters in pattern matches the
     * number of words in s.
     *
     * Then for each character:
     * - If the character is not present in the map, check if the word is
     * already used by another character.
     * - If the word is already present in the set → invalid pattern.
     * - Otherwise, create the character → word mapping.
     * - If the character already exists, check whether it maps to the
     * same word as before.
     *
     * Optimal Approach:
     * The HashMap + HashSet approach is already optimal in terms of
     * asymptotic time complexity.
     * We need to process every character/word at least once.
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need to maintain a mapping between characters and words.
     * - Each character must consistently map to the same word.
     * - Each word can belong to only one character.
     *
     * Trigger:
     * "Check if a pattern matches a sequence of words"
     * → Think: two-way / one-to-one mapping (HashMap + HashSet)
     *
     * Mistake I Made:
     * - Initially used only a HashMap.
     * - A HashMap alone checks that one character does not map to
     * multiple words.
     * - But it does not prevent multiple characters from mapping to
     * the same word.
     * - Example: pattern = "abba", s = "dog dog dog dog"
     * would incorrectly allow:
     * a → dog
     * b → dog
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given a pattern and a string s, find whether s follows the same pattern.
    public static boolean WordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        int n = pattern.length();
        int m = arr.length;

        if (n != m)
            return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String match = arr[i];

            if (!map.containsKey(ch)) {

                if (set.contains(match))
                    return false;

                map.put(ch, match);
                set.add(match);

            } else {
                if (!map.get(ch).equals(match))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println("Does word follow pattern: " + WordPattern(pattern, s));
    }
}