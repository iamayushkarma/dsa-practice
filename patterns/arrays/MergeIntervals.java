package patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
     * Problem : Merge Intervals
     * LeetCode : 56
     * Link: https://leetcode.com/problems/merge-intervals/
     * Pattern : Sorting + Greedy
     * Difficulty : Medium
     * Date Solved: 06-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     * 
     * My Approach:
     * First, sort all intervals based on their start time.
     *
     * Then take the first interval as current.
     * Now go through the rest of the intervals one by one:
     *
     * - If the current interval overlaps with the next one:
     * → merge them by updating the end = max(end1, end2)
     *
     * - If they don’t overlap:
     * → store the current interval
     * → move to the next interval
     *
     * At the end, don’t forget to add the last interval.
     *
     * Pattern Insight:
     * Sorting helps bring overlapping intervals next to each other.
     * Then we just merge them step by step.
     *
     * Mistake I Made:
     * Tried comparing only pairs (i and i+1), which fails when multiple
     * intervals overlap in a chain like [1,3], [2,6], [5,8].
     *
     * Time Complexity: O(n log n) (for sorting)
     * Space Complexity: O(n) (for result list)
     */

    // Given an array of intervals where intervals[i] = [starti, endi], merge all
    // overlapping intervals, and return an array of the non-overlapping intervals
    // that cover all the intervals in the input.

    public static int[][] mergeIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (current[1] >= arr[i][0]) {
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                result.add(current);
                current = arr[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 17 }
        };

        int[][] result = mergeIntervals(arr);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
