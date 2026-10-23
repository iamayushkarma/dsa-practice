package patterns.stack;

import java.util.Stack;

public class SimplifyPath {

    /*
     * Problem : Simplify Path
     * LeetCode : 71
     * Link: https://leetcode.com/problems/simplify-path/
     * Pattern : Stack (Path Normalization)
     * Difficulty : Medium
     * Date Solved: 23-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * The goal is to simplify an absolute Unix-style file path into
     * its canonical form.
     *
     * Use a stack of strings to store valid directory names.
     *
     * Steps:
     * 1. Split the input path using "/" to obtain individual components.
     * 2. Traverse each directory component:
     * - If the component is empty or ".", ignore it.
     * - If the component is "..", pop the most recent directory
     * if the stack is not empty.
     * - Otherwise, push the directory name onto the stack.
     * 3. Build the result by iterating over the stack from bottom to top.
     * 4. If the stack is empty, return "/".
     * Otherwise, return the constructed absolute path.
     *
     * Pattern Insight:
     * A stack is useful when the latest directory must be removed
     * while processing "..".
     *
     * - "." represents the current directory and can be ignored.
     * - ".." represents the parent directory and removes the most
     * recently added directory, if one exists.
     * - Repeated slashes produce empty components, which can be ignored.
     * - Directory names such as "..." are valid names and must not
     * be treated as special navigation components.
     *
     * Although a stack follows LIFO for push() and pop(), Java's
     * enhanced for loop iterates over Stack elements from bottom to top.
     * This allows the final path to be constructed in the correct order.
     *
     * Mistake I Made:
     * Initially, I processed the path character by character and treated
     * every '.' as a special character.
     *
     * This fails because "." and ".." have special meanings only when
     * they form complete path components. Names such as "..." are valid
     * directory names.
     *
     * Another issue was repeatedly concatenating strings using +=,
     * which can cause unnecessary string allocations.
     *
     * Time Complexity: O(n)
     * Splitting and processing the path takes O(n) time, where n is
     * the length of the input path. Building the result also takes O(n).
     *
     * Space Complexity: O(n)
     * The directory components and stack can collectively require O(n)
     * additional space.
     */

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for (String dir : directories) {

            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {

        SimplifyPath solution = new SimplifyPath();

        String path = "/a/../../b/c/../";

        System.out.println(solution.simplifyPath(path));

        // Output: /b
    }
}