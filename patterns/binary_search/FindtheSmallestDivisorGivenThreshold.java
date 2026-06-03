package patterns.binary_search;

public class FindtheSmallestDivisorGivenThreshold {
    /*
     * Problem : Find the Smallest Divisor Given a Threshold
     * LeetCode : #1283
     * Link:
     * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
     * Pattern : Binary Search on Answer
     * Difficulty : Medium
     * Date Solved: 03-06-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Binary Search on the divisor.
     *
     * - The minimum possible divisor is 1.
     *
     * - The maximum possible divisor is the largest
     * element in the array because any divisor larger
     * than the maximum element produces the same result
     * as dividing by the maximum element.
     *
     * - Binary search between [1, maxNum].
     *
     * - For each divisor (mid):
     * Calculate the sum of:
     *
     * sum += ceil(num / divisor)
     *
     * for every element in the array.
     *
     * - If the calculated sum <= threshold:
     * This divisor works, so try finding a
     * smaller valid divisor.
     *
     * - Otherwise:
     * The divisor is too small, causing the sum
     * to exceed the threshold. Search right.
     *
     * Why It Works:
     * If a divisor D satisfies the threshold,
     * then every divisor greater than D will
     * also satisfy it because increasing the
     * divisor decreases each ceiling division value.
     *
     * This creates a monotonic search space:
     *
     * Invalid -> Invalid -> Valid -> Valid
     *
     * which allows Binary Search on the answer.
     *
     * Pattern Insight:
     * Binary Search on Answer.
     *
     * Instead of searching for an index,
     * search for the minimum divisor that
     * satisfies the given condition.
     *
     * Key observation:
     * As the divisor increases,
     * the total calculated sum decreases.
     *
     * Mistakes I Made:
     * - Used Math.ceil((double)num / mid),
     * which was slower than integer arithmetic.
     *
     * - Learned that:
     *
     * (num + mid - 1) / mid
     *
     * directly computes ceil(num / mid)
     * using integers.
     *
     * - Initially used '%' (modulo) while
     * experimenting with the calculation,
     * which was incorrect.
     *
     * - Forgot that even after finding a
     * valid divisor, a smaller valid divisor
     * might still exist.
     *
     * - Learned to use long for the accumulated
     * sum to avoid overflow on large test cases.
     *
     * Time Complexity: O(n * log(maxNum))
     * Space Complexity: O(1)
     */

    // Given an array of integers nums and an integer threshold,
    // return the smallest divisor such that the result of
    // summing ceil(nums[i] / divisor) for all elements
    // is less than or equal to threshold.
    //
    // Helper function
    public static long findSmallestDivisor(int[] nums, int mid) {
        long threshold = 0;
        System.out.println("mid: " + mid);
        for (int num : nums) {
            threshold += (num + mid - 1) / mid;
        }
        return threshold;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long value = findSmallestDivisor(nums, mid);
            System.out.println("value: " + value);
            if (value <= threshold)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 50, 11, 75, 57, 12, 73, 4, 69, 78 };
        int threshold = 649;

        System.out.println(
                "the smallest divisor such that the result mentioned above is less than or equal to threshold is: "
                        + smallestDivisor(arr,
                                threshold));
    }
}