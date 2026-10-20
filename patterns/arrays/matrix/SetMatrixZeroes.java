package patterns.arrays.matrix;

public class SetMatrixZeroes {

    /*
     * Problem : Set Matrix Zeroes
     * LeetCode : 73
     * Link: https://leetcode.com/problems/set-matrix-zeroes/
     * Pattern : Matrix Manipulation (In-Place Marking)
     * Difficulty : Medium
     * Date Solved: 20-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * The problem requires setting an entire row and column to zero
     * whenever an element in the original matrix is zero.
     *
     * The solution modifies the matrix in place using its first row
     * and first column as markers instead of using an additional matrix.
     *
     * Steps:
     * 1. Create two boolean flags:
     * - firstRowZero: indicates whether the first row originally
     * contains zero.
     * - firstColZero: indicates whether the first column originally
     * contains zero.
     *
     * 2. Check the first row and first column separately to determine
     * whether either must eventually be set entirely to zero.
     *
     * 3. Traverse the remaining matrix, starting from (1, 1).
     * If matrix[i][j] == 0, mark its row and column by setting:
     * - matrix[i][0] = 0
     * - matrix[0][j] = 0
     *
     * 4. Traverse the remaining matrix again.
     * If matrix[i][0] == 0 or matrix[0][j] == 0,
     * set matrix[i][j] = 0.
     *
     * 5. If firstRowZero is true, set every element in the first row
     * to zero.
     *
     * 6. If firstColZero is true, set every element in the first column
     * to zero.
     *
     * Pattern Insight:
     * The first row and first column act as marker storage.
     * This eliminates the need for an additional matrix or a special
     * integer marker.
     *
     * The first row and first column overlap at matrix[0][0], so two
     * separate boolean flags are needed to preserve their original states.
     *
     * Mistake I Made:
     * Initially, I tried marking cells with Integer.MIN_VALUE.
     * However, Integer.MIN_VALUE can be a legitimate input value, so
     * it cannot safely represent a cell that should become zero.
     *
     * The in-place marking technique avoids this issue by storing
     * row and column information in the first row and first column.
     *
     * Important Pitfalls:
     * 1. Record the original zero status of the first row and column
     * before modifying the matrix.
     * 2. Start the marking and updating passes at index 1 to avoid
     * prematurely overwriting the marker storage.
     * 3. Set the first row and column to zero only after processing
     * the remaining matrix.
     *
     * Time Complexity: O(n * m)
     * The matrix is traversed a constant number of times.
     *
     * Space Complexity: O(1)
     * Only two boolean flags and a constant number of loop variables
     * are used. The matrix itself stores the markers.
     */

    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check for zeros in the first row
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check for zeros in the first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark the affected rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero using the markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if required
        if (firstRowZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        // Zero out the first column if required
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        SetMatrixZeroes solution = new SetMatrixZeroes();

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 0, 6 },
                { 7, 8, 9 }
        };

        solution.setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }

        /*
         * Output:
         * [1, 0, 3]
         * [0, 0, 0]
         * [7, 0, 9]
         */
    }
}