package recursion;

import java.util.ArrayList;
import java.util.List;

public class MediumRecursionProblems {
    // MEDIUM QUESTIONS (1-30)

    /**
     * Question 1: Tower of Hanoi
     * Difficulty: Medium
     * 
     * Solve the Tower of Hanoi puzzle. Print the sequence of moves.
     * Move n disks from source to destination using auxiliary tower.
     * 
     * Example 1:
     * Input: n = 2, source = 'A', destination = 'C', auxiliary = 'B'
     * Output:
     * Move disk 1 from A to B
     * Move disk 2 from A to C
     * Move disk 1 from B to C
     * 
     * Example 2:
     * Input: n = 3, source = 'A', destination = 'C', auxiliary = 'B'
     * Output: (7 moves total)
     */
    static public void towerOfHanoi(int n, char source, char dest, char aux) {
        // Your code here
    }

    /**
     * Question 2: Generate Parentheses
     * Difficulty: Medium
     * 
     * Given n pairs of parentheses, generate all valid combinations.
     * 
     * Example 1:
     * Input: n = 2
     * Output: ["(())", "()()"]
     * 
     * Example 2:
     * Input: n = 3
     * Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
     */
    static public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 3: Permutations of String
     * Difficulty: Medium
     * 
     * Given a string, generate all permutations of the string.
     * 
     * Example 1:
     * Input: str = "ABC"
     * Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
     * 
     * Example 2:
     * Input: str = "AB"
     * Output: ["AB", "BA"]
     */
    static public void permutations(String str, String result) {
        // Your code here
    }

