package patterns.arrays.matrix;

import java.util.*;

public class SpiralMatrixII {

    /**
     * Problem : Spiral Matrix II
     * LeetCode : 59
     * Link: https://leetcode.com/problems/spiral-matrix-ii/
     * Pattern : Matrix Traversal (Boundary Simulation)
     * Difficulty : Medium
     * Date Solved: 17-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Created an n x n matrix to store the result.
     * - Used a variable val initialized to 1 to fill the matrix
     * with consecutive integers from 1 to n * n.
     * - Maintained four boundaries:
     * - r1: Top row
     * - rn: Bottom row
     * - c1: Left column
     * - cn: Right column
     * - Traversed the matrix layer by layer in spiral order:
     * 1. Left to right across the top row.
     * 2. Top to bottom along the right column.
     * 3. Right to left across the bottom row.
     * 4. Bottom to top along the left column.
     * - Shrunk the boundaries after completing each traversal.
     * - Used conditional checks before traversing the bottom row
     * and left column to avoid overwriting elements.
     *
     * Pattern Insight:
     * - Spiral Matrix II is a matrix simulation problem.
     * - Boundary pointers help control the traversal direction
     * without requiring a separate direction array.
     * - After completing each side, shrink the corresponding
     * boundary to move toward the center of the matrix.
     * - The same boundary-simulation pattern applies to both
     * Spiral Matrix (LeetCode 54) and Spiral Matrix II (LeetCode 59).
     *
     * Mistake I Made:
     * - No specific implementation mistake was reported.
     * - Important pitfalls:
     * - Forgetting to update a boundary after traversing a side.
     * - Traversing the bottom row or left column when their
     * boundaries have already crossed.
     * - Incorrectly updating val, causing missing or duplicate values.
     *
     * Time Complexity: O(n^2)
     * - Every cell is visited and assigned exactly once.
     *
     * Space Complexity: O(1) auxiliary space.
     * - The output matrix is excluded from auxiliary space.
     * - Including the output matrix, total space is O(n^2).
     */

    // Given n, generate an n x n matrix filled with integers
    // from 1 to n^2 in spiral order.

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int val = 1;

        int totalCols = n;
        int totalRows = n;

        int r1 = 0, c1 = 0;
        int rn = totalRows - 1, cn = totalCols - 1;

        while (c1 <= cn && r1 <= rn) {

            // Top-left -> top-right
            for (int i = c1; i <= cn; i++) {
                ans[r1][i] = val++;
            }
            r1++;

            // Top-right -> bottom-right
            for (int j = r1; j <= rn; j++) {
                ans[j][cn] = val++;
            }
            cn--;

            // Bottom-right -> bottom-left
            if (r1 <= rn) {
                for (int i = cn; i >= c1; i--) {
                    ans[rn][i] = val++;
                }
                rn--;
            }

            // Bottom-left -> top-left
            if (c1 <= cn) {
                for (int j = rn; j >= r1; j--) {
                    ans[j][c1] = val++;
                }
                c1++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;

        int[][] matrix = generateMatrix(n);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}