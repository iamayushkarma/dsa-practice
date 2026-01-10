package arrays;

import java.util.*;

public class EasyArrayProblems {
    // helper function
    static void displayArray(int[] arr) {
        for (var value : arr) {
            System.out.print(value + " ");
        }
    }

    static void numberSwap(int[] arr, int value1, int value2) {
        int temp = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = temp;
    }

    static void swap(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // EASY QUESTIONS (1-15)

    /**
     * Question 1: Find the Largest Element
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the largest element in the array.
     * 
     * Example 1:
     * Input: nums = [3, 5, 1, 8, 2]
     * Output: 8
     * 
     * Example 2:
     * Input: nums = [-5, -2, -10, -1]
     * Output: -1
     */
    static public int findLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (var numbers : nums) {
            if (numbers > max) {
                max = numbers;
            }
        }
        return max;
    }

    /**
     * Question 2: Find the Smallest Element
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the smallest element in the array.
     * 
     * Example 1:
     * Input: nums = [3, 5, 1, 8, 2]
     * Output: 1
     * 
     * Example 2:
     * Input: nums = [10, 20, 5, 15]
     * Output: 5
     */
    static public int findSmallest(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (var numbers : nums) {
            if (numbers < min) {
                min = numbers;
            }
        }
        return min;
    }

