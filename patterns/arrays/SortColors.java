package patterns.arrays;

import java.util.Arrays;

public class SortColors {
    /*
     * Problem : Sort Colors
     * LeetCode : #75
     * Link: https://leetcode.com/problems/sort-colors/description/
     * Pattern : Dutch National Flag (3-pointer)
     * Difficulty : Medium
     * Date Solved: 26-03-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Dutch National Flag algorithm with 3 pointers (low, mid, high)
     * to partition the array into 0s, 1s, and 2s in a single pass.
     * 
     * Optimal Approach:
     * Dutch National Flag (3-pointer)
     *
     * Pattern Insight:
     * Two Pointers (variation of 3 pointers)
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    // Sort an array of 0s, 1s, and 2s (red, white, blue) in-place so that same
    // values are grouped in order 0 → 1 → 2, without using any built-in sort
    // function.

    public static int[] sortColors(int[] arr) {
        int n = arr.length;
        int high = n - 1;
        int mid = 0;
        int low = 0;

        while (mid <= high) {

            switch (arr[mid]) {
                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;

                default:
                    break;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Sorted array is: " + Arrays.toString(sortColors(arr)));
    }
}
