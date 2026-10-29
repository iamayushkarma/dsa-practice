package patterns.stack;

import java.util.Stack;

class RemoveDuplicateLetters {

    /**
     * Problem: Remove Duplicate Letters
     * LeetCode: 316
     * Link: https://leetcode.com/problems/remove-duplicate-letters/
     * Pattern: Monotonic Stack + Frequency Array + Visited Array
     * Difficulty: Medium
     * Date Solved: 29-10-2026
     *
     * Revision:
     * [ ] Day 1
     * [ ] Day 3
     * [ ] Day 7
     * [ ] Day 14
     * [ ] Day 30
     *
     * My Approach:
     * 1. Use a frequency array to count occurrences of each character.
     * 2. Use a stack to maintain the lexicographically smallest result.
     * 3. Use a visited array to avoid adding duplicate characters.
     * 4. Decrease the frequency of each character as it is processed.
     * 5. Skip the character if it is already present in the stack.
     * 6. While the stack is not empty, the top character is greater
     * than the current character, and the top character occurs
     * again later, remove the top character.
     * 7. Mark every removed character as not visited so it can be
     * added again later.
     * 8. Push the current character and mark it as visited.
     * 9. Build the result from the stack.
     *
     * Why It Works:
     * - Frequency tells us whether a character appears again later.
     * - Visited ensures every character appears only once.
     * - Removing a larger character when a smaller character appears
     * later improves lexicographical order, provided the removed
     * character can be added again.
     * - The stack preserves the relative order of selected characters.
     *
     * Pattern Insight:
     * Monotonic Stack + Greedy
     *
     * When the current character is smaller than the stack's top,
     * remove the top only if it appears again later.
     *
     * This allows us to construct the lexicographically smallest
     * subsequence containing every distinct character exactly once.
     *
     * Mistake I Made:
     * Checked freq[ch - 'a'] > 0 in the while condition instead of
     * freq[stack.peek() - 'a'] > 0.
     *
     * The frequency check must refer to the character being removed,
     * not the current character.
     *
     * Time Complexity: O(n)
     * Each character is pushed and popped at most once.
     *
     * Space Complexity: O(1) auxiliary space
     * The frequency array, visited array, and stack use at most
     * 26 character entries, assuming lowercase English letters.
     */

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Step 1: Count the frequency of every character.
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Build the lexicographically smallest result.
        for (char ch : s.toCharArray()) {

            // Current character is now processed.
            freq[ch - 'a']--;

            // Skip characters already present in the stack.
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later.
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            // Add the current character.
            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Step 3: Construct the final result.
        StringBuilder res = new StringBuilder();

        for (char ch : stack) {
            res.append(ch);
        }

        return res.toString();
    }
}
