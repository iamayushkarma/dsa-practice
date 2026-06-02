package patterns.binary_search;

public class SearchA2DMatrixII {
    /*
     * Problem : Search a 2D Matrix II
     * LeetCode : #240
     * Link:
     * https://leetcode.com/problems/search-a-2d-matrix-ii/
     * Pattern : Matrix Search (Row & Column Sorted)
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used the Top-Right Corner Search technique.
     *
     * - Start from the top-right element.
     * - Compare current element with target.
     * - If current element equals target,
     * return true.
     * - If current element is greater than target,
     * move left.
     * - If current element is smaller than target,
     * move down.
     * - Continue until indices go out of bounds.
     *
     * Why It Works:
     * The matrix has two important properties:
     *
     * 1. Each row is sorted from left to right.
     * 2. Each column is sorted from top to bottom.
     *
     * Starting from the top-right corner:
     *
     * - Everything on the left is smaller.
     * - Everything below is larger.
     *
     * Therefore:
     *
     * If current > target:
     * Entire column can be discarded.
     *
     * If current < target:
     * Entire row can be discarded.
     *
     * Each comparison eliminates one complete
     * row or one complete column.
     *
     * Pattern Insight:
     * Unlike LeetCode 74, this matrix is NOT
     * globally sorted.
     *
     * Example:
     *
     * [1, 4, 7]
     * [2, 5, 8]
     * [3, 6, 9]
     *
     * Notice:
     *
     * 7 > 2
     *
     * Row ranges overlap, so we cannot treat the
     * matrix as a single sorted array.
     *
     * Binary searching rows does not work here.
     *
     * Instead, use the special property that
     * rows and columns are individually sorted.
     *
     * Mistake I Made:
     * - Tried solving it like LeetCode 74.
     * - Assumed rows behave like sorted ranges.
     * - Used binary search on rows.
     * - Forgot that row ranges overlap.
     *
     * Example:
     *
     * [1,4,7]
     * [2,5,8]
     * [3,6,9]
     *
     * Target 6 belongs to multiple row ranges,
     * making row binary search unreliable.
     *
     * Time Complexity:
     * O(m + n)
     *
     * Space Complexity:
     * O(1)
     */

    // Given a matrix where rows and columns are sorted,
    // return true if target exists, otherwise false.

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        int target = 16;
        System.out.println("Target Found: " + searchMatrix(matrix, target));
    }
}