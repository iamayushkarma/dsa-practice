package patterns.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    static class RecentCounter {
        /*
         * Problem : Number of Recent Calls
         * LeetCode : #933
         * Link: https://leetcode.com/problems/number-of-recent-calls/
         * Pattern : Queue / Sliding Window
         * Difficulty : Easy
         * Date Solved: 12-Jun-2026
         * Revision : [ ] Day3 [ ] Day7 [ ] Day14
         *
         * My Approach:
         * Store timestamps in a queue.
         * Remove all timestamps older than (t - 3000).
         * Remaining queue size gives the answer.
         *
         * Optimal Approach:
         * Use a Queue as a sliding window.
         * Since timestamps arrive in increasing order,
         * outdated requests can be removed from the front.
         *
         * Pattern Insight:
         * Fixed-size time window over a stream of incoming data.
         * Old elements become useless and can be discarded.
         *
         * Mistake I Made:
         * Initially thought about storing all timestamps.
         * Didn't immediately recognize the sliding window pattern.
         *
         * Time Complexity: O(1) Amortized
         * Space Complexity: O(n)
         */

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {

            queue.offer(t);

            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }

    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();

        System.out.println(rc.ping(1)); // 1
        System.out.println(rc.ping(100)); // 2
        System.out.println(rc.ping(3001)); // 3
        System.out.println(rc.ping(3002)); // 3
    }
}