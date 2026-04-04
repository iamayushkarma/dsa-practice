package patterns.two_pointers;

public class ContainerWithMostWater {
    /*
     * Problem : Container With Most Water
     * LeetCode : #11
     * Link: https://leetcode.com/problems/container-with-most-water/
     * Pattern : Two Pointers
     * Difficulty : Medium
     * Date Solved: 04-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * /*
     * My Approach:
     * First thought was brute force — try all pairs (i, j)
     * and calculate area = min(height[i], height[j]) * (j - i).
     * This takes O(n^2) time and is too slow for large inputs.
     *
     * Then moved to a two-pointer approach:
     * Start with left = 0 and right = n - 1 and try to maximize area.
     * 
     * Optimal Approach:
     * 1. Place two pointers:
     * - left at start
     * - right at end
     * 2. Calculate area using current pair.
     * 3. Move the pointer pointing to the smaller height:
     * - If height[left] < height[right] → left++
     * - Else → right--
     * 4. Repeat until left < right.
     * 
     * Pattern Insight:
     * Two Pointers (Greedy decision making)
     * Always move the pointer at the smaller height to try for a better area.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     */
    // You are given an array where each value represents the height of a vertical
    // line drawn at that position. By choosing any two of these lines, you can form
    // a container with the x-axis, where the amount of water it can hold depends on
    // the shorter of the two lines and the distance between them. Your task is to
    // determine the pair of lines that can hold the maximum amount of water and
    // return that maximum value.

    public static int containerWithMostWater(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int volume = 0;
        while (i < j) {
            int h = Math.min(arr[i], arr[j]);
            int w = j - i;
            int currentVol = h * w;
            volume = Math.max(volume, currentVol);

            if (arr[i] > arr[j])
                j--;
            else
                i++;
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] hights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] hights = { 8, 7, 2, 1 };
        System.out.println("Maximum amount of water that can stored: " + containerWithMostWater(hights));
    }

}
