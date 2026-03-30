import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
     * Problem : Product of array except self
     * LeetCode : #238
     * Link: https://leetcode.com/problems/product-of-array-except-self/description/
     * Pattern : Prefixsum
     * Difficulty : Medium
     * Date Solved: 26-03-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First i tryed to use two loops and inside loop skip if i and j are equal it
     * was optimised for space complixity but worst for time complexity, then i
     * optimised it to solve via prefix and suffix product
     *
     * Optimal Approach:
     * Using prefix and suffix product
     *
     * Pattern Insight:
     * Prefixsum
     *
     * Time Complexity: O(2N)
     * Space Complexity: O(1) (The output array does not count as extra space for
     * space complexity analysis.)
     */

    // Given an array nums, return an array where each element is the product of all
    // other elements except itself, in O(n) time without using division.

    // - Optimal approch
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = 1;
        int multiplyer = 1;

        // > multipy prefix product to ans arrays
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
        }
        // > multiply suffix product to ans array

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= multiplyer;
            multiplyer *= arr[i];
        }
        return ans;
    }

    // - Burte force approch
    // public static int[] productExceptSelf(int[] arr) {
    // int n = arr.length;
    // int[] ans = new int[n];

    // for (int i = 0; i < n; i++) {
    // int product = 1;
    // for (int j = 0; j < n; j++) {
    // if (i == j)
    // continue;
    // product *= arr[j];
    // }
    // ans[i] = product;
    // }
    // return ans;
    // }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println("Product of array is: " + Arrays.toString(productExceptSelf(arr)));
    }

}
