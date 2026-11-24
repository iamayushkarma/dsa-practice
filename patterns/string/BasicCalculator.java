package patterns.string;

import java.util.Stack;

public class BasicCalculator {

    /**
     * Problem: Basic Calculator
     * LeetCode Number: 224
     * Link: https://leetcode.com/problems/basic-calculator/
     * Pattern: Stack / Expression Evaluation
     * Difficulty: Hard
     * Date Solved: 24-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Traverse the expression character by character.
     * - Build multi-digit numbers using number = number * 10 + digit.
     * - Maintain a sign variable to track positive and negative numbers.
     * - When encountering '+' or '-', evaluate the previous number.
     * - When encountering '(':
     * - Push the previous result onto the stack.
     * - Push the current sign onto the stack.
     * - Reset result and sign for the new expression.
     * - When encountering ')':
     * - Evaluate the current number.
     * - Pop the previous sign and result.
     * - Combine the current expression with the previous result.
     *
     * Optimal Approach:
     * - Use a stack to handle nested parentheses.
     * - Evaluate expressions in a single traversal.
     * - Maintain the current result, number, and sign.
     *
     * Pattern Insight:
     * - Stack helps preserve the result and sign of an outer expression.
     * - Parentheses create independent subexpressions.
     * - Push the previous result and sign when entering '('.
     * - Restore them when encountering ')'.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int n = s.length();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {

            switch (ch) {

                case '+':
                    result = result + (sign * number);
                    number = 0;
                    sign = 1;
                    break;

                case '-':
                    result = result + (sign * number);
                    number = 0;
                    sign = -1;
                    break;

                case '(':
                    stack.push(result);
                    stack.push(sign);

                    result = 0;
                    sign = 1;
                    number = 0;
                    break;

                case ')':
                    result = result + (sign * number);
                    number = 0;

                    int operator = stack.pop();
                    int num = stack.pop();

                    result *= operator;
                    result += num;
                    break;

                default:
                    if (Character.isDigit(ch)) {
                        number = number * 10 + (ch - '0');
                    }
            }
        }

        result = result + (sign * number);

        return result;
    }

    public static void main(String[] args) {

        assert calculate("1 + 1") == 2;
        assert calculate(" 2-1 + 2 ") == 3;
        assert calculate("(1+(4+5+2)-3)+(6+8)") == 23;
        assert calculate("1-(2+3)") == -4;
        assert calculate("-(2+3)") == -5;
        assert calculate("2-(5-6)") == 3;
        assert calculate("2147483647") == 2147483647;

        System.out.println("All test cases passed!");
    }
}