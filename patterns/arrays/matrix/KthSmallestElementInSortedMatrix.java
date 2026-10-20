package patterns.arrays.matrix;

public class KthSmallestElementInSortedMatrix {

    /*
     * Problem : Kth Smallest Element in a Sorted Matrix
     * LeetCode : 378
     * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
     * Pattern : Binary Search on Answer + Binary Search in Rows
     * Difficulty : Medium
     * Date Solved: 20-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * The matrix is sorted in ascending order both row-wise and column-wise.
     * Instead of searching for the kth smallest element directly, we binary
     * search over the range of possible element values.
     *
     * Steps:
     * 1. Initialize min with the smallest element, matrix[0][0].
     * 2. Initialize max with the largest element, matrix[n-1][m-1].
     * 3. Calculate mid = min + (max - min) / 2.
     * 4. Use calculatePossibleValue() to count the number of elements
     * less than or equal to mid.
     * 5. For each row, apply binary search to count elements <= mid.
     * When the search ends, st represents the number of elements
     * in that row that are <= mid.
     * 6. If the total count is less than k, the kth smallest element
     * must be greater than mid, so update min = mid + 1.
     * 7. Otherwise, the kth smallest element is <= mid, so update max = mid - 1.
     * 8. When the binary search terminates, min contains the kth smallest value.
     *
     * Pattern Insight:
     * This problem uses Binary Search on Answer.
     *
     * Instead of searching for an element by its index, search over the
     * possible values and determine how many matrix elements are <= mid.
     *
     * The count is monotonic:
     * - As mid increases, the number of elements <= mid never decreases.
     * - If fewer than k elements are <= mid, the answer must be larger.
     * - If at least k elements are <= mid, the answer is at most mid.
     *
     * Binary search within each row efficiently counts elements <= mid
     * because every row is sorted.
     *
     * Mistake I Made:
     * No specific mistake was reported in the corrected implementation.
     *
     * Important Pitfalls:
     * 1. Compare row[m] with mid, not with m (the index).
     * 2. The helper must count elements <= mid, not elements < mid.
     * 3. For a single-row matrix, returning matrix[0][0] is incorrect
     * when k > 1. The binary-search algorithm handles this case
     * without a special condition.
     *
     * Time Complexity:
     * O(n * log(m) * log(maxValue - minValue + 1))
     *
     * n = number of rows, m = number of columns.
     * Each outer binary-search iteration performs a binary search
     * on every row.
     *
     * Space Complexity: O(1)
     * Only a constant number of additional variables are used.
     */

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int min = matrix[0][0];
        int max = matrix[n - 1][m - 1];

        while (min <= max) {

            int mid = min + (max - min) / 2;

            int possibleVal = calculatePossibleValue(matrix, mid);

            if (possibleVal < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }

    public int calculatePossibleValue(int[][] matrix, int mid) {

        int countOfSmallestNumbers = 0;

        for (int i = 0; i < matrix.length; i++) {

            int[] row = matrix[i];

            int st = 0;
            int end = row.length - 1;

            while (st <= end) {

                int m = st + (end - st) / 2;

                if (row[m] <= mid) {
                    st = m + 1;
                } else {
                    end = m - 1;
                }
            }

            countOfSmallestNumbers += st;
        }

        return countOfSmallestNumbers;
    }

    public static void main(String[] args) {

        KthSmallestElementInSortedMatrix solution = new KthSmallestElementInSortedMatrix();

        int[][] matrix = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };

        int k = 8;

        System.out.println(solution.kthSmallest(matrix, k));

        // Output: 13
    }
}