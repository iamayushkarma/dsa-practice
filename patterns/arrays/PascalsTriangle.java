package patterns.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /*
     * Problem : Pascal's Triangle
     * LeetCode : #118
     * Link: https://leetcode.com/problems/pascals-triangle/description/
     * Pattern : Dynamic Programming (Row Building)
     * Difficulty : Easy
     * Date Solved: 25-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * brute force approach would be to compute each value using the binomial
     * coefficient formula C(i, j) = i! / (j! * (i-j)!) directly, but factorials
     * grow fast and this recomputes a lot of overlapping work.
     *
     * Optimal Approach:
     * build the triangle row by row. For row i, the first and last elements
     * (j == 0 or j == i) are always 1. Every other element at position j is
     * the sum of the two elements above it from the previous row:
     * ans.get(i-1).get(j-1) + ans.get(i-1).get(j). Since each row only depends
     * on the row directly above it, we can build the whole structure in a
     * single pass with simple nested loops.
     *
     * Pattern Insight:
     * classic bottom-up DP where the "table" itself (the triangle) is the
     * answer being returned - each new row is derived purely from the
     * previously computed row, no extra state needed.
     *
     * Mistake I Made:
     * tried indexing ans.get(i).get(j-1) etc before the current row was fully
     * built - need to be careful that we always look at the previous row
     * (i-1), not the row currently being constructed.
     *
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(numRows^2) (for the output triangle itself)
     */
    // Given an integer numRows, return the first numRows of Pascal's triangle.
    // Each number is the sum of the two numbers directly above it.
    // - Optimal Approach
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    // - Brute Force Approach (using factorial / binomial coefficient)
    // public static List<List<Integer>> generateBrute(int numRows) {
    // List<List<Integer>> ans = new ArrayList<>();
    // for (int i = 0; i < numRows; i++) {
    // List<Integer> row = new ArrayList<>();
    // for (int j = 0; j <= i; j++) {
    // row.add((int) binomialCoefficient(i, j));
    // }
    // ans.add(row);
    // }
    // return ans;
    // }
    // private static long binomialCoefficient(int n, int k) {
    // long res = 1;
    // for (int x = 0; x < k; x++) {
    // res = res * (n - x) / (x + 1);
    // }
    // return res;
    // }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println("Pascal's Triangle: " + generate(numRows));
    }
}