    /**
     * Question 4: Subsets of Array (Power Set)
     * Difficulty: Medium
     * 
     * Given an array of distinct integers, return all possible subsets.
     * 
     * Example 1:
     * Input: arr = [1, 2, 3]
     * Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
     * 
     * Example 2:
     * Input: arr = [1, 2]
     * Output: [[], [1], [2], [1,2]]
     */
    static public List<List<Integer>> subsets(int[] arr, int idx) {
        List<List<Integer>> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 5: Letter Combinations of Phone Number
     * Difficulty: Medium
     * 
     * Given a string containing digits 2-9, return all possible letter
     * combinations.
     * Phone keypad mapping: 2=abc, 3=def, 4=ghi, 5=jkl, 6=mno, 7=pqrs, 8=tuv,
     * 9=wxyz
     * 
     * Example 1:
     * Input: digits = "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     * 
     * Example 2:
     * Input: digits = "2"
     * Output: ["a", "b", "c"]
     */
    static public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 6: Count Paths in Matrix (Top-Left to Bottom-Right)
     * Difficulty: Medium
     * 
     * Count total paths from (0,0) to (m-1,n-1) in m×n matrix.
     * You can only move right or down.
     * 
     * Example 1:
     * Input: m = 3, n = 3
     * Output: 6
     * 
     * Example 2:
     * Input: m = 2, n = 3
     * Output: 3
     */
    static public int countPaths(int m, int n) {
        // Your code here
        return 0;
    }

    /**
     * Question 7: Combination Sum
     * Difficulty: Medium
     * 
     * Find all unique combinations in array where numbers sum to target.
     * Same number may be chosen unlimited times.
     * 
     * Example 1:
     * Input: candidates = [2, 3, 6, 7], target = 7
     * Output: [[2,2,3], [7]]
     * 
     * Example 2:
     * Input: candidates = [2, 3, 5], target = 8
     * Output: [[2,2,2,2], [2,3,3], [3,5]]
     */
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 8: Word Search in Matrix
     * Difficulty: Medium
     * 
     * Given a 2D board and a word, check if word exists in the grid.
     * Word can be constructed from adjacent cells (horizontally or vertically).
     * Same cell cannot be used twice.
     * 
     * Example 1:
     * Input: board = [['A','B','C'],['S','F','C'],['A','D','E']], word = "ABCCED"
     * Output: true
     * 
     * Example 2:
     * Input: board = [['A','B'],['C','D']], word = "ABCD"
     * Output: false
     */
    static public boolean wordSearch(char[][] board, String word) {
        // Your code here
        return false;
    }

    /**
     * Question 9: N-Queens Problem
     * Difficulty: Medium
     * 
     * Place N queens on N×N chessboard so no two queens attack each other.
     * Return the number of distinct solutions.
     * 
     * Example 1:
     * Input: n = 4
     * Output: 2
     * 
     * Example 2:
     * Input: n = 1
     * Output: 1
     */
    static public int nQueens(int n) {
        // Your code here
        return 0;
    }

    /**
     * Question 10: Sudoku Solver
     * Difficulty: Medium
     * 
     * Solve a Sudoku puzzle by filling empty cells (marked as '.').
     * 
     * Example 1:
     * Input: board = [["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],...]
     * Output: true (and board is filled)
     * 
     * Example 2:
     * Input: invalid board
     * Output: false
     */
    static public boolean solveSudoku(char[][] board) {
        // Your code here
        return false;
    }

    /**
     * Question 11: Binary Search (Recursive)
     * Difficulty: Medium
     * 
     * Search for target in sorted array using binary search recursion.
     * 
     * Example 1:
     * Input: arr = [1, 2, 3, 4, 5, 6, 7], target = 4
     * Output: 3
     * 
     * Example 2:
     * Input: arr = [1, 2, 3, 4, 5], target = 6
     * Output: -1
     */
    static public int binarySearch(int[] arr, int left, int right, int target) {
        // Your code here
        return -1;
    }

    /**
     * Question 12: Merge Sort
     * Difficulty: Medium
     * 
     * Sort an array using merge sort algorithm (recursion).
     * 
     * Example 1:
     * Input: arr = [5, 2, 8, 1, 9]
     * Output: [1, 2, 5, 8, 9]
     * 
     * Example 2:
     * Input: arr = [3, 1, 4, 1, 5]
     * Output: [1, 1, 3, 4, 5]
     */
    static public void mergeSort(int[] arr, int left, int right) {
        // Your code here
    }

    /**
     * Question 13: Quick Sort
     * Difficulty: Medium
     * 
     * Sort an array using quick sort algorithm (recursion).
     * 
     * Example 1:
     * Input: arr = [5, 2, 8, 1, 9]
     * Output: [1, 2, 5, 8, 9]
     * 
     * Example 2:
     * Input: arr = [3, 1, 4, 1, 5]
     * Output: [1, 1, 3, 4, 5]
     */
    static public void quickSort(int[] arr, int low, int high) {
        // Your code here
    }

    /**
     * Question 14: Generate All Binary Strings of Length N
     * Difficulty: Medium
     * 
     * Generate all binary strings of length n.
     * 
     * Example 1:
     * Input: n = 2
     * Output: ["00", "01", "10", "11"]
     * 
     * Example 2:
     * Input: n = 3
     * Output: ["000", "001", "010", "011", "100", "101", "110", "111"]
     */
    static public void generateBinaryStrings(int n, String current) {
        // Your code here
    }

    /**
     * Question 15: Rat in a Maze
     * Difficulty: Medium
     * 
     * Find path for rat from (0,0) to (n-1,n-1) in maze.
     * 1 = open path, 0 = blocked. Can move up, down, left, right.
     * 
     * Example 1:
     * Input: maze = [[1,0,0,0],[1,1,0,1],[0,1,0,0],[1,1,1,1]]
     * Output: true (path exists)
     * 
     * Example 2:
     * Input: maze = [[1,0],[0,1]]
     * Output: false
     */
    static public boolean ratInMaze(int[][] maze, int x, int y, int[][] sol) {
        // Your code here
        return false;
    }

    /**
     * Question 16: Print All Subsequences of String
     * Difficulty: Medium
     * 
     * Print all subsequences (not permutations) of a given string.
     * 
     * Example 1:
     * Input: str = "abc"
     * Output: ["", "a", "b", "c", "ab", "ac", "bc", "abc"]
     * 
     * Example 2:
     * Input: str = "ab"
     * Output: ["", "a", "b", "ab"]
     */
    static public void printSubsequences(String str, String current, int idx) {
        // Your code here
    }

    /**
     * Question 17: Longest Increasing Subsequence (LIS) Length
     * Difficulty: Medium
     * 
     * Find length of longest increasing subsequence using recursion.
     * 
     * Example 1:
     * Input: arr = [10, 9, 2, 5, 3, 7, 101, 18]
     * Output: 4
     * Explanation: [2, 3, 7, 101]
     * 
     * Example 2:
     * Input: arr = [7, 7, 7, 7]
     * Output: 1
     */
    static public int lis(int[] arr, int n, int prev) {
        // Your code here
        return 0;
    }

    /**
     * Question 18: Decode Ways
     * Difficulty: Medium
     * 
     * A message containing letters A-Z is encoded to numbers: 'A'->1, 'B'->2, ...,
     * 'Z'->26.
     * Given encoded message, count total ways to decode it.
     * 
     * Example 1:
     * Input: s = "12"
     * Output: 2
     * Explanation: "AB" (1 2) or "L" (12)
     * 
     * Example 2:
     * Input: s = "226"
     * Output: 3
     * Explanation: "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
     */
    static public int decodeWays(String s, int idx) {
        // Your code here
        return 0;
    }

    /**
     * Question 19: Partition to K Equal Sum Subsets
     * Difficulty: Medium
     * 
     * Check if array can be partitioned into k subsets with equal sum.
     * 
     * Example 1:
     * Input: arr = [4, 3, 2, 3, 5, 2, 1], k = 4
     * Output: true
     * Explanation: [5], [1,4], [2,3], [2,3]
     * 
     * Example 2:
     * Input: arr = [1, 2, 3, 4], k = 3
     * Output: false
     */
    static public boolean canPartitionKSubsets(int[] arr, int k) {
        // Your code here
        return false;
    }

    /**
     * Question 20: Gray Code Generation
     * Difficulty: Medium
     * 
     * Generate n-bit Gray code sequence (adjacent codes differ by 1 bit).
     * 
     * Example 1:
     * Input: n = 2
     * Output: [0, 1, 3, 2] (binary: 00, 01, 11, 10)
     * 
     * Example 2:
     * Input: n = 3
     * Output: [0, 1, 3, 2, 6, 7, 5, 4]
     */
    static public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 21: All Paths from Source to Target in DAG
     * Difficulty: Medium
     * 
     * Find all paths from node 0 to node n-1 in directed acyclic graph.
     * 
     * Example 1:
     * Input: graph = [[1,2],[3],[3],[]]
     * Output: [[0,1,3],[0,2,3]]
     * 
     * Example 2:
     * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
     * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
     */
    static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 22: Palindrome Partitioning
     * Difficulty: Medium
     * 
     * Partition string such that every substring is a palindrome.
     * 
     * Example 1:
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     * 
     * Example 2:
     * Input: s = "a"
     * Output: [["a"]]
     */
    static public List<List<String>> palindromePartition(String s) {
        List<List<String>> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 23: Power Set with Duplicates
     * Difficulty: Medium
     * 
     * Given array that may contain duplicates, return all unique subsets.
     * 
     * Example 1:
     * Input: arr = [1, 2, 2]
     * Output: [[], [1], [1,2], [1,2,2], [2], [2,2]]
     * 
     * Example 2:
     * Input: arr = [4, 4, 4]
     * Output: [[], [4], [4,4], [4,4,4]]
     */
    static public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 24: Beautiful Arrangement
     * Difficulty: Medium
     * 
     * Count permutations of [1, n] where for every i:
     * perm[i] is divisible by i, or i is divisible by perm[i].
     * 
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: [1,2] and [2,1]
     * 
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: [1,2,3], [2,1,3], [3,2,1]
     */
    static public int countArrangement(int n) {
        // Your code here
        return 0;
    }

    /**
     * Question 25: Remove Invalid Parentheses
     * Difficulty: Medium
     * 
     * Remove minimum invalid parentheses to make string valid.
     * Return all possible results.
     * 
     * Example 1:
     * Input: s = "()())()"
     * Output: ["(())()", "()()()"]
     * 
     * Example 2:
     * Input: s = "(a)())()"
     * Output: ["(a())()", "(a)()()"]
     */
    static public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 26: Expression Add Operators
     * Difficulty: Medium
     * 
     * Given string of digits, return all possible results from adding
     * operators +, -, * between digits to get target value.
     * 
     * Example 1:
     * Input: num = "123", target = 6
     * Output: ["1+2+3", "1*2*3"]
     * 
     * Example 2:
     * Input: num = "232", target = 8
     * Output: ["2*3+2", "2+3*2"]
     */
    static public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 27: Restore IP Addresses
     * Difficulty: Medium
     * 
     * Given string of digits, return all valid IP addresses.
     * 
     * Example 1:
     * Input: s = "25525511135"
     * Output: ["255.255.11.135", "255.255.111.35"]
     * 
     * Example 2:
     * Input: s = "0000"
     * Output: ["0.0.0.0"]
     */
    static public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // Your code here
        return result;
    }

    /**
     * Question 28: Kth Symbol in Grammar
     * Difficulty: Medium
     * 
     * Build table where:
     * Row 1: 0
     * Row 2: 01
     * Row 3: 0110
     * Row 4: 01101001
     * Each row formed from previous: 0->01, 1->10
     * Return kth symbol (1-indexed) in nth row.
     * 
     * Example 1:
     * Input: n = 3, k = 2
     * Output: 1
     * 
     * Example 2:
     * Input: n = 4, k = 5
     * Output: 1
     */
    static public int kthGrammar(int n, int k) {
        // Your code here
        return 0;
    }

    /**
     * Question 29: Flood Fill
     * Difficulty: Medium
     * 
     * Perform flood fill starting from (sr, sc) with newColor.
     * Fill all connected pixels of same color.
     * 
     * Example 1:
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * 
     * Example 2:
     * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
     * Output: [[2,2,2],[2,2,2]]
     */
    static public void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        // Your code here
    }

    /**
     * Question 30: Count Good Numbers
     * Difficulty: Medium
     * 
     * Count n-digit numbers where:
     * - Even indices have even digits (0,2,4,6,8)
     * - Odd indices have prime digits (2,3,5,7)
     * Return count modulo 10^9+7.
     * 
     * Example 1:
     * Input: n = 1
     * Output: 5
     * Explanation: [0,2,4,6,8]
     * 
     * Example 2:
     * Input: n = 4
     * Output: 400
     */
    static public int countGoodNumbers(long n) {
        // Your code here
        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Medium Recursion Problems - Practice File");
        System.out.println("=========================================");

        // Add your test cases here
        // Example:
        // System.out.println("Q1 --> Tower of Hanoi");
        // towerOfHanoi(3, 'A', 'C', 'B');
    }
}