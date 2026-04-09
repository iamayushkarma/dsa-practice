package patterns.hashing;

import java.util.*;

public class GroupAnagrams {

    /*
     * Problem : Group Anagrams
     * LeetCode : #49
     * Link: https://leetcode.com/problems/group-anagrams/
     * Pattern : Hashing
     * Difficulty : Medium
     * Date Solved: 09-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I converted each string into a character array, sorted it,
     * and used the sorted string as a key in a HashMap.
     * All strings with the same sorted form are grouped together.
     *
     * Optimal Approach:
     * Instead of sorting (O(k log k)), we can use a frequency array (size 26)
     * to count characters and build a unique key in O(k).
     * This reduces overall time complexity.
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need to group elements based on a common property
     * - That property is "same character frequency"
     *
     * Trigger:
     * "Group strings that are rearrangements of each other"
     * → Think: hashing + canonical representation
     *
     * Mistake I Made:
     * - Initially tried mapping key → single string instead of List<String>
     * - Forgot grouping pattern (key → list of values)
     *
     * Time Complexity: O(n * k log k) (sorting approach)
     * Space Complexity: O(n)
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println("Grouped Anagrams: " + groupAnagrams(strs));
    }
}