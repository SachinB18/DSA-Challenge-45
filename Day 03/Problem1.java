// Problem 1: Find Missing Number in an Array
// Given an array containing n distinct numbers from 0 to n, find the one number missing from the sequence.
// Input: [3, 0, 1]
// Output: 2
   // Problem 1: Find Missing Number in an Array
// Given an array containing n distinct numbers from 0 to n, find the one number missing from the sequence.
// Input: [3, 0, 1]
// Output: 2

import java.util.Arrays;
import java.util.HashSet;

public class Problem1 {

    // Approach 1: Sum Formula
    // Idea:
    // The sum of numbers from 0 to n is n * (n + 1) / 2.
    // Subtract the actual array sum from the expected sum.
    // The difference is the missing number.
    public static int missingNumberBySum(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Approach 2: XOR
    // Idea:
    // XOR all numbers from 0 to n and XOR all array elements.
    // Same numbers cancel out, and the remaining value is the missing number.
    public static int missingNumberByXor(int[] arr) {
        int xor = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }

    // Approach 3: Sorting
    // Idea:
    // Sort the array and compare each index with the expected number.
    // The first mismatch is the missing number.
    public static int missingNumberBySorting(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }

    // Approach 4: HashSet
    // Idea:
    // Store all array values in a set.
    // Then check which number from 0 to n is not present.
    public static int missingNumberBySet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i <= arr.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    // Approach 5: Cyclic Sort
    // Idea:
    // Place each number at its correct index.
    // After sorting by position, the index where value != index is the missing number.
    public static int missingNumberByCyclicSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIndex = arr[i];

            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};

        System.out.println("Sum: " + missingNumberBySum(arr.clone()));
        System.out.println("XOR: " + missingNumberByXor(arr.clone()));
        System.out.println("Sorting: " + missingNumberBySorting(arr.clone()));
        System.out.println("HashSet: " + missingNumberBySet(arr.clone()));
        System.out.println("Cyclic Sort: " + missingNumberByCyclicSort(arr.clone()));
    }
}