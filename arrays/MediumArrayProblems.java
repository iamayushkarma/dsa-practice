package arrays;

import java.util.*;

public class MediumArrayProblems {
    // MEDIUM QUESTIONS (1-30)

    // helper function
    static void displayArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void swapValue(int[] arr, int value1, int value2) {
        int temp = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = temp;
    }

    static void reverseArray(int[] arr, int st, int end) {
        while (st <= end) {
            swap(arr, st, end);
            st++;
            end--;
        }
    }

    static void swap(int[] arr, int value1, int value2) {
        while (value1 < value2) {
            int temp = arr[value1];
            arr[value1] = arr[value2];
            arr[value2] = temp;

            value1++;
            value2--;
        }
    }

    /**
     * Question 1: Two Sum
     * Difficulty: Medium
     * 
     * Given an integer array nums and a target sum, return indices of two numbers
     * that add up to the target. You may assume each input has exactly one
     * solution.
     * 
     * Example 1:
     * Input: nums = [2, 7, 11, 15], target = 9
     * Output: [0, 1]
     * Explanation: nums[0] + nums[1] = 2 + 7 = 9
     * 
     * Example 2:
     * Input: nums = [3, 2, 4], target = 6
     * Output: [1, 2]
     */
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = {};

        for (int i = 0; i < nums.length; i++) {
            int req_pair = target - nums[i];
            if (map.containsKey(req_pair)) {
                ans = new int[] { map.get(req_pair), i };
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    /**
     * Question 2: Three Sum Zero
     * Difficulty: Medium
     * 
     * Given an integer array nums, find all unique triplets that sum to zero.
     * Return the count of such triplets.
     * 
     * Example 1:
     * Input: nums = [-1, 0, 1, 2, -1, -4]
     * Output: 2
     * Explanation: Triplets are [-1, -1, 2] and [-1, 0, 1]
     * 
     * Example 2:
     * Input: nums = [0, 0, 0]
     * Output: 1
     * Explanation: Only triplet is [0, 0, 0]
     */
    static public int threeSumZero(int[] nums) {
        // Your code here
        return 0;
    }

    /**
     * Question 3: Product of Array Except Self
     * Difficulty: Medium
     * 
     * Return an array where each element is the product of all elements
     * except itself. Do not use division.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4]
     * Output: [24, 12, 8, 6]
     * 
     * Example 2:
     * Input: nums = [-1, 1, 0, -3, 3]
     * Output: [0, 0, 9, 0, 0]
     */
    static public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            ans[i] *= suffix;
        }
        return ans;
    }

    /**
     * Question 4: Container With Most Water
     * Difficulty: Medium
     * 
     * Find two lines that together with x-axis form a container with most water.
     * Return the maximum area.
     * 
     * Example 1:
     * Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
     * Output: 49
     * Explanation: Max area = min(8, 7) * (8 - 1) = 49
     * 
     * Example 2:
     * Input: height = [1, 1]
     * Output: 1
     */
    static public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int max_area = 0;

