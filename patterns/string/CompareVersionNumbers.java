package patterns.string;

public class CompareVersionNumbers {

    /**
     * Problem: Compare Version Numbers
     * LeetCode Number: 165
     * Link: https://leetcode.com/problems/compare-version-numbers/
     * Pattern: Two Pointers / String Traversal
     * Difficulty: Medium
     * Date Solved: 23-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Use two pointers to traverse both version strings.
     * - Extract each revision number digit by digit.
     * - Build the integer value using:
     * num = num * 10 + (digit - '0')
     * - Compare corresponding revision numbers.
     * - Treat missing revision numbers as zero.
     * - Return 1, -1, or 0 based on the comparison.
     *
     * Optimal Approach:
     * - Use two pointers to parse revision numbers directly.
     * - Avoid split(), intermediate arrays, and additional strings.
     *
     * Pattern Insight:
     * - Compare version components individually, not as complete strings.
     * - Missing components are treated as zero.
     * - Leading zeros do not affect numeric comparison.
     *
     * Mistake I Made:
     * - Initially used version2 while parsing version1.
     * - Corrected the character reference to version1.charAt(p).
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */

    public static int compareVersion(String version1, String version2) {

        int l1 = version1.length();
        int l2 = version2.length();

        int p = 0, q = 0;

        while (p < l1 || q < l2) {

            int num1 = 0;
            int num2 = 0;

            while (p < l1 && version1.charAt(p) != '.') {
                num1 = num1 * 10 + (version1.charAt(p) - '0');
                p++;
            }

            while (q < l2 && version2.charAt(q) != '.') {
                num2 = num2 * 10 + (version2.charAt(q) - '0');
                q++;
            }

            if (p < l1)
                p++;
            if (q < l2)
                q++;

            if (num1 > num2)
                return 1;
            else if (num1 < num2)
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
        assert compareVersion("1.0.0.0", "1") == 0;
        assert compareVersion("2.10", "2.9") == 1;

        System.out.println("All test cases passed!");
    }
}