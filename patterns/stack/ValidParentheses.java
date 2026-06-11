package patterns.stack;

import java.util.Stack;

public class ValidParentheses {
    /*
     * Problem : Valid Parentheses
     * LeetCode : #20
     * Link: https://leetcode.com/problems/valid-parentheses/
     * Pattern : Stack
     * Difficulty : Easy
     * Date Solved: 04-Jun-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Initially thought about counting opening and closing brackets,
     * but that fails because order also matters.
     *
     * Optimal Approach:
     * Use a stack to track opening brackets.
     *
     * Steps:
     * 1. Traverse the string.
     * 2. If current character is an opening bracket,
     * push it into the stack.
     * 3. If current character is a closing bracket:
     * - If stack is empty → invalid.
     * - Check whether top of stack matches current bracket.
     * - If matched, pop it.
     * - Otherwise return false.
     * 4. After traversal, stack must be empty.
     *
     * Why it works:
     * Stack follows LIFO order, which perfectly matches
     * the requirement that the most recently opened bracket
     * must be closed first.
     *
     * Pattern Insight:
     * Whenever a problem involves:
     * - Matching symbols
     * - Nested structures
     * - Balanced expressions
     * Think about using a Stack.
     *
     * Mistake I Made:
     * - Tried thinking in terms of counts instead of order.
     * - Forgot to handle closing brackets when stack is empty.
     * - Missed final check for remaining opening brackets.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given a string containing just the characters
    // '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char peek = stack.peek();

                if ((peek == '(' && ch == ')') ||
                        (peek == '{' && ch == '}') ||
                        (peek == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println("Is Valid Parentheses: " + isValid(s));
    }
}