        while (i <= j) {
            int width = j - i;
            int high = Math.min(height[i], height[j]);
            int current_area = width * high;
            max_area = Math.max(current_area, max_area);

            if (height[i] <= height[j])
                i++;
            else
                j--;
        }
        return max_area;
    }

    /**
     * Question 5: Rotate Array Right by K
     * Difficulty: Medium
     * 
     * Rotate an array to the right by k steps in-place.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
     * Output: [5, 6, 7, 1, 2, 3, 4]
     * 
     * Example 2:
     * Input: nums = [-1, -100, 3, 99], k = 2
     * Output: [3, 99, -1, -100]
     */
    static public void rotateRight(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        swap(nums, i, j);
        swap(nums, i, k - 1);
        swap(nums, k, j);

        displayArray(nums);
    }

    /**
     * Question 6: Find All Duplicates
     * Difficulty: Medium
     * 
     * Given an array where 1 ≤ nums[i] ≤ n, some elements appear twice.
     * Find all elements that appear twice and return them in an array.
     * 
     * Example 1:
     * Input: nums = [4, 3, 2, 7, 8, 2, 3, 1]
     * Output: [2, 3]
     * 
     * Example 2:
     * Input: nums = [1, 1, 2]
     * Output: [1]
     */
    static public int[] findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int count = 0;
        for (int val : map.keySet()) {
            if (map.get(val) > 1)
                count++;
        }
        int[] ans = new int[count];
        int idx = 0;
        for (int val : map.keySet()) {
            if (map.get(val) > 1)
                ans[idx++] = val;
        }
        return ans;
    }

    /**
     * Question 7: Maximum Subarray Sum (Kadane's Algorithm)
     * Difficulty: Medium
     * 
     * Find the contiguous subarray with the largest sum and return its sum.
     * 
     * Example 1:
     * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * Output: 6
     * Explanation: [4, -1, 2, 1] has the largest sum = 6
     * 
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    static public int maxSubarraySum(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int val : nums) {
            curr_sum += val;
            max_sum = Math.max(curr_sum, max_sum);
            if (curr_sum < 0)
                curr_sum = 0;
        }

        return max_sum;
    }

    /**
     * Question 8: Sort Colors (Dutch National Flag)
     * Difficulty: Medium
     * 
     * Given an array with values 0, 1, and 2, sort it in-place.
     * 
     * Example 1:
     * Input: nums = [2, 0, 2, 1, 1, 0]
     * Output: [0, 0, 1, 1, 2, 2]
     * 
     * Example 2:
     * Input: nums = [2, 0, 1]
     * Output: [0, 1, 2]
     */
    static public void sortColors(int[] nums) {

        int n = nums.length;
        int low = 0, mid = 0;
        int high = n - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    swapValue(nums, low, mid);
                    mid++;
                    low++;
                }
                case 1 -> {
                    mid++;
                }
                case 2 -> {
                    swapValue(nums, mid, high);
                    high--;
                }
            }
        }
    }

    /**
     * Question 9: Find Peak Element
     * Difficulty: Medium
     * 
     * Find a peak element (greater than neighbors) and return its index.
     * Use binary search for O(log n) solution.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 1]
     * Output: 2
     * 
     * Example 2:
     * Input: nums = [1, 2, 1, 3, 5, 6, 4]
     * Output: 5
     */
    static public int findPeakElement(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + ((j - i) / 2);

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }

        }
        return -1;
    }

    /**
     * Question 10: Search in Rotated Sorted Array
     * Difficulty: Medium
     * 
     * Search for a target in a rotated sorted array. Return its index or -1.
     * 
     * Example 1:
     * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
     * Output: 4
     * 
     * Example 2:
     * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 3
     * Output: -1
     */
    static public int searchRotated(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // chack is left part is sorted
            if (nums[mid] >= nums[i]) {
                if (target >= nums[i] && target < nums[mid]) { // check if target lie between the sorted part
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }

            }
        }
        return -1;
    }

    /**
     * Question 11: Find Minimum in Rotated Sorted Array
     * Difficulty: Medium
     * 
     * Find the minimum element in a rotated sorted array.
     * 
     * Example 1:
     * Input: nums = [3, 4, 5, 1, 2]
     * Output: 1
     * 
     * Example 2:
     * Input: nums = [4, 5, 6, 7, 0, 1, 2]
     * Output: 0
     */
    static public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int mid = i + ((j - i) / 2);
            if (nums[i] < nums[j])
                return nums[i];
            if (nums[mid] >= nums[i]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }

    /**
     * Question 12: Next Permutation
     * Difficulty: Medium
     * 
     * Rearrange array to its next lexicographically greater permutation.
     * If not possible, arrange in ascending order.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3]
     * Output: [1, 3, 2]
     * 
     * Example 2:
     * Input: nums = [3, 2, 1]
     * Output: [1, 2, 3]
     */
    static public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swapValue(nums, i, pivot);
                break;
            }
        }
        reverseArray(nums, pivot + 1, n - 1);
    }

    /**
     * Question 13: Subarray Sum Equals K
     * Difficulty: Medium
     * 
     * Find the total number of continuous subarrays whose sum equals k.
     * 
     * Example 1:
     * Input: nums = [1, 1, 1], k = 2
     * Output: 2
     * Explanation: Subarrays [1, 1] appear twice
     * 
     * Example 2:
     * Input: nums = [1, 2, 3], k = 3
     * Output: 2
     * Explanation: Subarrays [1, 2] and [3]
     */
    static public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int current_prefix_sum = 0;

        for (int val : nums) {
            current_prefix_sum += val;
            count += map.getOrDefault(current_prefix_sum - k, 0);
            map.put(current_prefix_sum, map.getOrDefault(current_prefix_sum, 0) + 1);
        }
        return count;
    }

    /**
     * Question 14: Find First and Last Position
     * Difficulty: Medium
     * 
     * Find the starting and ending position of a target value in sorted array.
     * Return [-1, -1] if target not found.
     * 
     * Example 1:
     * Input: nums = [5, 7, 7, 8, 8, 10], target = 8
     * Output: [3, 4]
     * 
     * Example 2:
     * Input: nums = [5, 7, 7, 8, 8, 10], target = 6
     * Output: [-1, -1]
     */
    static public int[] searchRange(int[] nums, int target) {
        int first = searchForLeft(nums, target);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = searchForRight(nums, target);

        return new int[] { first, last };
    }

    static public int searchForLeft(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;
        int st = 0;
        int end = n - 1;

        while (st <= end) {
            int mid = st + ((end - st) / 2);
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    static public int searchForRight(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;
        int st = 0;
        int end = n - 1;

        while (st <= end) {
            int mid = st + ((end - st) / 2);
            if (nums[mid] <= target) {
                if (nums[mid] == target)
                    ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Question 15: Longest Consecutive Sequence
     * Difficulty: Medium
     * 
     * Find the length of the longest consecutive elements sequence.
     * 
     * Example 1:
     * Input: nums = [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: Sequence is [1, 2, 3, 4]
     * 
     * Example 2:
     * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
     * Output: 9
     */
    static public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max_seq = 0;
        int idx = 0;
        for (int val : nums) {
            set.add(val);
        }
        for (int val : nums) {
            if (set.contains(val - 1)) {
                int curr_length = 1;
                while (set.contains(val++)) {
                    curr_length++;
                }
                max_seq = Math.max(max_seq, curr_length);
            }
        }
        return max_seq;
    }

    /**
     * Question 16: Set Matrix Zeros
     * Difficulty: Medium
     * 
     * Given m x n matrix, if an element is 0, set its entire row and column to 0.
     * Do it in-place.
     * 
     * Example 1:
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     * 
     * Example 2:
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     */
    static public void setZeroes(int[][] matrix) {
        // Your code here
    }

    /**
     * Question 17: Spiral Matrix
     * Difficulty: Medium
     * 
     * Given m x n matrix, return all elements in spiral order.
     * 
     * Example 1:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     * 
     * Example 2:
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    static public int[] spiralOrder(int[][] matrix) {
        // Your code here
        return new int[] {};
    }

    /**
     * Question 18: Rotate Matrix 90 Degrees
     * Difficulty: Medium
     * 
     * Rotate the n x n matrix 90 degrees clockwise in-place.
     * 
     * Example 1:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     * 
     * Example 2:
     * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     */
    static public void rotateMatrix(int[][] matrix) {
        // Your code here
    }

    /**
     * Question 19: Valid Sudoku
     * Difficulty: Medium
     * 
     * Determine if a 9x9 Sudoku board is valid (partially filled).
     * 
     * Example 1:
     * Input: board with some numbers filled
     * Output: true
     * 
     * Example 2:
     * Input: board with invalid placement
     * Output: false
     */
    static public boolean isValidSudoku(char[][] board) {
        // Your code here
        return false;
    }

    /**
     * Question 20: Jump Game
     * Difficulty: Medium
     * 
     * Given array where nums[i] is max jump length from position i,
     * determine if you can reach the last index.
     * 
     * Example 1:
     * Input: nums = [2, 3, 1, 1, 4]
     * Output: true
     * Explanation: Jump 1 step to index 1, then 3 steps to last index
     * 
     * Example 2:
     * Input: nums = [3, 2, 1, 0, 4]
     * Output: false
     */
    static public boolean canJump(int[] nums) {
        // Your code here
        return false;
    }

    /**
     * Question 21: Merge Intervals
     * Difficulty: Medium
     * 
     * Given array of intervals, merge all overlapping intervals.
     * 
     * Example 1:
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * 
     * Example 2:
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     */
    static public int[][] mergeIntervals(int[][] intervals) {
        // Your code here
        return new int[][] {};
    }

    /**
     * Question 22: Insert Interval
     * Difficulty: Medium
     * 
     * Insert a new interval into sorted non-overlapping intervals and merge if
     * needed.
     * 
     * Example 1:
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * 
     * Example 2:
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     */
    static public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        // Your code here
        return new int[][] {};
    }

    /**
     * Question 23: Find Kth Largest Element (QuickSelect)
     * Difficulty: Medium
     * 
     * Find the kth largest element without fully sorting.
     * Use partition method for O(n) average time.
     * 
     * Example 1:
     * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
     * Output: 4
     */
    static public int findKthLargest(int[] nums, int k) {
        // Your code here
        return 0;
    }

    /**
     * Question 24: Top K Frequent Elements
     * Difficulty: Medium
     * 
     * Return the k most frequent elements from the array.
     * 
     * Example 1:
     * Input: nums = [1, 1, 1, 2, 2, 3], k = 2
     * Output: [1, 2]
     * 
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    static public int[] topKFrequent(int[] nums, int k) {
        // Your code here
        return new int[] {};
    }

    /**
     * Question 25: Find Duplicate Number
     * Difficulty: Medium
     * 
     * Given array of n+1 integers where each is between 1 and n,
     * find the duplicate number. Array contains only one duplicate.
     * 
     * Example 1:
     * Input: nums = [1, 3, 4, 2, 2]
     * Output: 2
     * 
     * Example 2:
     * Input: nums = [3, 1, 3, 4, 2]
     * Output: 3
     */
    static public int findDuplicate(int[] nums) {
        // Your code here
        return 0;
    }

    /**
     * Question 26: Trapping Rain Water
     * Difficulty: Medium
     * 
     * Calculate how much rain water can be trapped after raining.
     * 
     * Example 1:
     * Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     * Output: 6
     * 
     * Example 2:
     * Input: height = [4, 2, 0, 3, 2, 5]
     * Output: 9
     */
    static public int trap(int[] height) {
        // Your code here
        return 0;
    }

    /**
     * Question 27: Maximum Product Subarray
     * Difficulty: Medium
     * 
     * Find the contiguous subarray with the largest product.
     * 
     * Example 1:
     * Input: nums = [2, 3, -2, 4]
     * Output: 6
     * Explanation: [2, 3] has product 6
     * 
     * Example 2:
     * Input: nums = [-2, 0, -1]
     * Output: 0
     */
    static public int maxProduct(int[] nums) {
        // Your code here
        return 0;
    }

    /**
     * Question 28: 4Sum
     * Difficulty: Medium
     * 
     * Find all unique quadruplets that sum to target.
     * 
     * Example 1:
     * Input: nums = [1, 0, -1, 0, -2, 2], target = 0
     * Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
     * 
     * Example 2:
     * Input: nums = [2, 2, 2, 2, 2], target = 8
     * Output: [[2, 2, 2, 2]]
     */
    static public int countFourSum(int[] nums, int target) {
        // Your code here (return count of unique quadruplets)
        return 0;
    }

    /**
     * Question 29: Longest Subarray with Sum K
     * Difficulty: Medium
     * 
     * Find the length of longest subarray with sum equal to k.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], k = 3
     * Output: 3
     * Explanation: Subarrays [1, 1, 1] has length 3
     * 
     * Example 2:
     * Input: nums = [1, 2, 1, 3], k = 2
     * Output: 1
     */
    static public int longestSubarrayWithSumK(int[] nums, int k) {
        // Your code here
        return 0;
    }

    /**
     * Question 30: Count Inversions
     * Difficulty: Medium
     * 
     * Count the number of inversions in array.
     * Inversion: i < j and nums[i] > nums[j]
     * 
     * Example 1:
     * Input: nums = [2, 4, 1, 3, 5]
     * Output: 3
     * Explanation: (2, 1), (4, 1), (4, 3)
     * 
     * Example 2:
     * Input: nums = [5, 4, 3, 2, 1]
     * Output: 10
     */
    static public int countInversions(int[] nums) {
        // Your code here
        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {

        System.out.println();
        System.out.print("ans Q1 --> ");
        int[] arr1 = { 2, 7, 11, 15 };
        int target = 9;
        int[] ans1 = twoSum(arr1, target);
        displayArray(ans1);

        System.out.println();
        System.out.print("ans Q3 --> ");
        int[] arr3 = { 1, 2, 3, 4, 5 };
        int[] ans3 = productExceptSelf(arr3);
        displayArray(ans3);

        System.out.println();
        System.out.print("ans Q4 --> ");
        int[] arr4 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Max area is: " + maxArea(arr4));

        System.out.print("ans Q5 --> ");
        int[] arr5 = { 1, 2, 3, 4, 5, 6, 7 };
        int target5 = 3;
        rotateRight(arr5, target5);

        System.out.println();
        System.out.print("ans Q6 --> ");
        int[] arr6 = { 1, 2, 3, 2, 6, 4, 5, 6, 9, 9, 8, 10, 5 };
        int[] ans6 = findDuplicates(arr6);
        displayArray(ans6);

        System.out.println();
        System.out.print("ans Q7 --> ");
        int[] arr7 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Max sum of sub array is: " + maxSubarraySum(arr7));

        System.out.print("ans Q8 --> ");
        int[] arr8 = { 2, 0, 2, 1, 1, 0 };
        sortColors(arr8);
        System.out.println(Arrays.toString(arr8));

        System.out.print("ans Q9 --> ");
        int[] arr9 = { 1, 2, 3, 1 };
        System.out.println("peek element is: " + findPeakElement(arr9));

        System.out.print("ans Q10 --> ");
        int[] arr10 = { 4, 5, 6, 7, 0, 1, 2 };
        int k10 = 0;
        System.out.println("Element is at idx: " + searchRotated(arr10, k10));

        System.out.print("ans Q11 --> ");
        int[] arr11 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Minimum element is: " + findMin(arr11));

        System.out.print("ans Q12 --> ");
        int[] arr12 = { 3, 2, 1 };
        nextPermutation(arr12);
        System.out.println("Next permutatation is: " + Arrays.toString(arr12));

        System.out.print("ans Q13 --> ");
        int[] arr13 = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k13 = 7;
        System.out.println("Sub array length is: " + subarraySum(arr13, k13));

        System.out.print("ans Q14 --> ");
        int[] arr14 = { 5, 7, 7, 8, 8, 10 };
        int k14 = 8;
        System.out.println("First and last occurance is: " + Arrays.toString(searchRange(arr14, k14)));

        System.out.print("ans Q15 --> ");
        int[] arr15 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Max longest sequence is: " + longestConsecutive(arr15));

    }
}