package patterns.binary_search;

public class SearchA2DMatrix {
    /*
     * Problem : Search a 2D Matrix
     * LeetCode : #74
     * Link:
     * https://leetcode.com/problems/search-a-2d-matrix/
     * Pattern : Binary Search on Matrix
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used two levels of binary search.
     *
     * Step 1:
     * Binary search on rows to locate the row that may
     * contain the target.
     *
     * Step 2:
     * Perform binary search inside that row.
     *
     * - If target is found in the row, return true.
     * - If first element of current row is greater than
     * target, search upper rows.
     * - Otherwise search lower rows.
     *
     * Why It Works:
     * The matrix has two important properties:
     *
     * 1. Each row is sorted.
     * 2. First element of a row is greater than the last
     * element of the previous row.
     *
     * Therefore rows themselves behave like sorted blocks.
     *
     * We can first locate the correct row and then perform
     * a normal binary search inside that row.
     *
     * Pattern Insight:
     * Think of each row as a sorted range.
     *
     * Example:
     *
     * [1, 3, 5, 7]
     * [10,11,16,20]
     * [23,30,34,60]
     *
     * Row ranges:
     *
     * [1 - 7]
     * [10 - 20]
     * [23 - 60]
     *
     * First find the correct range (row),
     * then search inside it.
     *
     * Mistake I Made:
     * - Tried scanning rows linearly.
     * - Forgot rows themselves are sorted ranges.
     * - Missed using binary search twice.
     * - Compared against wrong row boundaries.
     *
     * Time Complexity:
     * O(log n * log m)
     *
     * Space Complexity:
     * O(1)
     */

    // Search target inside a sorted row
    public static boolean searchInRow(int[] row, int target) {
        int st = 0;
        int end = row.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }

    // Search target in matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        int st = 0;
        int end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            boolean found = searchInRow(matrix[mid], target);

            if (found) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int target = 16;
        System.out.println("Target Found: " + searchMatrix(matrix, target));
    }
}