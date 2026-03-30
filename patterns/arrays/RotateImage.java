public class RotateImage {
    /*
     * Problem : Rotate Image
     * LeetCode : #48
     * Link: https://leetcode.com/problems/rotate-image/description/
     * Pattern : 2D Array
     * Difficulty : Medium
     * Date Solved: 29-03-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * Optimal Approach:
     * First make transpose of the matrix, then reverse each row via for loop which
     * rotates the matrix by 90 degree
     *
     * Pattern Insight:
     * 2D Array
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */

    // > helper function
    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void reverseRow(int[] row) {
        int i = 0;
        int j = row.length - 1;

        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    public static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(arr, i, j);
            }
        }
    }

    // > Main function
    public static void rotateMatrix(int[][] arr) {
        transpose(arr);

        for (int[] row : arr) {
            reverseRow(row);
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        rotateMatrix(matrix);
        printMatrix(matrix);
    }
}
