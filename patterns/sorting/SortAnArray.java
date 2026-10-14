package patterns.sorting;

import java.util.*;

public class SortAnArray {

    /*
     * ============================================================
     * Problem : Sort an Array
     * LeetCode : #912
     * Link : https://leetcode.com/problems/sort-an-array/
     * Pattern : Divide and Conquer + Merge Sort
     * Difficulty : Medium
     * Date Solved: 14-Oct-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * ============================================================
     * My Approach:
     *
     * - Used Merge Sort to sort the given array.
     *
     * - Divided the array into two halves using the middle index.
     *
     * - Recursively sorted the left and right halves.
     *
     * - Merged both sorted halves into a temporary array.
     *
     * - Compared the elements from both halves and added the
     * smaller element to the temporary array.
     *
     * - Added any remaining elements from either half.
     *
     * - Copied the merged elements back into the original array
     * using the starting index of the current subarray.
     *
     * - Repeated this process until the entire array was sorted.
     *
     * ============================================================
     * Why It Works:
     *
     * - An array containing zero or one element is already sorted.
     *
     * - Dividing the array creates smaller subproblems that can
     * be solved recursively.
     *
     * - After the recursive calls, both halves are sorted.
     *
     * - The merge() method combines the two sorted halves into
     * one sorted subarray.
     *
     * - The temporary array stores the merged elements in sorted
     * order before copying them back into the original array.
     *
     * - Each recursive level processes O(n) elements, and the
     * recursion has O(log n) levels.
     *
     * - Therefore, the overall time complexity is O(n log n).
     *
     * ============================================================
     * Pattern Insight:
     *
     * - Use Divide and Conquer when a problem can be divided into
     * smaller subproblems of the same type.
     *
     * - Merge Sort divides the array into two halves until each
     * subarray contains at most one element.
     *
     * - The key observation is that two sorted arrays can be
     * merged into a single sorted array in linear time.
     *
     * - The main steps are:
     * Divide -> Recursively Sort -> Merge.
     *
     * - Merge Sort guarantees O(n log n) time complexity in the
     * best, average, and worst cases.
     *
     * - Using <= when comparing elements from the two halves
     * preserves the relative order of equal elements, making
     * this implementation stable.
     *
     * ============================================================
     * Mistake I Made:
     *
     * - No specific implementation mistake was reported for
     * this solution.
     *
     * - Potential pitfalls to remember:
     *
     * - Forgetting the base case st >= end can cause infinite
     * recursion.
     *
     * - Incorrectly calculating mid can create invalid ranges.
     *
     * - Forgetting to merge after sorting both halves leaves
     * the current subarray unsorted.
     *
     * - Using arr[k] instead of arr[k + st] when copying the
     * temporary array back overwrites incorrect positions.
     *
     * - Forgetting to copy the merged elements back into the
     * original array prevents the sorting result from being
     * preserved.
     *
     * ============================================================
     * Time Complexity:
     *
     * - Best Case: O(n log n)
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     *
     * - Each level of recursion processes O(n) elements.
     *
     * - The number of recursion levels is O(log n).
     *
     * - Therefore, the total time complexity is O(n log n).
     *
     * ============================================================
     * Space Complexity: O(n)
     *
     * - Temporary arrays require O(n) auxiliary space.
     *
     * - The recursion stack requires O(log n) additional space.
     *
     * - The O(n) temporary-array space dominates the recursion
     * stack space, so the total auxiliary space is O(n).
     *
     * ============================================================
     */

    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergeSort(nums, 0, n - 1);

        return nums;
    }

    public void mergeSort(int[] arr, int st, int end) {
        if (st >= end) {
            return;
        }

        int mid = st + (end - st) / 2;

        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, st, mid, end);
    }

    public void merge(int[] arr, int st, int mid, int end) {
        int[] res = new int[end - st + 1];
        int idx = 0;

        int i = st;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                res[idx++] = arr[i++];
            } else {
                res[idx++] = arr[j++];
            }
        }

        while (i <= mid) {
            res[idx++] = arr[i++];
        }

        while (j <= end) {
            res[idx++] = arr[j++];
        }

        for (int k = 0; k < res.length; k++) {
            arr[k + st] = res[k];
        }
    }

    public static void main(String[] args) {
        SortAnArray solution = new SortAnArray();

        int[] nums = { 5, 2, 3, 1 };

        System.out.println(
                Arrays.toString(solution.sortArray(nums))); // [1, 2, 3, 5]
    }
}