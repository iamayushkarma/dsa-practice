package patterns.binary_search;

public class SplitArrayLargestSum {
    /*
     * Problem : Split Array Largest Sum
     * LeetCode : #410
     * Link:
     * https://leetcode.com/problems/split-array-largest-sum/
     * Pattern : Binary Search on Answer
     * Difficulty : Hard
     * Date Solved: 03/06/2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Binary Search on the answer space.
     *
     * - The minimum possible answer is the largest element
     * in the array because a subarray must contain at least
     * one element.
     *
     * - The maximum possible answer is the total sum of the
     * array because one subarray can contain all elements.
     *
     * - Binary search between [maxElement, totalSum].
     *
     * - For each mid value:
     * Assume mid is the maximum allowed subarray sum.
     *
     * - Greedily form subarrays:
     * - Keep adding elements while sum <= mid.
     * - If adding an element exceeds mid,
     * start a new subarray.
     *
     * - Count how many subarrays are needed.
     *
     * - If required subarrays > k:
     * mid is too small, search right.
     *
     * - Otherwise:
     * mid is a valid answer, search left
     * for a smaller valid maximum sum.
     *
     * Why It Works:
     * If a maximum subarray sum 'mid' is possible,
     * then any value greater than 'mid' is also possible.
     *
     * This creates a monotonic search space:
     *
     * Impossible -> Impossible -> Possible -> Possible
     *
     * which makes Binary Search applicable.
     *
     * Pattern Insight:
     * Binary Search on Answer.
     *
     * Instead of searching an index,
     * search the minimum valid answer.
     *
     * Key observation:
     * As the allowed maximum sum increases,
     * the number of required partitions decreases.
     *
     * Mistakes I Made:
     * - Started low with the smallest element instead of
     * the largest element.
     *
     * - Tried calculating the actual largest partition sum
     * inside the helper function.
     *
     * - Forgot that the helper only needs to return
     * the number of partitions required.
     *
     * - Overcomplicated the solution using partition lengths,
     * indices, and extra variables.
     *
     * Time Complexity: O(n * log(sum))
     * Space Complexity: O(1)
     */

    // Split the array into exactly k non-empty subarrays
    // such that the largest subarray sum is minimized.
    // Return that minimized largest sum.
    public static int countPartitions(int[] nums, int maxAllowedSum) {
        int partitions = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= maxAllowedSum) {
                sum += num;
            } else {
                partitions++;
                sum = num;
            }
        }

        return partitions;
    }

    public static int splitArray(int[] nums, int k) {
        int smallest_number = Integer.MIN_VALUE, totalSum = 0;
        for (int numbers : nums) {
            totalSum += numbers;
            smallest_number = Math.max(smallest_number, numbers);
        }
        int low = smallest_number;
        int high = totalSum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int partitions = countPartitions(nums, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println("Minimized largest sum of the split is: " + splitArray(arr, k));
    }
}