package patterns.string;

public class MultiplyStrings {
    /*
     * Problem : Multiply Strings
     * LeetCode : 43
     * Link:
     * https://leetcode.com/problems/multiply-strings/
     * Pattern : String Manipulation + Simulation
     * Difficulty : Medium
     * Date Solved: 03-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I simulated the grade-school multiplication process. Starting from the
     * rightmost digits of both strings, I multiplied every pair of digits and
     * stored the result in an integer array of size (n + m), where n and m are
     * the lengths of the two strings. Each multiplication contributes to two
     * positions in the result array: one for the current digit and one for the
     * carry. Finally, I skipped only the leading zeros and constructed the
     * answer string.
     *
     * Optimal Approach:
     * 1. If either string is "0", return "0".
     * 2. Create an integer array of size (n + m).
     * 3. Traverse both strings from right to left.
     * 4. Multiply the current pair of digits.
     * 5. Add the product to the existing value at the current position.
     * 6. Store the one's digit and propagate the carry.
     * 7. Skip leading zeros and build the final string.
     *
     * Pattern Insight:
     * String Manipulation
     * Simulation
     * Grade-School Multiplication
     * Carry Handling
     *
     * Mistake I Made:
     * Initially, I removed every zero while constructing the answer instead of
     * removing only the leading zeros. This produced incorrect outputs like
     * "2" instead of "2000". The correct approach is to skip zeros only until
     * the first non-zero digit is encountered.
     *
     * Time Complexity: O(n × m)
     * Space Complexity: O(n + m)
     *
     * where:
     * n = length of num1
     * m = length of num2
     *
     * Note:
     * The maximum number of digits in the product of two numbers having n and m
     * digits is (n + m), which is why the result array has size (n + m). This
     * solution avoids converting the strings into integers and works even for
     * very large numbers.
     */

    // Returns the product of two non-negative integers represented as strings.
    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int n = num1.length();
        int m = num2.length();

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0))
                sb.append(digit);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println("Product: " + multiply(num1, num2));
    }
}