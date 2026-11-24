package patterns.string;

import java.util.Stack;

public class BasicCalculatorII {

    /**
     * Problem: Basic Calculator II
     * LeetCode Number: 227
     * Link: https://leetcode.com/problems/basic-calculator-ii/
     * Pattern: Stack / Expression Evaluation
     * Difficulty: Medium
     * Date Solved: 24-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Traverse the expression character by character.
     * - Build multi-digit numbers using number = number * 10 + digit.
     * - Maintain an operator variable to track the previous operator.
     * - Use a stack to store intermediate results.
     * - For addition, push the number onto the stack.
     * - For subtraction, push the negative number.
     * - For multiplication and division, pop the previous number,
     * perform the operation, and push the result back.
     * - Add a dummy '+' at the end to process the final number.
     * - Sum all values remaining in the stack.
     *
     * Optimal Approach:
     * - Use a single-pass stack-based expression evaluation.
     * - Handle multiplication and division immediately.
     * - Defer addition and subtraction by storing signed values.
     *
     * Pattern Insight:
     * - Multiplication and division have higher precedence than
     * addition and subtraction.
     * - Evaluate multiplication and division immediately.
     * - Store addition and subtraction as positive or negative values.
     * - A final dummy operator ensures the last number is processed.
     *
     * Mistake I Made:
     * - Initially used the operator character instead of the
     * accumulated number for multiplication and division.
     * - Initially missed processing the final number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char operator = '+';
        int result = 0;

        for (char ch : (s + '+').toCharArray()) {

            // Build multi-digit number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && ch != ' ') {

                switch (operator) {

                    case '+':
                        stack.push(number);
                        break;

                    case '-':
                        stack.push(-1 * number);
                        break;

                    case '*':
                        stack.push(stack.pop() * number);
                        break;

                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }

                operator = ch;
                number = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        assert calculate("3+2*2") == 7;
        assert calculate(" 3/2 ") == 1;
        assert calculate(" 3+5 / 2 ") == 5;
        assert calculate("14-3/2") == 13;
        assert calculate("2*3+4") == 10;
        assert calculate("10+20*3") == 70;
        assert calculate("100/10*2") == 20;
        assert calculate("0-2147483647") == -2147483647;

        System.out.println("All test cases passed!");
    }
}