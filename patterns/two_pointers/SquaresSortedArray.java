package patterns.two_pointers;

import java.util.Arrays;

public class SquaresSortedArray {
    /*
     * Problem : Squares of a Sorted Array
     * LeetCode : #977
     * Link: https://leetcode.com/problems/squares-of-a-sorted-array/description
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 09-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First idea was to square all elements and then sort the array.
     * This works but takes O(n log n) due to sorting.
     *
     * Optimal Approach:
     * Use two pointers (i at start, j at end).
     * Since the array is sorted, the largest square will come from either:
     * - the most negative number (left side)
     * - or the largest positive number (right side)
     *
     * Compare squares of both ends and place the larger one at the end of result
     * array.
     * Move the corresponding pointer inward and continue.
     *
     * Pattern Insight:
     * This is a Two Pointer problem because:
     * - Input array is sorted
     * - We need to process from both ends
     * - We are selecting the "best candidate" (largest square) at each step
     *
     * Trigger:
     * "Sorted array + transformation (square) breaks order"
     * → Think: can I use two pointers instead of sorting again?
     *
     * Mistake I Made:
     * Initially used sorting → O(n log n)
     * Also earlier mistake:
     * - Used incorrect conditions (else if)
     * - Forgot pointer movement (i++, j--)
     * - Didn’t always fill result index (k--)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (for result array)
     */
    public static int[] squaresSortedArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int k = n - 1;

        while (i <= j) {
            int sqi = arr[i] * arr[i];
            int sqj = arr[j] * arr[j];

            if (sqi > sqj) {
                res[k--] = sqi;
                i++;
            } else {
                res[k--] = sqj;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        System.out.println("Square of sorted array are: " + Arrays.toString(squaresSortedArray(arr)));
    }
}
