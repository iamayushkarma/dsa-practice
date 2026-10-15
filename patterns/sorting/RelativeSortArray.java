package patterns.sorting;

/**
 * Problem: Relative Sort Array
 * LeetCode #: 1122
 * Link: https://leetcode.com/problems/relative-sort-array/
 * Pattern: Counting Sort / Frequency Array
 * Difficulty: Easy
 * Date Solved: 15-Oct-2026
 *
 * Revision:
 * [ ] Day 3
 * [ ] Day 7
 * [ ] Day 14
 *
 * My Approach:
 * - Find the maximum element in arr1 to determine the size of the frequency
 * array.
 * - Create a frequency array where freq[x] stores the number of occurrences of
 * x in arr1.
 * - Traverse arr1 and count the frequency of every element.
 * - Traverse arr2 in its given order:
 * - For each element, append all its occurrences to arr1.
 * - Decrease its frequency after placing each occurrence.
 * - Traverse the frequency array in ascending order:
 * - Append all remaining elements to arr1.
 * - This automatically places elements not present in arr2 in ascending order.
 * - Return the modified arr1.
 *
 * Why It Works:
 * - The first pass records the frequency of every element in arr1.
 * - Processing arr2 first guarantees that elements appearing in arr2
 * follow the exact relative order specified by arr2.
 * - Decreasing frequencies ensures that already placed elements are
 * not included again in the remaining elements.
 * - Scanning the frequency array in ascending order places all remaining
 * elements in ascending order.
 * - Every occurrence is written back exactly once, so the result contains
 * all elements of arr1 in the required order.
 *
 * Pattern Insight:
 * - Counting Sort is useful when the range of integer values is limited.
 * - A frequency array can replace comparison-based sorting when values
 * are non-negative integers within a manageable range.
 * - When a problem specifies a custom ordering, process that order first
 * and then handle the remaining elements separately.
 * - This approach avoids sorting the elements using comparisons.
 *
 * Mistake I Made:
 * - No specific implementation mistake was reported.
 * - Important pitfalls to remember:
 * - Do not forget to decrease the frequency after placing an element.
 * - Process arr2 before scanning the remaining frequencies.
 * - Ensure the frequency array is large enough for the maximum value.
 * - This implementation assumes arr1 contains non-negative integers.
 *
 * Time Complexity:
 * - Let n = arr1.length, m = arr2.length, and M = max(arr1).
 * - Finding the maximum: O(n)
 * - Building the frequency array: O(n)
 * - Processing arr2: O(m + n), because each occurrence is written once.
 * - Scanning the frequency array: O(M)
 * - Overall: O(n + m + M)
 *
 * Space Complexity:
 * - O(M) for the frequency array.
 * - The input array is modified in place.
 * - Auxiliary space: O(M).
 */

class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int max = 0;
        for (int num : arr1) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            freq[arr1[i]]++;
        }

        for (int j = 0; j < m; j++) {
            int el = arr2[j];

            while (freq[el] > 0) {
                arr1[idx++] = el;
                freq[el]--;
            }
        }

        for (int k = 0; k < max + 1; k++) {
            while (freq[k] > 0) {
                arr1[idx++] = k;
                freq[k]--;
            }
        }

        return arr1;
    }
}