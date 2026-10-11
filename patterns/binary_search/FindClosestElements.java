package patterns.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestElements {
    /*
     * Problem : Find K Closest Elements
     * LeetCode : #658
     * Link:
     * https://leetcode.com/problems/find-k-closest-elements/
     *
     * Pattern : Binary Search + Two Pointers
     * Difficulty : Medium
     * Date Solved: 11-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     *
     * Used binary search to find the insertion position of x.
     *
     * - Initialize start and end pointers in binary search.
     * - Find the position where x exists or should be inserted.
     * - Initialize two pointers around that position.
     * - Compare the distances of the elements at both pointers
     * from x.
     * - Select the element with the smaller distance.
     * - If distances are equal, select the smaller element.
     * - Move the corresponding pointer.
     * - Continue until k elements are selected or one side
     * of the array is exhausted.
     * - Collect the remaining elements from the other side.
     * - Sort the result in ascending order.
     *
     * Why It Works:
     *
     * The input array is sorted, so the closest candidates
     * around the insertion position can be explored using
     * two pointers.
     *
     * - The left pointer moves towards smaller elements.
     * - The right pointer moves towards larger elements.
     * - Comparing absolute distances helps select the closer
     * element.
     * - When distances are equal, selecting the smaller element
     * satisfies the problem's tie-breaking rule.
     * - Once k elements are selected, sorting the result
     * produces the required ascending order.
     *
     * Pattern Insight:
     *
     * Binary search can locate the position around which
     * the closest elements are likely to be found.
     *
     * Two pointers can then expand outwards from that position.
     *
     * However, this approach requires careful handling of
     * pointer boundaries and duplicate values.
     *
     * An alternative approach uses binary search to find
     * the starting index of a window containing k consecutive
     * elements. This avoids manually expanding two pointers.
     *
     * Mistake I Made:
     *
     * - Initialized both pointers at incorrect positions
     * when x was near an array boundary.
     * - Calculated distances using incorrect expressions
     * instead of comparing absolute differences.
     * - Used incorrect boundary conditions when one pointer
     * moved outside the array.
     * - Initially used k + 1 instead of k as the selection limit.
     * - Forgot that Collections.sort(res) returns void.
     * - Needed to sort the final result in ascending order.
     *
     * Time Complexity:
     *
     * Binary Search: O(log n)
     * Selecting k elements: O(k)
     * Sorting the result: O(k log k)
     *
     * Overall: O(log n + k log k)
     *
     * Space Complexity: O(k)
     *
     */

    // Given a sorted array, return the k elements
    // closest to x in ascending order.

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        int closest = findClosestNumber(arr, x);

        int i = closest - 1;
        int j = closest;

        while (res.size() < k && i >= 0 && j < n) {

            int num1 = arr[i];
            int num2 = arr[j];

            int close = findClosest(num1, num2, x);

            res.add(close);

            if (close == num1)
                i--;
            else
                j++;
        }

        if (i < 0) {
            while (j < n && res.size() < k) {
                res.add(arr[j++]);
            }
        } else if (j >= n) {
            while (i >= 0 && res.size() < k) {
                res.add(arr[i--]);
            }
        }

        Collections.sort(res);

        return res;
    }

    public static int findClosestNumber(int[] arr, int x) {

        int n = arr.length;
        int st = 0, end = n - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                end = mid - 1;
            else
                st = mid + 1;
        }

        return st;
    }

    public static int findClosest(int i, int j, int x) {

        int dif1 = Math.abs(x - i);
        int dif2 = Math.abs(j - x);

        if (dif1 <= dif2)
            return i;
        else
            return j;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 1;

        System.out.println(
                "Closest Elements: " + findClosestElements(arr, k, x));
    }

}
