package patterns.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
     * Problem : Evaluate Reverse Polish Notation
     * LeetCode : #150
     * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
     * Pattern : Stack
     * Difficulty : Medium
     * Date Solved: 04-Jun-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Initially thought about converting the expression into
     * infix notation and then evaluating it.
     *
     * But Reverse Polish Notation (Postfix) can be evaluated
     * directly using a stack.
     *
     * Optimal Approach:
     * Use a stack to store operands.
     *
     * Steps:
     * 1. Traverse each token.
     * 2. If token is a number:
     * - Push it into the stack.
     * 3. If token is an operator:
     * - Pop top two elements.
     * - Apply the operation.
     * - Push the result back.
     * 4. At the end, the stack contains the answer.
     *
     * Why it works:
     * In Postfix notation, operators always act on the most
     * recently encountered operands.
     *
     * Stack naturally supports this behavior using LIFO.
     *
     * Pattern Insight:
     * Whenever a problem involves:
     * - Postfix Expressions
     * - Prefix Expressions
     * - Expression Evaluation
     * - Operators acting on recent values
     *
     * Think about using a Stack.
     *
     * Mistake I Made:
     * - Popped operands in the wrong order.
     * - Forgot that subtraction and division are not commutative.
     * - Misunderstood integer division behavior.
     * - Added unnecessary handling for negative division results.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Evaluate the value of an arithmetic expression
    // in Reverse Polish Notation.
    //
    // Valid operators:
    // +, -, *, /
    //
    // Division truncates toward zero.

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];

            if (!ch.equals("+") &&
                    !ch.equals("-") &&
                    !ch.equals("*") &&
                    !ch.equals("/")) {

                stack.push(Integer.parseInt(ch));

            } else {

                int num1 = stack.pop();
                int num2 = stack.pop();

                int result = switch (ch) {
                    case "+" -> num2 + num1;
                    case "-" -> num2 - num1;
                    case "*" -> num2 * num1;
                    case "/" -> num2 / num1;
                    default -> throw new IllegalArgumentException("Invalid Operator");
                };

                stack.push(result);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {

        // Expected Output: 9
        String[] arr1 = { "2", "1", "+", "3", "*" };

        // Expected Output: 6
        String[] arr2 = { "4", "13", "5", "/", "+" };

        // Expected Output: 22
        String[] arr3 = {
                "10", "6", "9", "3", "+",
                "-11", "*", "/", "*",
                "17", "+", "5", "+"
        };

        System.out.println("Evaluation: " + evalRPN(arr1));
        System.out.println("Evaluation: " + evalRPN(arr2));
        System.out.println("Evaluation: " + evalRPN(arr3));
    }
}