    /**
     * Question 3: Sum of Array Elements
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the sum of all elements.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5]
     * Output: 15
     * 
     * Example 2:
     * Input: nums = [-1, -2, 3, 4]
     * Output: 4
     */
    static public int sumArray(int[] nums) {
        int sum = 0;
        for (var num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * Question 4: Average of Array Elements
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the average of all elements.
     * Return the result as a floating-point number.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5]
     * Output: 3.0
     * 
     * Example 2:
     * Input: nums = [10, 20, 30]
     * Output: 20.0
     */
    static public double averageArray(int[] nums) {
        // float avg = 0f;
        int sum = 0;
        for (var num : nums) {
            sum += num;
        }
        double avg = sum / nums.length;
        return avg;
    }

    /**
     * Question 5: Count Even Numbers
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the count of even numbers in the array.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5, 6]
     * Output: 3
     * Explanation: Even numbers are 2, 4, 6
     * 
     * Example 2:
     * Input: nums = [1, 3, 5, 7]
     * Output: 0
     */
    static public int countEven(int[] nums) {
        int evenCount = 0;
        for (var num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    /**
     * Question 6: Count Odd Numbers
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the count of odd numbers in the array.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5, 6]
     * Output: 3
     * Explanation: Odd numbers are 1, 3, 5
     * 
     * Example 2:
     * Input: nums = [2, 4, 6, 8]
     * Output: 0
     */
    static public int countOdd(int[] nums) {
        int oddCount = 0;
        for (var num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }

    /**
     * Question 7: Reverse Array
     * Difficulty: Easy
     * 
     * Given an integer array nums, reverse the array in-place and return it.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5]
     * Output: [5, 4, 3, 2, 1]
     * 
     * Example 2:
     * Input: nums = [10, 20]
     * Output: [20, 10]
     */
    static public int[] reverseArray(int[] nums) {
        // int i = 0;
        // int j = nums.length - 1;
        // while (i < nums.length / 2) {
        // int temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        // i++;
        // j--;
        // }
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] == nums[j])
                continue;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * Question 8: Linear Search
     * Difficulty: Easy
     * 
     * Given an integer array nums and a target value target, return true
     * if target exists in the array, otherwise return false.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5], target = 3
     * Output: true
     * 
     * Example 2:
     * Input: nums = [1, 2, 3, 4, 5], target = 6
     * Output: false
     */
    static public boolean linearSearch(int[] nums, int target) {
        for (var num : nums) {
            if (num == target)
                return true;
        }
        return false;
    }

    /**
     * Question 9: Count Frequency of Element
     * Difficulty: Easy
     * 
     * Given an integer array nums and a target value target, return the
     * number of times target appears in the array.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 2, 2, 4], target = 2
     * Output: 3
     * 
     * Example 2:
     * Input: nums = [5, 5, 5, 5], target = 5
     * Output: 4
     */
    static public int countFrequency(int[] nums, int target) {
        int count = 0;
        for (var num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * Question 10: First Occurrence Index
     * Difficulty: Easy
     * 
     * Given an integer array nums and a target value target, return the
     * index of the first occurrence of target. If target is not found, return -1.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 2, 5], target = 2
     * Output: 1
     * 
     * Example 2:
     * Input: nums = [1, 2, 3, 4], target = 5
     * Output: -1
     */
    static public int firstOccurrence(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Question 11: Count Positive Numbers
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the count of positive numbers
     * (greater than 0).
     * 
     * Example 1:
     * Input: nums = [1, -2, 3, -4, 5]
     * Output: 3
     * Explanation: Positive numbers are 1, 3, 5
     * 
     * Example 2:
     * Input: nums = [-1, -2, -3]
     * Output: 0
     */
    static public int countPositive(int[] nums) {
        int count = 0;
        for (var num : nums) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Question 12: Find Index of Maximum Element
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the index of the maximum element.
     * If multiple maximum values exist, return the first index.
     * 
     * Example 1:
     * Input: nums = [3, 5, 1, 8, 2]
     * Output: 3
     * 
     * Example 2:
     * Input: nums = [10, 10, 5]
     * Output: 0
     */
    static public int indexOfMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    /**
     * Question 13: Count Zeros
     * Difficulty: Easy
     * 
     * Given an integer array nums, return the count of zeros in the array.
     * 
     * Example 1:
     * Input: nums = [1, 0, 3, 0, 5]
     * Output: 2
     * 
     * Example 2:
     * Input: nums = [1, 2, 3]
     * Output: 0
     */
    static public int countZeros(int[] nums) {
        int count = 0;
        for (var num : nums) {
            if (num == 0)
                count++;
        }
        return count;
    }

    /**
     * Question 14: Copy Array
     * Difficulty: Easy
     * 
     * Given an integer array nums, create and return a copy of the array.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5]
     * Output: [1, 2, 3, 4, 5]
     * 
     * Example 2:
     * Input: nums = [10]
     * Output: [10]
     */
    static public int[] copyArray(int[] nums) {
        int[] coppyOfArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            coppyOfArray[i] = nums[i];
        }
        return coppyOfArray;
    }

    /**
     * Question 15: Check if Two Arrays are Equal
     * Difficulty: Easy
     * 
     * Given two integer arrays nums1 and nums2, return true if they
     * are equal (same elements in same order), otherwise return false.
     * 
     * Example 1:
     * Input: nums1 = [1, 2, 3], nums2 = [1, 2, 3]
     * Output: true
     * 
     * Example 2:
     * Input: nums1 = [1, 2, 3], nums2 = [1, 3, 2]
     * Output: false
     */
    static public boolean areArraysEqual(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length)
            return false;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i])
                return false;
        }
        return true;
    }

    // MEDIUM-EASY QUESTIONS (16-30)

