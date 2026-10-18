package patterns.arrays.matrix;

import java.util.Arrays;

public class DiagonalTraverse {

    /**
     * Problem : Diagonal Traverse
     * LeetCode : 498
     * Link: https://leetcode.com/problems/diagonal-traverse/
     * Pattern : Matrix Traversal (Diagonal Simulation)
     * Difficulty : Medium
     * Date Solved: 18-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Calculated the number of rows (n) and columns (m) in the matrix.
     * - Created a result array of size n * m to store all matrix elements
     * in diagonal traversal order.
     * - Used two pointers, i and j, to track the current cell.
     * - Used a boolean variable goingUp to control the traversal direction:
     * - goingUp = true: Move diagonally upward and to the right.
     * - goingUp = false: Move diagonally downward and to the left.
     * - During upward traversal, moved from (i, j) to (i - 1, j + 1).
     * - During downward traversal, moved from (i, j) to (i + 1, j - 1).
     * - When a boundary was reached, adjusted the pointers to the next
     * starting position and reversed the traversal direction.
     * - Continued until all n * m elements were stored in the result array.
     *
     * Pattern Insight:
     * - Diagonal traversal is a matrix simulation problem.
     * - The direction alternates after completing each diagonal.
     * - Moving diagonally changes both row and column indices.
     * - Boundary handling is important because the next diagonal may start
     * at a different row or column depending on which boundary is reached.
     * - A direction flag makes it possible to implement alternating
     * traversal without maintaining a separate list of diagonals.
     *
     * Mistake I Made:
     * - No specific implementation mistake was reported.
     * - Important pitfalls:
     * - Forgetting to reverse the traversal direction.
     * - Incorrectly adjusting i and j after reaching a boundary.
     * - Using incorrect loop conditions for rectangular matrices.
     * - Continuing after all n * m elements have been collected.
     *
     * Time Complexity: O(n * m)
     * - Every matrix element is visited exactly once.
     *
     * Space Complexity: O(1) auxiliary space.
     * - The result array requires O(n * m) space.
     * - Excluding the output array, the algorithm uses O(1) extra space.
     */

    // Given an m x n matrix, return all elements in diagonal traversal order.

    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] res = new int[n * m];
        int idx = 0;

        boolean goingUp = true;

        int i = 0, j = 0;

        while (idx != n * m) {

            if (goingUp) {

                // Move diagonally upward and to the right.
                while (i >= 0 && j < m) {
                    res[idx++] = mat[i][j];
                    i--;
                    j++;
                }

                // Adjust position after reaching a boundary.
                if (j == m) {
                    i += 2;
                    j--;
                } else {
                    i++;
                }

                goingUp = false;

            } else {

                // Move diagonally downward and to the left.
                while (i < n && j >= 0) {
                    res[idx++] = mat[i][j];
                    i++;
                    j--;
                }

                // Adjust position after reaching a boundary.
                if (i == n) {
                    j += 2;
                    i--;
                } else {
                    j++;
                }

                goingUp = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[] result = findDiagonalOrder(mat);

        System.out.println(Arrays.toString(result));
    }
}