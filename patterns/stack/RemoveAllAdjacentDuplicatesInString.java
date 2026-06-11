package patterns.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    /*
     * Problem : Remove All Adjacent Duplicates In String
     * LeetCode : #1047
     * Link :
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
     * Pattern : Stack
     * Difficulty : Easy
     * Date Solved : 11-June-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * At first glance, it looks like we can remove adjacent duplicates
     * whenever we find them.
     *
     * However, removing one pair can create a new adjacent pair.
     *
     * Example:
     * abbaca
     *
     * Remove "bb"
     * -> aaca
     *
     * Now "aa" becomes adjacent and must also be removed.
     *
     * Because newly formed pairs must also be processed,
     * we need a way to remember previous characters.
     *
     * Optimal Approach:
     * Use a stack.
     *
     * The stack stores characters that have not been removed yet.
     *
     * Steps:
     *
     * 1. Traverse the string.
     *
     * 2. For each character:
     *
     * If stack is empty:
     * push current character.
     *
     * Otherwise:
     * If top of stack equals current character:
     * pop the top element
     * (remove duplicate pair)
     *
     * Else:
     * push current character.
     *
     * 3. After traversal:
     * Stack contains the final remaining characters.
     *
     * 4. Pop all characters into StringBuilder.
     *
     * 5. Reverse the result because stack pops
     * elements in reverse order.
     *
     * Why it works:
     *
     * Stack always keeps the current valid string.
     *
     * When a duplicate character arrives:
     *
     * top == current
     *
     * we remove both by popping the top and skipping
     * the current character.
     *
     * This automatically handles chain reactions.
     *
     * Example:
     *
     * Input:
     * abbaca
     *
     * Process:
     *
     * a -> [a]
     * b -> [a,b]
     * b -> [a]
     * a -> []
     * c -> [c]
     * a -> [c,a]
     *
     * Result:
     * "ca"
     *
     * Pattern Insight:
     *
     * Whenever a problem involves:
     * - Removing adjacent elements
     * - Cancelling matching pairs
     * - Chain reactions after removals
     * - Need to compare with previous element
     *
     * Think about using a Stack.
     *
     * Common Interview Clue:
     *
     * If removing something can affect nearby elements,
     * a Stack is often the right choice because it keeps
     * track of the most recent valid element.
     *
     * Mistakes I Made:
     *
     * - Initially thought of removing characters directly
     * from the string.
     *
     * - Didn't realize new duplicates can form after
     * removing an existing pair.
     *
     * - Forgot that stack output comes in reverse order,
     * so reversing the final string is necessary.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n)
     */

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
            } else {

                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "abbaca";

        System.out.println("Result : " + removeDuplicates(s));
    }
}