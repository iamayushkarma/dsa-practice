package patterns.string;

public class CompareVersionNumbers {

    /**
     * Problem: Compare Version Numbers
     * LeetCode Number: 165
     * Link: https://leetcode.com/problems/compare-version-numbers/
     * Pattern: String Manipulation / Two Pointers
     * Difficulty: Medium
     * Date Solved: 23-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Split both version strings using "." as the delimiter.
     * - Find the maximum number of revision components.
     * - Iterate through both arrays simultaneously.
     * - Convert each revision component into an integer.
     * - If one version has fewer components, treat missing components as 0.
     * - Compare corresponding revision values and return:
     * 1 if version1 is greater.
     * -1 if version2 is greater.
     * 0 if both versions are equal.
     *
     * Optimal Approach:
     * - Compare revision components without splitting the strings.
     * - Parse each component using two pointers.
     * - Avoid creating intermediate arrays.
     *
     * Pattern Insight:
     * - Version numbers must be compared component by component,
     * not as complete strings.
     * - Missing revision components are treated as zero.
     * - Leading zeros do not affect numeric comparison.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * n = length of version1, m = length of version2.
     */

    public static int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int n = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < n; i++) {

            int v1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int v2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;

            if (v1 > v2)
                return 1;
            if (v1 < v2)
                return -1;
        }

        return 0;
    }

    public static void main(String[] args) {

        assert compareVersion("1.01", "1.001") == 0;
        assert compareVersion("1.0", "1.0.0") == 0;
        assert compareVersion("0.1", "1.1") == -1;
        assert compareVersion("1.2", "1.10") == -1;
        assert compareVersion("1.0.1", "1") == 1;
        assert compareVersion("7.5.2.4", "7.5.3") == -1;

        System.out.println("All test cases passed!");
    }
}