package patterns.binary_search;

public class CapacityToShipPackagesWithinDDays {
    /*
     * Problem : Capacity To Ship Packages Within D Days
     * LeetCode : #1011
     * Link:
     * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
     * Pattern : Binary Search on Answer
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Binary Search on the answer (ship capacity).
     *
     * - The minimum capacity can never be smaller than
     * the heaviest package.
     *
     * - The maximum capacity can never exceed the sum
     * of all package weights.
     *
     * - Binary search between these two capacities.
     *
     * - For every capacity, calculate how many days
     * are required to ship all packages.
     *
     * - If the required days are within the given limit,
     * try a smaller capacity.
     *
     * - Otherwise increase the capacity.
     *
     * Why It Works:
     * We are searching for the minimum capacity that
     * allows all packages to be shipped within D days.
     *
     * Observation:
     *
     * If capacity = X works,
     * then every capacity > X also works.
     *
     * If capacity = X does not work,
     * then every capacity < X also does not work.
     *
     * This creates a monotonic search space:
     *
     * Invalid Invalid Invalid Valid Valid Valid
     *
     * Binary search can efficiently find the first
     * valid capacity.
     *
     * Pattern Insight:
     * This is NOT a traditional binary search on an array.
     *
     * We are binary searching the answer itself.
     *
     * Search Space:
     *
     * [max(weights) ........ sum(weights)]
     *
     * For each candidate capacity:
     *
     * - Simulate shipping
     * - Calculate required days
     * - Decide whether the capacity is valid
     *
     * Mistake I Made:
     * - Started minimum capacity from Integer.MIN_VALUE.
     * - Forgot to initialize search boundaries.
     * - Lost package weight when starting a new day.
     * - Started counting days from 0 instead of 1.
     * - Reversed binary search direction.
     * - Forgot that requiredDays <= days means
     * current capacity is valid.
     *
     * Time Complexity:
     * O(n * log(sum(weights)))
     *
     * Space Complexity:
     * O(1)
     */

    // Returns number of days required for a given capacity.
    public static int calPossibleDays(int[] weights, int capacity) {

        int possibleDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                possibleDays++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }

        return possibleDays;
    }

    // Returns minimum ship capacity required
    // to ship all packages within given days.
    public static int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int requiredDays = calPossibleDays(weights, mid);

            if (requiredDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(
                "Minimum Capacity: " +
                        shipWithinDays(weights, days));
    }
}