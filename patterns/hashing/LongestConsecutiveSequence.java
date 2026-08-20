package patterns.hashing;

import java.util.*;

public class LongestConsecutiveSequence {
    /*
     * Problem : Longest Consecutive Sequence
     * LeetCode : 128
     * Link: https://leetcode.com/problems/longest-consecutive-sequence/
     * Pattern : Hashing + Sequence Detection
     * Difficulty : Medium
     * Date Solved: 12-04-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Stored all elements in a HashSet for O(1) lookup.
     * Iterated through each element and only started building a sequence
     * if (el - 1) was not present (i.e., start of a sequence).
     * Then expanded forward (el + 1, el + 2...) to count length.
     *
     * Pattern Insight:
     * Use HashSet to avoid sorting and detect sequence starts.
     * Key trick: Only start when previous element is missing.
     *
     * Mistake I Made:
     * Initially tried sorting the array (O(n log n)),
     * but missed that optimal solution can be O(n) using hashing.
     * Also, without checking (el - 1), it leads to repeated work.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    // Given an unsorted array of integers nums, return the length of the longest
    // consecutive elements sequence.
    public static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int maxSeq = 0;
        for (int el : arr) {
            set.add(el);
        }
        for (int el : set) {
            if (!set.contains(el - 1)) {
                int seq = 1;
                int curEl = el;
                while (set.contains(curEl + 1)) {
                    seq++;
                    curEl++;
                }
                maxSeq = Math.max(maxSeq, seq);
            }
        }
        return maxSeq;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Length of the longest consecutive elements sequence is: " + longestConsecutive(arr));
    }
}
