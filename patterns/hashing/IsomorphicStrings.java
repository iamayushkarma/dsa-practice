package patterns.hashing;

import java.util.*;

public class IsomorphicStrings {

    /**
     * Problem: Isomorphic Strings
     * LeetCode Number: 205
     * Link: https://leetcode.com/problems/isomorphic-strings/
     * Pattern: HashMap / HashSet
     * Difficulty: Easy
     * Date Solved: 25-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - First check whether both strings have equal lengths.
     * - Use a HashMap to maintain the mapping from characters in s to t.
     * - Use a HashSet to track characters already mapped in t.
     * - If a character from s is already mapped, verify that its
     * mapping matches the current character in t.
     * - If a character from s is not mapped, ensure the target
     * character has not already been used.
     * - Store the mapping and mark the target character as used.
     *
     * Optimal Approach:
     * - Use two HashMaps to maintain mappings in both directions,
     * or one HashMap and one HashSet as implemented here.
     * - Ensure every character maps consistently and uniquely.
     *
     * Pattern Insight:
     * - Isomorphic strings require a one-to-one character mapping.
     * - One character cannot map to multiple characters.
     * - Multiple characters cannot map to the same character.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) for the fixed character set.
     */

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            char target = t.charAt(i);

            if (map.containsKey(ch) && map.get(ch) != target) {
                return false;
            }

            if (!map.containsKey(ch) && set.contains(target)) {
                return false;
            }

            map.put(ch, target);
            set.add(target);
        }

        return true;
    }

    public static void main(String[] args) {

        assert isIsomorphic("egg", "add") == true;
        assert isIsomorphic("foo", "bar") == false;
        assert isIsomorphic("paper", "title") == true;
        assert isIsomorphic("badc", "baba") == false;
        assert isIsomorphic("a", "a") == true;
        assert isIsomorphic("ab", "aa") == false;
        assert isIsomorphic("abc", "def") == true;

        System.out.println("All test cases passed!");
    }
}