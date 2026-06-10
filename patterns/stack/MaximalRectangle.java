package patterns.stack;

public class MaximalRectangle {

    /*
     * Problem : Maximal Rectangle
     * LeetCode : #85
     * Link: https://leetcode.com/problems/maximal-rectangle/
     * Pattern : Histogram + Monotonic Increasing Stack
     * Difficulty : Hard
     * Date Solved: 10-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Prerequisite:
     * Largest Rectangle in Histogram (#84)
     *
     * This problem is essentially an extension
     * of Largest Rectangle in Histogram.
     *
     * My Initial Thought:
     * Brute force every possible rectangle
     * consisting entirely of 1's.
     *
     * But checking all rectangles would require:
     *
     * O(n² * m²)
     *
     * which is far too slow.
     *
     * Key Observation:
     * Every row can be treated as the base
     * of a histogram.
     *
     * Example:
     *
     * Matrix:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Histogram heights after each row:
     *
     * Row 0:
     * [1,0,1,0,0]
     *
     * Row 1:
     * [2,0,2,1,1]
     *
     * Row 2:
     * [3,1,3,2,2]
     *
     * Row 3:
     * [4,0,0,3,0]
     *
     * For every row:
     * Compute Largest Rectangle in Histogram.
     *
     * The maximum among all rows becomes
     * the answer.
     *
     * Optimal Approach:
     *
     * Step 1:
     * Build histogram heights row by row.
     *
     * If matrix[i][j] == '1':
     *
     * heights[j] += 1
     *
     * If matrix[i][j] == '0':
     *
     * heights[j] = 0
     *
     * Step 2:
     * Treat current heights array as a histogram.
     *
     * Step 3:
     * Apply Largest Rectangle in Histogram (#84).
     *
     * Step 4:
     * Update global maximum area.
     *
     * Why it works:
     *
     * heights[j] represents the number of
     * consecutive 1's ending at the current row.
     *
     * Therefore every possible rectangle
     * ending at the current row is represented
     * inside the histogram.
     *
     * Finding the largest histogram rectangle
     * automatically finds the largest rectangle
     * of 1's ending at that row.
     *
     * Repeating for all rows guarantees that
     * the overall maximum rectangle is found.
     *
     * Pattern Insight:
     *
     * Whenever a matrix problem asks:
     * - Largest rectangle of 1's
     * - Maximum area rectangle
     * - Consecutive vertical accumulation
     *
     * Think:
     *
     * Convert rows into histograms
     * Then apply Largest Rectangle in Histogram.
     *
     * This is one of the most important
     * pattern transformations in DSA.
     *
     * Relation:
     *
     * #84 Largest Rectangle in Histogram
     * ↓
     * #85 Maximal Rectangle
     *
     * #85 is essentially #84 repeated
     * for every row.
     *
     * Mistakes I Made:
     *
     * - Initially thought matrix-specific logic
     * was required.
     *
     * - Didn't recognize that consecutive 1's
     * naturally form histogram heights.
     *
     * - Forgot that a '0' resets the height.
     *
     * - Focused on rectangles directly instead
     * of reducing the problem to #84.
     *
     * Optimization:
     *
     * Histogram area computation uses:
     *
     * int[] stack = new int[n + 1];
     *
     * instead of:
     *
     * Stack<Integer>
     *
     * Benefits:
     * - No autoboxing
     * - No unboxing
     * - Faster push/pop
     * - Lower memory usage
     *
     * Time Complexity:
     *
     * O(rows × cols)
     *
     * Building histogram:
     * O(rows × cols)
     *
     * Histogram area calculation:
     * O(cols) per row
     *
     * Total:
     * O(rows × cols)
     *
     * Space Complexity:
     *
     * O(cols)
     *
     * Histogram array + stack
     */

    // Given a binary matrix filled with
    // '0' and '1',
    // return the area of the largest rectangle
    // containing only 1's.

    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int val = matrix[i][j] - '0';

                if (val == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += val;
                }
            }

            maxArea = Math.max(
                    maxArea,
                    maxRowHistogramArea(heights));
        }

        return maxArea;
    }

    // Largest Rectangle in Histogram (#84)

    private static int maxRowHistogramArea(int[] row) {

        int n = row.length;

        int[] stack = new int[n + 1];
        int top = -1;

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : row[i];

            while (top != -1 &&
                    row[stack[top]] > currentHeight) {

                int height = row[stack[top--]];

                int previousSmaller = (top == -1)
                        ? -1
                        : stack[top];

                int width = i - previousSmaller - 1;

                maxArea = Math.max(maxArea,
                        height * width);
            }

            stack[++top] = i;
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        System.out.println(
                "Maximum Rectangle Area: "
                        + maximalRectangle(matrix));
    }
}