package patterns.stack;

import java.util.Stack;

public class AsteroidCollision {

    /*
     * Problem : Asteroid Collision
     * LeetCode : #735
     * Link : https://leetcode.com/problems/asteroid-collision/
     * Pattern : Stack
     * Difficulty : Medium
     * Date Solved : 11-June-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initially I thought of comparing the sum of two asteroids.
     *
     * Example:
     * 5 + (-10) = -5
     *
     * But this logic is incorrect because the problem is not
     * about arithmetic addition.
     *
     * The sign represents direction:
     * +ve -> moving right
     * -ve -> moving left
     *
     * The magnitude represents size.
     *
     * Therefore collisions must be decided using absolute values,
     * not by adding numbers.
     *
     * ---------------------------------------------------------
     *
     * Key Observation:
     *
     * A collision can happen only when:
     *
     * positive asteroid
     * ->
     *
     * <-
     * negative asteroid
     *
     * Meaning:
     *
     * stack top > 0
     * current asteroid < 0
     *
     * Any other combination can never collide.
     *
     * Examples:
     *
     * [-5, 10]
     * No collision
     *
     * [-5, -10]
     * No collision
     *
     * [5, 10]
     * No collision
     *
     * [10, -5]
     * Collision
     *
     * ---------------------------------------------------------
     *
     * Optimal Approach:
     *
     * Use a stack to maintain surviving asteroids.
     *
     * Steps:
     *
     * 1. Traverse every asteroid.
     *
     * 2. If:
     * - asteroid is positive
     * OR
     * - stack is empty
     *
     * Push directly.
     *
     * 3. For a negative asteroid:
     *
     * Keep checking collisions with stack top.
     *
     * 4. Collision Cases:
     *
     * abs(current) == top
     * -> both explode
     *
     * abs(current) < top
     * -> current explodes
     *
     * abs(current) > top
     * -> top explodes
     * continue checking
     *
     * 5. If all positive asteroids are destroyed,
     * current asteroid survives and is pushed.
     *
     * ---------------------------------------------------------
     *
     * Why While Loop?
     *
     * One asteroid may collide multiple times.
     *
     * Example:
     *
     * [10, 2, -5]
     *
     * Step 1:
     *
     * 2 collides with -5
     *
     * [10, -5]
     *
     * Step 2:
     *
     * 10 collides with -5
     *
     * [10]
     *
     * Therefore one comparison is not enough.
     *
     * We must continue until:
     *
     * - current asteroid dies
     * - stack becomes empty
     * - no collision is possible
     *
     * ---------------------------------------------------------
     *
     * Example Dry Run:
     *
     * Input:
     *
     * [5, 10, -5]
     *
     * Stack:
     *
     * 5
     * [5]
     *
     * 10
     * [5, 10]
     *
     * -5
     *
     * abs(-5)=5
     *
     * Compare with 10:
     *
     * 10 > 5
     *
     * -5 explodes
     *
     * Final:
     *
     * [5,10]
     *
     * ---------------------------------------------------------
     *
     * Pattern Insight:
     *
     * Whenever:
     *
     * - Current element affects previous elements
     * - Elements destroy/remove each other
     * - Chain reactions occur
     * - Need access to the most recent survivor
     *
     * Think about using a Stack.
     *
     * ---------------------------------------------------------
     *
     * Common Interview Clue:
     *
     * If an incoming element can repeatedly eliminate
     * previous elements one by one,
     * Stack is usually the correct data structure.
     *
     * ---------------------------------------------------------
     *
     * Mistakes I Made:
     *
     * - Tried using arithmetic addition.
     * - Forgot that direction and size are different concepts.
     * - Initially handled only one collision.
     * - Didn't realize one asteroid can collide
     * multiple times.
     * - Missed checking for empty stack after pops.
     *
     * ---------------------------------------------------------
     *
     * Time Complexity:
     * O(n)
     *
     * Reason:
     * Every asteroid is pushed once and popped at most once.
     *
     * ---------------------------------------------------------
     *
     * Space Complexity:
     * O(n)
     */

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int value = asteroids[i];

            if (value > 0 || stack.isEmpty()) {

                stack.push(value);

            } else {

                while (!stack.isEmpty()) {

                    int top = stack.peek();

                    if (top < 0) {
                        stack.push(value);
                        break;
                    }

                    int modVal = Math.abs(value);

                    if (modVal == top) {

                        stack.pop();
                        break;

                    } else if (modVal < top) {

                        break;

                    } else {

                        stack.pop();

                        if (stack.isEmpty()) {
                            stack.push(value);
                            break;
                        }
                    }
                }
            }
        }

        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] asteroids = { 5, 10, -5 };

        int[] result = asteroidCollision(asteroids);

        System.out.print("Result : ");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}