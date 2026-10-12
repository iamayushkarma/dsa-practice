package patterns.binary_search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    /*
     * Problem : Magnetic Force Between Two Balls
     * LeetCode : #1552
     * Link:
     * https://leetcode.com/problems/magnetic-force-between-two-balls/
     *
     * Pattern : Binary Search on Answer + Greedy
     * Difficulty : Medium
     * Date Solved: 12-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     *
     * Used binary search on the minimum distance between
     * any two balls to maximize the minimum magnetic force.
     *
     * - Sort the position array in ascending order.
     * - Initialize the search space from 1 to the difference
     * between the maximum and minimum positions.
     * - Calculate the mid value as the candidate minimum distance.
     * - Use a greedy approach to check whether m balls can
     * be placed while maintaining at least mid distance.
     * - Place the first ball at the first available position.
     * - Traverse the sorted array and place the next ball
     * whenever the distance from the last placed ball
     * is at least mid.
     * - If m balls can be placed, store mid as the answer
     * and search for a larger minimum distance.
     * - Otherwise, reduce the search space by searching
     * for a smaller minimum distance.
     * - Continue until the search space is exhausted.
     *
     * Why It Works:
     *
     * Sorting allows us to examine positions in ascending order.
     *
     * - Greedily placing each ball at the earliest valid position
     * leaves as much room as possible for the remaining balls.
     * - If we can place m balls with minimum distance mid,
     * then mid is a feasible answer.
     * - If mid is feasible, every smaller positive distance
     * is also feasible.
     * - If mid is not feasible, every larger distance is
     * also infeasible.
     * - This monotonic property allows binary search
     * to find the maximum feasible minimum distance.
     *
     * Pattern Insight:
     *
     * Binary search on answer is useful when we need to
     * maximize or minimize a value and can efficiently
     * check whether a candidate answer is feasible.
     *
     * The greedy feasibility check works because choosing
     * the earliest valid position never reduces the number
     * of balls that can be placed compared with choosing
     * a later valid position.
     *
     * Feasibility Pattern:
     *
     * Smaller distance -> Easier to place balls
     * Larger distance -> Harder to place balls
     *
     * Therefore, once a distance becomes infeasible,
     * all larger distances are infeasible as well.
     *
     * Mistake I Made:
     *
     * - Initialized the binary search start with position[0]
     * instead of 1.
     * - Added an unnecessary condition returning -1 when
     * m >= n, even though m == n is a valid case.
     *
     * Time Complexity:
     *
     * Sorting: O(n log n)
     * Binary Search: O(log D) iterations
     * Greedy Feasibility Check: O(n) per iteration
     *
     * Overall: O(n log n + n log D)
     *
     * Where D = position[n - 1] - position[0].
     *
     * Space Complexity:
     *
     * O(log n) auxiliary space for sorting in the worst case,
     * excluding implementation-dependent details.
     *
     */

    // Checks whether m balls can be placed while maintaining
    // at least the specified minimum distance.
    public static boolean isAllocationAllowed(
            int maxDistance, int m, int[] arr) {

        int ballPlaced = 1;
        int lastPlaced = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - lastPlaced >= maxDistance) {
                ballPlaced++;
                lastPlaced = arr[i];

                if (ballPlaced >= m)
                    return true;
            }
        }

        return false;
    }

    // Returns the maximum possible minimum distance
    // between any two placed balls.
    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int n = position.length;

        int st = 1;
        int end = position[n - 1] - position[0];

        int ans = 0;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (isAllocationAllowed(mid, m, position)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] position = { 1, 2, 3, 4, 7 };
        int m = 3;

        System.out.println(
                "Maximum Minimum Distance: "
                        + maxDistance(position, m));
    }
}
