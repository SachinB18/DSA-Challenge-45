// Problem 3: Maximum Subarray Sum (Kadane's Algorithm)
// Given an array of integers (may include negatives), find the contiguous subarray with the largest sum.
// Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
// Output: 6
// (subarray [4, -1, 2, 1])

 public class Problem3 {

    static void kadaneWithSubarray(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                s = i;
            } else {
                currentSum = currentSum + arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = s;
                end = i;
            }
        }

        System.out.println("Max Sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        kadaneWithSubarray(arr);
    }
}