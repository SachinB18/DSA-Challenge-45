// Problem 3: Find the Sum of All Subarrays of Size K
// Given an array and an integer k, find the sum of every contiguous subarray of size k.
// Input: [2, 1, 5, 1, 3, 2], k = 3
// Output: [8, 7, 9, 6]

public class Problem3 {
    public static int[] sumSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        result[0] = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            result[i - k + 1] = windowSum;
        }

        return result;
    }

    public static int[] sumSubarrayBruteForce(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        int[] ans = sumSubarray(arr, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}