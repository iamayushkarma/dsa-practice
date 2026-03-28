import java.util.Arrays;

public class NextPermutation {
    /*
     * Problem : Next Permutation
     * LeetCode : 31
     * Link: https://leetcode.com/problems/next-permutation/description/
     * Pattern : Greedy / Array Manipulation
     * Difficulty : Medium
     * Date Solved: 28-03-2026
     * Revision : [] Day3 [ ] Day7 [ ] Day14
     *
     * Optimal Approach:
     * 1. Traverse from right and find first decreasing element (pivot)
     * 2. Find next greater element from right and swap with pivot
     * 3. Reverse the suffix (right part) to get next smallest order
     *
     * Pattern Insight:
     * Greedy / Array Manipulation
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    // Given an integer array, rearrange it to produce the next lexicographically
    // greater permutation. If such a permutation exists, return it; otherwise,
    // rearrange the array into its smallest (ascending) order. The modification
    // must be done in-place using only constant extra space.

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;
        // Finding pivot - the point where next element for the backword traversal is
        // smaller then its previous
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        // Swiping the value of pivot to its next grater number brom back of array
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }
        // reversing the last elements to form the next premutation
        reverse(arr, pivot + 1, n - 1);
    }

    // > Helper function
    public static void swap(int[] arr, int value1, int value2) {
        int temp = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = temp;
    }

    public static void reverse(int[] arr, int st, int end) {
        while (st <= end) {
            swap(arr, st, end);
            st++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 4 };
        nextPermutation(arr);
        System.out.println("Next permutation of array is: " + Arrays.toString(arr));
    }

}
