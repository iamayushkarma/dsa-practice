package patterns.two_pointers;

public class TrappingRainWater {
    /*
     * Problem : Trapping Rain Water
     * LeetCode : #42
     * Link: https://leetcode.com/problems/trapping-rain-water/description/
     * Pattern : Two Pointers
     * Difficulty : Hard
     * Date Solved: 04-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was brute force:
     * For every index, find the highest bar on left and right,
     * then water = min(leftMax, rightMax) - height[i].
     * This takes O(n^2) time.
     *
     * Optimal Approach (Two Pointers):
     * 1. Take two pointers:
     * - left at start
     * - right at end
     * 2. Keep track of:
     * - leftMax → max height from left
     * - rightMax → max height from right
     * 3. Compare leftMax and rightMax:
     * - If leftMax < rightMax:
     * water += leftMax - height[left]
     * move left++
     * - Else:
     * water += rightMax - height[right]
     * move right--
     * 4. Repeat until left < right
     *
     * Pattern Insight:
     * Two Pointers
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    // Given n non-negative integers representing an elevation map where the width
    // of each bar is 1, compute how much water it can trap after raining.

    public static int trappingRainWater(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int volume = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);

            if (leftMax < rightMax) {
                volume += leftMax - arr[left];
                left++;
            } else {
                volume += rightMax - arr[right];
                right--;
            }
        }

        return volume;
    }

    public static void main(String[] args) {
        // int[] hights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] hights = { 4, 2, 3 };
        System.out.println("Maximum amount of water that can stored: " + trappingRainWater(hights));
    }

}
