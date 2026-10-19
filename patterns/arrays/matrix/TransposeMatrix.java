package patterns.arrays.matrix;

public class TransposeMatrix {

    /*
     * Problem : Transpose Matrix
     * LeetCode : 867
     * Link: https://leetcode.com/problems/transpose-matrix/
     * Pattern : Matrix Manipulation (Row-Column Transformation)
     * Difficulty : Easy
     * Date Solved: 19-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * The transpose of a matrix is obtained by swapping its rows and columns.
     *
     * If the original matrix has n rows and m columns, the transposed
     * matrix will have m rows and n columns.
     *
     * Steps:
     * 1. Calculate the number of rows (n) and columns (m) in the original matrix.
     * 2. Create a result matrix of dimensions m x n.
     * 3. Traverse every element of the original matrix using nested loops.
     * 4. Assign each element matrix[i][j] to res[j][i].
     * 5. Return the transposed matrix.
     *
     * Pattern Insight:
     * Transposing a matrix means swapping the row and column indices.
     *
     * matrix[i][j] -> res[j][i]
     *
     * The dimensions must also be swapped. An n x m matrix becomes
     * an m x n matrix.
     *
     * This approach works for both square and rectangular matrices.
     *
     * Mistake I Made:
     * No specific mistake was reported in the original solution.
     *
     * Important Pitfall:
     * Creating the result matrix with dimensions n x m instead of m x n
     * will cause incorrect results or index-out-of-bounds errors for
     * rectangular matrices.
     *
     * Time Complexity: O(n * m)
     * Every element of the original matrix is visited exactly once.
     *
     * Space Complexity: O(n * m)
     * The result matrix contains m * n elements.
     */

    public int[][] transpose(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        TransposeMatrix solution = new TransposeMatrix();

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] result = solution.transpose(matrix);

        for (int[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }

        /*
         * Output:
         * [1, 4]
         * [2, 5]
         * [3, 6]
         */
    }
}