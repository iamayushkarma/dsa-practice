package patterns.arrays;

import java.util.*;

public class InsertInterval {
    /*
     * Problem : Insert Interval
     * LeetCode : 57
     * Pattern : Greedy + Interval Traversal
     * Difficulty : Medium
     * Date Solved: 07-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * The intervals are already sorted and non-overlapping.
     *
     * We divide the problem into 3 parts:
     *
     * 1. Add all intervals that come before the new interval
     * (i.e., intervals whose end < newInterval start)
     *
     * 2. Merge all overlapping intervals with newInterval
     * (i.e., intervals whose start <= newInterval end)
     * → update newInterval to cover the merged range
     *
     * 3. Add the remaining intervals after merging
     *
     * Finally, return the result list.
     *
     * Pattern Insight:
     * This is a 3-phase greedy traversal:
     * [before] → [merge overlap] → [after]
     *
     * Mistake I Made:
     * Initially confused this with Merge Intervals and tried sorting +
     * pairwise merging, which is unnecessary here.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // You are given a sorted array of non-overlapping intervals, where each
    // interval represents a start and end time. You are also given a new interval.
    // Insert this new interval into the array while maintaining the sorted order
    // and ensuring no overlaps remain by merging any overlapping intervals. Return
    // the updated list of intervals (in-place modification is not required).

    public static int[][] insertIntervals(int[][] arr, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = arr.length;

        // Insert interval to result that are smaller then newInterval
        while (i < n && newInterval[0] > arr[i][1]) {
            result.add(arr[i]);
            i++;
        }
        // Merger intervals is found
        while (i < n && newInterval[1] >= arr[i][0]) {
            newInterval[0] = Math.min(newInterval[0], arr[i][0]);
            newInterval[1] = Math.max(newInterval[1], arr[i][1]);
            i++;
        }
        result.add(newInterval);
        // Insert remaining elements
        while (i < n) {
            result.add(arr[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 },
                { 3, 5 },
                { 6, 7 },
                { 8, 10 },
                { 12, 16 }
        };

        int[] newInterval = { 4, 9 };

        int[][] result = insertIntervals(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
