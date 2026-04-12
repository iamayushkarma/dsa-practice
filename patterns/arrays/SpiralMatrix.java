package patterns.arrays;

import java.util.*;

public class SpiralMatrix {
    /*
     * Problem : Spiral Matrix
     * LeetCode : 54
     * Link: https://leetcode.com/problems/spiral-matrix/
     * Pattern : Matrix Traversal (Boundary Simulation)
     * Difficulty : Medium
     * Date Solved: 06-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used boundary pointers (top, bottom, left, right)
     * and traversed layer by layer in spiral order.
     *
     * Pattern Insight:
     * Simulation + Controlled traversal using boundaries
     *
     * Mistake I Made:
     * Initially tried using two pointers (i, j) without clear direction logic.
     * Spiral problems require boundary shrinking, not simple pointer movement.
     *
     * Time Complexity: O(m × n)
     * Space Complexity: O(1) (excluding output list)
     */
    // Given an m x n matrix, return all elements of the matrix in spiral order.
    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int c1 = 0;
        int cn = matrix[0].length - 1;
        int r1 = 0;
        int rn = matrix.length - 1;

        while (r1 <= rn && c1 <= cn) {

            // Top row
            for (int i = c1; i <= cn; i++) {
                list.add(matrix[r1][i]);
            }
            r1++;

            // Right column
            for (int i = r1; i <= rn; i++) {
                list.add(matrix[i][cn]);
            }
            cn--;

            // Bottom row
            if (r1 <= rn) {
                for (int i = cn; i >= c1; i--) {
                    list.add(matrix[rn][i]);
                }
                rn--;
            }

            // Left column
            if (c1 <= cn) {
                for (int i = rn; i >= r1; i--) {
                    list.add(matrix[i][c1]);
                }
                c1++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        System.out.println("Spiral matrix is: " + spiralMatrix(matrix));
    }
}