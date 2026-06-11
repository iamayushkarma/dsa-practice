package patterns.stack;

import java.util.Stack;

public class DecodeString {

    /*
     * Problem : Decode String
     * LeetCode : #394
     * Link : https://leetcode.com/problems/decode-string/
     * Pattern : Stack
     * Difficulty : Medium
     * Date Solved : 11-June-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initially tried using a character stack and building
     * the decoded string whenever ']' was encountered.
     *
     * Problems with that approach:
     * - String got reversed while popping characters.
     * - Nested encodings became difficult to manage.
     * - Multi-digit numbers like 12[a] were not handled properly.
     * - Keeping track of previous decoded strings was messy.
     *
     * Optimal Approach:
     * Use two stacks:
     *
     * 1. countStack -> stores repetition counts.
     * 2. stringStack -> stores previous strings before '['.
     *
     * Also maintain:
     * - curr : current decoded string.
     * - num : current repetition number.
     *
     * Steps:
     *
     * 1. If current character is a digit:
     * Build the complete number.
     *
     * num = num * 10 + (ch - '0')
     *
     * This handles:
     * 3[a]
     * 12[a]
     * 100[a]
     *
     * 2. If current character is '[':
     * - Push num into countStack.
     * - Push curr into stringStack.
     * - Reset num = 0.
     * - Reset curr = "".
     *
     * 3. If current character is a letter:
     * Append it to curr.
     *
     * 4. If current character is ']':
     * - Pop repetition count.
     * - Pop previous string.
     * - Repeat curr count times.
     * - Append repeated string to previous string.
     * - Update curr.
     *
     * 5. After traversal, curr contains final answer.
     *
     * Why it works:
     *
     * Every '[' starts a new decoding context.
     * We save:
     * - the string built so far
     * - the repeat count
     *
     * When ']' is encountered:
     * we finish the current context and merge it back
     * with the previous one.
     *
     * This naturally handles nested encodings.
     *
     * Example:
     *
     * Input:
     * 3[a2[c]]
     *
     * Stack States:
     *
     * countStack : [3]
     * stringStack: [""]
     *
     * countStack : [3,2]
     * stringStack: ["","a"]
     *
     * Process:
     * c -> cc
     * a + cc -> acc
     * acc repeated 3 times
     *
     * Result:
     * accaccacc
     *
     * Pattern Insight:
     *
     * Whenever a problem involves:
     * - Nested expressions
     * - Entering and leaving contexts
     * - Processing from inner-most to outer-most
     *
     * Think about using a Stack.
     *
     * Common Interview Clue:
     *
     * '[' means:
     * "save current state"
     *
     * ']' means:
     * "restore previous state"
     *
     * This is often solved using stacks.
     *
     * Mistakes I Made:
     *
     * - Used only one character stack.
     * - Forgot that popping characters reverses order.
     * - Did not handle nested encodings correctly.
     * - Failed for multi-digit numbers.
     * - Tried building answer globally instead of
     * maintaining context.
     *
     * Time Complexity:
     * O(n + outputLength)
     *
     * Space Complexity:
     * O(n)
     */

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');

            } else if (ch == '[') {

                countStack.push(num);
                stringStack.push(curr);

                num = 0;
                curr = new StringBuilder();

            } else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }

                curr = prev;

            } else {

                curr.append(ch);
            }
        }

        return curr.toString();
    }

    public static void main(String[] args) {

        String s = "3[a2[c]]";

        System.out.println("Decoded String : " + decodeString(s));
    }
}