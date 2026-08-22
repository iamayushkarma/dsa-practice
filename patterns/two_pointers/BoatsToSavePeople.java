package patterns.two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    /**
     * Problem : Boats to Save People
     * LeetCode : #881
     * Link: https://leetcode.com/problems/boats-to-save-people/
     * Pattern : Two Pointers + Greedy
     * Difficulty : Medium
     * Date Solved: 22-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was to try pairing people one by one based on
     * their weights. But without sorting, it becomes difficult to
     * efficiently find the best person to pair with the heaviest person.
     *
     * Then moved to a two-pointer + greedy approach:
     * First sort the array so that the lightest person is at the
     * beginning and the heaviest person is at the end.
     *
     * The heaviest person should always get a boat because they
     * cannot be paired with anyone heavier than them.
     *
     * After placing the heaviest person in a boat, check whether
     * the lightest remaining person can fit in the same boat.
     *
     * Optimal Approach:
     * 1. Sort the array.
     * 2. Place i at the lightest person.
     * 3. Place j at the heaviest person.
     * 4. The heaviest person always needs a boat.
     * 5. Calculate the remaining capacity:
     * rem = limit - people[j].
     * 6. Move j-- because the heaviest person has been placed.
     * 7. If the lightest remaining person fits:
     * people[i] <= rem
     * then pair them and move i++.
     * 8. Continue until i > j.
     *
     * Pattern Insight:
     * Two Pointers + Sorting + Greedy
     *
     * The key greedy idea is:
     * Always handle the heaviest remaining person first.
     *
     * If the lightest person can fit with the heaviest person,
     * pair them. Otherwise, the heaviest person must go alone.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */

    // You are given an array where people[i] represents the weight
    // of the ith person and an integer limit representing the maximum
    // weight allowed in one boat.
    //
    // Each boat can carry at most two people, provided their combined
    // weight does not exceed the limit.
    //
    // Return the minimum number of boats required to rescue everyone.

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int n = people.length;

        int i = 0;
        int j = n - 1;

        int count = 0;

        while (i <= j) {

            // The heaviest person always gets a boat
            int rem = limit - people[j];

            count++;
            j--;

            // If the lightest person can fit with the heaviest person,
            // put them in the same boat.
            if (i <= j && people[i] <= rem) {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] people = { 3, 2, 2, 1 };
        int limit = 3;

        System.out.println(
                "Minimum boats: " + numRescueBoats(people, limit));
    }
}