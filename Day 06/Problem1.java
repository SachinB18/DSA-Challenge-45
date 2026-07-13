// Problem 1: Two Sum
// Given an array of integers and a target, return the indices of the two numbers that add up to the target.
// Input: [2, 7, 11, 15], target = 9
// Output: [0, 1]

import java.util.*;

public class Problem1 {

    // Brute-force: check every pair
    static int[] twoSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return new int[] { i, j };
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    // One-pass HashMap: best general approach for interviews
    static int[] twoSumHash(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) return new int[] { map.get(comp), i };
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumBruteForce(arr, target)));
        System.out.println(Arrays.toString(twoSumHash(arr, target)));
    }
}