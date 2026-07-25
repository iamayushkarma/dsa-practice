package patterns.arrays;

public class GasStation {
    /*
     * Problem : Gas Station
     * LeetCode : #134
     * Link: https://leetcode.com/problems/gas-station/description/
     * Pattern : Greedy
     * Difficulty : Medium
     * Date Solved: 25-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * brute force approach is to try every index as a starting point, simulate
     * the full circuit from there tracking the tank, and check if it ever goes
     * negative. If it never does for a given start, that's the answer.
     * This is O(n^2) since for each of the n starting points we may traverse
     * up to n stations.
     *
     * Optimal Approach:
     * if the total gas is less than total cost, its impossible to complete the
     * circuit no matter where we start, so return -1 immediately.
     * Otherwise, a solution always exists and is unique. Greedily walk through
     * the stations keeping a running tank. Whenever tank goes negative at index
     * i, it means no station between the current start and i could have been a
     * valid starting point either (because if start could reach some station j
     * with a positive/zero tank, start..j is already accounted for, and adding
     * a negative segment after it only makes things worse). So we reset start
     * to i+1 and reset tank to 0, and keep going.
     *
     * Pattern Insight:
     * greedy prefix-sum reset - similar idea to Kadane's algorithm, where a
     * negative running sum forces you to "give up" on the current window and
     * restart from the next index.
     *
     * Mistake I Made:
     * initially tried validating the found start index with a second full
     * pass/simulation out of doubt, but the total >= 0 check already
     * guarantees correctness so that extra pass is redundant.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    // There are n gas stations along a circular route, where the amount of gas
    // at station i is gas[i]. It costs cost[i] of gas to travel from station i
    // to station i+1. Given two integer arrays gas and cost, return the
    // starting gas station's index if you can travel around the circuit once
    // in the clockwise direction, otherwise return -1. If a solution exists,
    // it is guaranteed to be unique.
    // - Optimal Approach
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];

            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    // - Brute Force Approach
    // public static int canCompleteCircuitBrute(int[] gas, int[] cost) {
    // int n = gas.length;
    // for (int start = 0; start < n; start++) {
    // int tank = 0;
    // int count = 0;
    // for (int i = start; count < n; i = (i + 1) % n, count++) {
    // tank += gas[i] - cost[i];
    // if (tank < 0) break;
    // }
    // if (count == n) return start;
    // }
    // return -1;
    // }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println("Starting index is: " + canCompleteCircuit(gas, cost));
    }
}