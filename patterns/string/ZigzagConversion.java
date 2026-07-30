package patterns.string;

public class ZigzagConversion {
    /*
     * Problem : Zigzag Conversion
     * LeetCode : 6
     * Link:
     * https://leetcode.com/problems/zigzag-conversion/
     * Pattern : String Traversal + Simulation
     * Difficulty : Medium
     * Date Solved: 30-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Instead of constructing the entire zigzag matrix, I maintained one
     * StringBuilder (or String) for each row. I traversed the input string
     * character by character while keeping track of the current row and the
     * current direction (down or up). Each character was appended to its
     * corresponding row. Whenever the traversal reached the first or last
     * row, I reversed the direction. Finally, I concatenated all rows to
     * obtain the required zigzag string.
     *
     * Optimal Approach:
     * 1. Handle the edge case where numRows == 1 or numRows >= s.length().
     * 2. Create one StringBuilder for each row.
     * 3. Traverse the string once.
     * 4. Append each character to the current row.
     * 5. Reverse the traversal direction whenever the first or last row is
     * reached.
     * 6. Concatenate all rows and return the final string.
     *
     * Pattern Insight:
     * String Traversal
     * Simulation
     * Direction Change
     *
     * Mistake I Made:
     * Initially, I tried simulating the zigzag using a 2D character matrix.
     * This introduced unnecessary complexity with row/column management,
     * diagonal movement, unused cells, and boundary conditions. The problem
     * only requires the final string, so maintaining each row separately is
     * much simpler and more efficient.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * where:
     * n = length of the input string
     */

    // Convert the given string into its zigzag pattern.
    public static String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = true;

        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            if (currentRow == 0) {
                goingDown = true;
            } else if (currentRow == numRows - 1) {
                goingDown = false;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println("Converted String: " + convert(s, numRows));
    }
}