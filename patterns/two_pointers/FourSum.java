package patterns.two_pointers;

import java.util.*;

public class FourSum {
    /*
     * Problem : 4Sum
     * LeetCode : #18
     * Link: https://leetcode.com/problems/4sum/
     * Pattern : Two Pointers + Sorting
     * Difficulty : Medium
     * Date Solved: 08-Apr-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was brute force using 4 loops to check all combinations,
     * but that gives O(n^4) time which is too slow.
     *
     * Then optimized by sorting the array and fixing two elements (i, j),
     * and using two pointers (p, q) to find the remaining two numbers.
     *
     * Optimal Approach:
     * 1. Sort the array.
     * 2. Fix first element (i).
     * 3. Fix second element (j).
     * 4. Use two pointers:
     * - p = j + 1
     * - q = n - 1
     * 5. If sum == target → store quadruplet and move both pointers
     * 6. If sum < target → p++
     * 7. If sum > target → q--
     * 8. Skip duplicates for i, j, p, q to avoid repeated answers
     *
     * Pattern Insight:
     * Extension of 3Sum → 2 loops + 2 pointers
     *
     * Mistake I Made:
     * - Used wrong duplicate conditions (j > i instead of j > i+1)
     * - Wrong pointer conditions (p < j instead of p < q)
     * - Integer overflow (used int instead of long)
     * - Skipped duplicates at wrong place
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1) (excluding result list)
     */

    // Find all unique quadruplets in the array whose sum equals target
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int p = j + 1;
                int q = n - 1;
                while (p < q) {
                    int sum = arr[i] + arr[j] + arr[p] + arr[q];
                    if (sum < target)
                        p++;
                    else if (sum > target)
                        q--;
                    else {
                        list.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[p], arr[q])));
                        p++;
                        q--;
                        while (p < q && arr[p] == arr[p - 1])
                            p++;
                        while (p < q && arr[q] == arr[q + 1])
                            q--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] arr) {
        int[] ans = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println("Quadruplets whose sum is 0, are: " + fourSum(ans, target));
    }
}
