package patterns.two_pointers;

public class SortArrayByParity {

    /**
     * Problem : Sort Array By Parity
     * LeetCode : #905
     * Link: https://leetcode.com/problems/sort-array-by-parity/
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 24-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     *
     * My Approach:
     * I used two pointers to partition the array based on parity.
     *
     * Pointer left starts from the beginning of the array and
     * pointer right starts from the end.
     *
     * The goal is to move all even numbers toward the left side
     * and all odd numbers toward the right side.
     *
     *
     * Optimal Approach:
     * 1. Place left at the beginning of the array.
     * 2. Place right at the end of the array.
     * 3. If nums[left] is even, it is already in the correct
     * region, so move left forward.
     * 4. If nums[right] is odd, it is already in the correct
     * region, so move right backward.
     * 5. If nums[left] is odd and nums[right] is even, swap them.
     * 6. Move both pointers after the swap.
     * 7. Continue until left and right meet.
     *
     *
     * Pattern Insight:
     * Two Pointers + In-Place Partitioning
     *
     *
     * The key idea is:
     * We don't need to sort the entire array.
     *
     * We only need to partition the array so that:
     *
     * [ even numbers | odd numbers ]
     *
     * The relative order of the elements does not matter.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given an integer array nums, move all the even integers
    // to the beginning of the array followed by all the odd
    // integers.
    //
    // The relative order of the even and odd elements does not
    // need to be maintained.
    //
    // Return any array that satisfies this condition.

    public static int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (isEven(nums[left])) {
                left++;
            } else if (!isEven(nums[right])) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return nums;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = { 3, 1, 2, 4 };

        int[] result = sortArrayByParity(nums);

        System.out.print("Sorted by parity: ");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}