    /**
     * Question 16: Second Largest Element
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, return the second largest element.
     * If there is no second largest element, return -1.
     * 
     * Example 1:
     * Input: nums = [3, 5, 1, 8, 2]
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [10, 10, 10]
     * Output: -1
     * Explanation: All elements are same
     */
    static public int secondLargest(int[] nums) {
        int largestNumber = Integer.MIN_VALUE;
        int secondLargestNumber = Integer.MIN_VALUE;
        for (var num : nums) {
            if (num > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = num;
            } else if (num > secondLargestNumber && num != largestNumber) {
                secondLargestNumber = num;
            }
        }
        if (secondLargestNumber == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargestNumber;
    }

    /**
     * Question 17: Check if Array is Sorted
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, return true if the array is sorted in
     * non-decreasing order, otherwise return false.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5]
     * Output: true
     * 
     * Example 2:
     * Input: nums = [1, 3, 2, 4]
     * Output: false
     */
    static public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Question 18: Remove Duplicates from Sorted Array
     * Difficulty: Medium-Easy
     * 
     * Given a sorted integer array nums, remove duplicates in-place and
     * return the new length. The relative order of elements should be kept the
     * same.
     * 
     * Example 1:
     * Input: nums = [1, 1, 2, 2, 3, 4, 4]
     * Output: 4
     * Explanation: Array becomes [1, 2, 3, 4, ...]
     * 
     * Example 2:
     * Input: nums = [1, 1, 1, 1]
     * Output: 1
     */
    static public int removeDuplicates(int[] nums) {

        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }

    /**
     * Question 19: Rotate Array Left by K Positions
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums and an integer k, rotate the array
     * to the left by k positions.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 4, 5], k = 2
     * Output: [3, 4, 5, 1, 2]
     * 
     * Example 2:
     * Input: nums = [1, 2, 3], k = 4
     * Output: [2, 3, 1]
     * Explanation: k=4 is same as k=1 (4 % 3 = 1)
     */
    static public int[] rotateLeftByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, n - 1);
        return nums;
    }

    /**
     * Question 20: Move Zeros to End
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, move all zeros to the end while
     * maintaining the relative order of non-zero elements.
     * 
     * Example 1:
     * Input: nums = [0, 1, 0, 3, 12]
     * Output: [1, 3, 12, 0, 0]
     * 
     * Example 2:
     * Input: nums = [0, 0, 1]
     * Output: [1, 0, 0]
     */
    static public int[] moveZeros(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != idx) {
                    numberSwap(nums, i, idx);
                }
                idx++;
            }
        }
        return nums;
    }

    /**
     * Question 21: Find Missing Number
     * Difficulty: Medium-Easy
     * 
     * Given an array nums containing n distinct numbers in the range [1, n+1],
     * return the one number that is missing from the array.
     * 
     * Example 1:
     * Input: nums = [1, 2, 4, 5, 6]
     * Output: 3
     * Explanation: Numbers 1 to 6 should be present, 3 is missing
     * 
     * Example 2:
     * Input: nums = [2, 3, 4, 5]
     * Output: 1
     * Explanation: Numbers 1 to 5 should be present, 1 is missing
     */
    static public int findMissing(int[] nums) {
        // int sum = 0;
        // for (int num : nums) {
        // sum += num;
        // }
        // int n = nums.length + 1;
        // int totalSum = (n * (n + 1)) / 2;
        // return totalSum - sum;

        int xor = 0;
        for (int i = 1; i <= nums.length + 1; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    /**
     * Question 22: Check if Array Contains Duplicates
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, return true if any value appears at
     * least twice, otherwise return false.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 1]
     * Output: true
     * 
     * Example 2:
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     */
    static public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Question 23: Check if Array is Palindrome
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, return true if the array reads the
     * same forwards and backwards, otherwise return false.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 2, 1]
     * Output: true
     * 
     * Example 2:
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     */
    static public boolean isPalindrome(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] != nums[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;

        // int[] revArray = Arrays.copyOf(nums, nums.length);
        // return Arrays.equals(reverseArray(revArray), nums);
    }

    /**
     * Question 24: Find Single Non-Duplicate
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums where every element appears twice except
     * one, find that single element.
     * Hint: Use XOR operation for optimal solution.
     * 
     * Example 1:
     * Input: nums = [2, 3, 5, 3, 2]
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [1, 1, 2, 2, 3]
     * Output: 3
     */
    static public int findSingleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    /**
     * Question 25: Merge Two Sorted Arrays
     * Difficulty: Medium-Easy
     * 
     * Given two sorted integer arrays nums1 and nums2, merge them into
     * a single sorted array and return it.
     * 
     * Example 1:
     * Input: nums1 = [1, 3, 5], nums2 = [2, 4, 6]
     * Output: [1, 2, 3, 4, 5, 6]
     * 
     * Example 2:
     * Input: nums1 = [1, 2], nums2 = [3, 4]
     * Output: [1, 2, 3, 4]
     */
    static public int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] meargedArray = new int[n + m];
        int idx = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                meargedArray[idx++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                meargedArray[idx++] = nums2[j++];
            }
        }
        while (i < n) {
            meargedArray[idx++] = nums1[i++];
        }
        while (j < m) {
            meargedArray[idx++] = nums2[j++];
        }
        return meargedArray;
    }

    /**
     * Question 26: Find Kth Largest Element
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums and an integer k, return the kth largest
     * element in the array.
     * 
     * Example 1:
     * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
     * Output: 4
     */
    public int kthLargest(int[] nums, int k) {

        return 0;
    }

    /**
     * Question 27: Separate Even and Odd Numbers
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, rearrange it so that all even numbers
     * come before odd numbers and return the array. Order within groups
     * doesn't matter.
     * 
     * Example 1:
     * Input: nums = [3, 1, 2, 4]
     * Output: [2, 4, 3, 1] (or any arrangement with evens first)
     * 
     * Example 2:
     * Input: nums = [1, 3, 5]
     * Output: [1, 3, 5]
     */
    public int[] separateEvenOdd(int[] nums) {
        // Your code here
        return nums;
    }

    /**
     * Question 28: Find Majority Element
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, return the element that appears more
     * than n/2 times. Assume such element always exists.
     * Hint: Try Boyer-Moore Voting Algorithm for optimal solution.
     * 
     * Example 1:
     * Input: nums = [3, 3, 4, 2, 3, 3, 3]
     * Output: 3
     * 
     * Example 2:
     * Input: nums = [1, 1, 1, 2, 2]
     * Output: 1
     */
    public int majorityElement(int[] nums) {
        // Your code here
        return 0;
    }

    /**
     * Question 29: Find Intersection of Two Arrays
     * Difficulty: Medium-Easy
     * 
     * Given two integer arrays nums1 and nums2, return an array containing
     * their intersection (common elements). Each element must appear only once.
     * 
     * Example 1:
     * Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
     * Output: [2]
     * 
     * Example 2:
     * Input: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
     * Output: [4, 9] or [9, 4]
     */
    public int[] findIntersection(int[] nums1, int[] nums2) {
        // Your code here
        return new int[0];
    }

    /**
     * Question 30: Find Peak Element
     * Difficulty: Medium-Easy
     * 
     * Given an integer array nums, find a peak element (element that is
     * greater than its neighbors) and return its index. Assume nums[-1]
     * and nums[n] are negative infinity.
     * 
     * Example 1:
     * Input: nums = [1, 2, 3, 1]
     * Output: 2
     * Explanation: 3 is a peak element
     * 
     * Example 2:
     * Input: nums = [1, 2, 1, 3, 5, 6, 4]
     * Output: 5
     * Explanation: 6 is a peak element (1 or 5 are also valid answers)
     */
    public int findPeakElement(int[] nums) {
        // Your code here
        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println();

        // Q1
        System.out.print("Q1 -->");
        int[] arr1 = { -5, -2, -10, -1 };
        System.out.println(" Largest element is: " + findLargest(arr1));

        // Q2
        System.out.print("Q2 -->");
        int[] arr2 = { 10, 20, 5, 15 };
        System.out.println(" Smallest element is: " + findSmallest(arr2));

        // Q3
        System.out.print("Q3 -->");
        int[] arr3 = { -1, -2, 3, 4 };
        System.out.println(" Sum of the array is: " + sumArray(arr3));

        // Q4
        System.out.print("Q4 -->");
        int[] arr4 = { 1, 2, 3, 4, 5 };
        System.out.println(" Average of the array is: " + averageArray(arr4));

        // Q5
        System.out.print("Q5 -->");
        int[] arr5 = { 1, 2, 3, 4, 5 };
        System.out.println(" Count of even numbers: " + countEven(arr5));

        // Q6
        System.out.print("Q6 -->");
        int[] arr6 = { 1, 2, 3, 4, 5 };
        System.out.println(" Count of odd numbers: " + countOdd(arr6));

        // Q7
        System.out.print("Q7 -->");
        int[] arr7 = { 1, 2, 3, 4, 5 };
        System.out.print(" Reversed array is: ");
        int[] ansArr7 = reverseArray(arr7);
        displayArray(ansArr7);
        System.out.println();

        // Q8
        System.out.print("Q8 -->");
        int[] arr8 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(" Is Target present: " + linearSearch(arr8, 6));

        // Q9
        System.out.print("Q9 -->");
        int[] arr9 = { 1, 2, 1, 3, 5, 6, 5, 5, 7, 6 };
        System.out.println(" Frequency of the number: " + countFrequency(arr9, 5));

        // Q10
        System.out.print("Q10 -->");
        int[] arr10 = { 1, 2, 1, 3, 5, 6, 5, 5, 7, 6 };
        System.out.println(" First occurance at idx: " + firstOccurrence(arr10, 5));

        // Q11
        System.out.print("Q11 -->");
        int[] arr11 = { -1, -2, -1, 3, -5, 6, 5, -5, -7, 6 };
        System.out.println(" Total posative no. in array: " + countPositive(arr11));

        // Q12
        System.out.print("Q12 -->");
        int[] arr12 = { -1, -14, -1, 3, -5, 9, 5, -5, -7, 6 };
        System.out.println(" Index of max number is: " + indexOfMax(arr12));

        // Q13
        System.out.print("Q13 -->");
        int[] arr13 = { 1, 0, 3, 0, 5 };
        System.out.println(" Total count of zeros: " + countZeros(arr13));

        // Q14
        System.out.print("Q14 -->");
        int[] arr14 = { 1, 2, 3, 4, 5 };
        System.out.print(" Copy of array is: ");
        int[] ansArr14 = copyArray(arr14);
        displayArray(ansArr14);
        System.out.println();

        // Q15
        System.out.print("Q15 -->");
        int[] nums15_1 = { 1, 2, 3 };
        int[] nums15_2 = { 1, 3, 2 };
        System.out.println(" Are array equal: " + areArraysEqual(nums15_1, nums15_2));

        // Q16
        System.out.print("Q16 -->");
        int[] nums16 = { 1, 2, 3, 4, 5, 8, 7, 15, 9, 10 };
        // int[] nums16 = { 1, 1, 1, 1, 1, 1 };
        System.out.println(" Second largest number is: " + secondLargest(nums16));

        // Q17
        System.out.print("Q17 -->");
        int[] nums17 = { 1, 2, 3, 4, 5, 4, };
        System.out.println(" Is array sorted: " + isSorted(nums17));

        // Q18
        System.out.print("Q18 -->");
        int[] nums18 = { 1, 1, 2, 2, 3, 4, 4, 5 };
        System.out.println(" Length after duplicates removed: " + removeDuplicates(nums18));

        // Q19
        System.out.print("Q19 -->");
        int[] nums19 = { 1, 2, 3, 4, 5, 6 };
        int k = 2;
        System.out.print(" Array rotated " + k + " times : ");
        int[] rotatedArray = rotateLeftByK(nums19, k);
        displayArray(rotatedArray);
        System.out.println();

        // Q20
        System.out.print("Q20 -->");
        int[] nums20 = { 0, 0, 1, 2, 0, 3, 0 };
        System.out.print(" Modified array is: ");
        int[] modifiedArray = moveZeros(nums20);
        displayArray(modifiedArray);
        System.out.println();

        // Q21
        System.out.print("Q21 -->");
        int[] nums21 = { 1, 2, 3, 4, 5, 7 };
        System.out.println(" Missing number is : " + findMissing(nums21));

        // Q22
        System.out.print("Q22 -->");
        int[] nums22 = { 3, 1, 4, 2, 2 };
        System.out.println(" Does array contains duplicate values: " + containsDuplicate(nums22));

        // Q23
        System.out.print("Q23 -->");
        int[] nums23 = { 1, 2, 3, 2, 1 };
        System.out.println(" Is array palindrome: " + isPalindrome(nums23));

        // Q24
        System.out.print("Q24 -->");
        int[] nums24 = { 1, 2, 3, 2, 1, 3, 21 };
        System.out.println(" Single non duplicate value is: " + findSingleNonDuplicate(nums24));

        // Q25
        System.out.print("Q25 -->");
        int[] nums25_1 = { 1, 2, 3 };
        int[] nums25_2 = { 4, 5 };
        System.out.print(" Modified array is: ");
        int[] mergeArrays = mergeSortedArrays(nums25_1, nums25_2);
        displayArray(mergeArrays);
        System.out.println();
    }
}