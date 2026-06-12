package patterns.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Dota2Senate {

    /*
     * Problem : Dota2 Senate
     * LeetCode : #649
     * Link: https://leetcode.com/problems/dota2-senate/
     * Pattern : Queue Simulation
     * Difficulty : Medium
     * Date Solved: 12-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Store indices of Radiant and Dire senators in separate queues.
     * Compare the front senators from both queues.
     * The senator with the smaller index acts first and bans the other.
     * The surviving senator gets re-added with index + n.
     *
     * Optimal Approach:
     * Use two queues to simulate rounds.
     * Since senators act in order of their indices,
     * the smaller index always gets the current turn.
     * Re-adding a surviving senator with index + n
     * places them correctly in the next round.
     *
     * Pattern Insight:
     * Multiple groups taking turns in a circular order.
     * Queue is useful for maintaining turn sequence.
     * Re-inserting elements models cyclic processing.
     *
     * Mistake I Made:
     * Used || instead of && in the loop condition.
     * Compared characters ('R' and 'D') instead of indices.
     * Forgot that indices determine turn order.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    static class Solution {

        public String predictPartyVictory(String senate) {

            int n = senate.length();

            Deque<Integer> radiant = new LinkedList<>();
            Deque<Integer> dire = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R')
                    radiant.addLast(i);
                else
                    dire.addLast(i);
            }

            while (!radiant.isEmpty() && !dire.isEmpty()) {

                int r = radiant.removeFirst();
                int d = dire.removeFirst();

                if (r < d)
                    radiant.addLast(r + n);
                else
                    dire.addLast(d + n);
            }

            return radiant.isEmpty() ? "Dire" : "Radiant";
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.predictPartyVictory("RD"));      // Radiant
        System.out.println(sol.predictPartyVictory("RDD"));     // Dire
        System.out.println(sol.predictPartyVictory("RRDDD"));   // Radiant
        System.out.println(sol.predictPartyVictory("DDRRR"));   // Dire
    }
}