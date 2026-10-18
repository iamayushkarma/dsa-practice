package patterns.arrays.matrix;

public class ToeplitzMatrix {

    /*
     * Problem : Toeplitz Matrix
     * LeetCode : 766
     * Link: https://leetcode.com/problems/toeplitz-matrix/
     * Pattern : Matrix Traversal (Diagonal Comparison)
     * Difficulty : Easy
     * Date Solved: 18-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * A matrix is a Toeplitz matrix if every element is equal to the
     * element diagonally above and to its left.
     *
     * 1. Start iterating from row 1 and column 1 because the first row
     * and first column have no upper-left diagonal neighbor.
     * 2. Compare matrix[i][j] with matrix[i-1][j-1].
     * 3. If the elements are different, return false immediately.
     * 4. If all comparisons match, return true.
     *
     * Pattern Insight:
     * Every diagonal in a Toeplitz matrix contains identical values.
     * Instead of traversing each diagonal separately, we can verify
     * this property by comparing every cell with its upper-left neighbor.
     *
     * This works because if every adjacent pair along a diagonal matches,
     * all elements on that diagonal must have the same value.
     *
     * Mistake I Made:
     * Initially, I traversed each diagonal separately using a helper method.
     * Although that approach also has O(n * m) time complexity, comparing
     * adjacent diagonal elements directly makes the solution simpler.
     *
     * Time Complexity: O(n * m)
     * We examine each cell except those in the first row and first column.
     *
     * Space Complexity: O(1)
     * We use only a constant amount of extra space.
     */

    public boolean isToeplitzMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ToeplitzMatrix solution = new ToeplitzMatrix();

        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 1, 2, 3 },
                { 6, 5, 1, 2 }
        };

        System.out.println(solution.isToeplitzMatrix(matrix));

        // Output: true
    }
}