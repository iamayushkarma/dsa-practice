package patterns.stack;

import java.util.Stack;

public class ScoreOfParentheses {

    /*
     * Problem : Score of Parentheses
     * LeetCode : 856
     * Link: https://leetcode.com/problems/score-of-parentheses/
     * Pattern : Stack (Nested Expression Evaluation)
     * Difficulty : Medium
     * Date Solved: 23-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a stack of integers to calculate the scores of nested parentheses.
     *
     * Rules:
     * 1. "()" has a score of 1.
     * 2. "(A)" has a score of 2 * score(A).
     * 3. "AB" has a score of score(A) + score(B).
     *
     * Steps:
     * 1. Initialize a stack and push 0 as the base score.
     * 2. Traverse the string character by character.
     * 3. If the character is '(':
     * Push 0 onto the stack to start a new score context.
     * 4. If the character is ')':
     * a. Pop the inner score from the stack.
     * b. Calculate the current pair's score using:
     * max(2 * innerScore, 1).
     * - If innerScore is 0, the pair is "()", so its score is 1.
     * - Otherwise, the pair is nested, so its score is doubled.
     * c. Pop the parent score.
     * d. Add the current score to the parent score and push the result.
     * 5. After processing the entire string, pop and return the final score.
     *
     * Pattern Insight:
     * The stack maintains separate score contexts for nested parentheses.
     *
     * Every opening parenthesis creates a new context initialized to 0.
     * Every closing parenthesis resolves that context and combines its
     * score with the parent context.
     *
     * The initial 0 acts as the base score for the complete expression.
     *
     * Mistake I Made:
     * Initially, I tried counting consecutive opening parentheses and
     * calculating powers of 2 using Math.pow().
     *
     * This does not correctly handle expressions containing multiple
     * independent groups or nested expressions with different scores.
     *
     * Instead, each nested expression must maintain its own intermediate
     * score, which can be handled using a stack of integers.
     *
     * Time Complexity: O(n)
     * Each character is processed once, and each stack operation takes O(1)
     * amortized time.
     *
     * Space Complexity: O(n)
     * In the worst case, deeply nested parentheses require O(n) stack space.
     */

    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();

                int score = Math.max(2 * innerScore, 1);

                int outerScore = stack.pop();

                stack.push(outerScore + score);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        ScoreOfParentheses solution = new ScoreOfParentheses();

        String s = "(()(()))";

        System.out.println(solution.scoreOfParentheses(s));

        // Output: 6
    }
}