package patterns.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {

    /*
     * Problem : Reveal Cards In Increasing Order
     * LeetCode : #950
     * Link: https://leetcode.com/problems/reveal-cards-in-increasing-order/
     * Pattern : Queue Simulation
     * Difficulty : Medium
     * Date Solved: 12-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Simulate the revealing process using indices.
     * Sort the deck and place the smallest cards
     * at positions that would be revealed first.
     *
     * Optimal Approach:
     * Store all indices in a queue.
     * Sort the deck.
     * For each card:
     * - Place it at the front index.
     * - Move the next front index to the back.
     *
     * Pattern Insight:
     * When a problem involves repeatedly:
     * - Taking from the front
     * - Moving the next item to the back
     * think Queue Simulation.
     *
     * Mistake I Made:
     * Tried to simulate card movement directly.
     * Easier approach is to simulate positions (indices).
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */

    static class Solution {

        public int[] deckRevealedIncreasing(int[] deck) {

            int n = deck.length;

            Arrays.sort(deck);

            int[] answer = new int[n];

            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                queue.addLast(i);
            }

            for (int card : deck) {

                int idx = queue.removeFirst();

                answer[idx] = card;

                if (!queue.isEmpty()) {
                    queue.addLast(queue.removeFirst());
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };

        System.out.println(
                Arrays.toString(sol.deckRevealedIncreasing(deck)));

        // [2, 13, 3, 11, 5, 17, 7]
    }
}