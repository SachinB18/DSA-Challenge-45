// Problem 3: Rotate an Array by K Positions
// Given an array and a number k, rotate the array to the right by k positions.
// Input: [1, 2, 3, 4, 5], k = 2
// Output: [4, 5, 1, 2, 3]

import java.util.Arrays;

public class Problem3 {

	// Approach 1: Brute Force
	// Description:
	// Rotate the array by 1 position, and repeat that process k times.
	// This is the easiest to understand, but it is not efficient for large k.
	public static void rotateByBruteForce(int[] arr, int k) {
		int n = arr.length;
		k = k % n;

		for (int r = 0; r < k; r++) {
			int last = arr[n - 1];

			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = last;
		}

		System.out.println("Brute Force: " + Arrays.toString(arr));
	}

	// Approach 2: Extra Array
	// Description:
	// Create a new array and place each element in its rotated position.
	// This is simple and clean, but it uses extra memory.
	public static void rotateByExtraArray(int[] arr, int k) {
		int n = arr.length;
		k = k % n;
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			temp[(i + k) % n] = arr[i];
		}

		System.out.println("Extra Array: " + Arrays.toString(temp));
	}

	// Approach 3: Reversal Algorithm
	// Description:
	// Reverse the full array, then reverse the first k elements, and finally
	// reverse the remaining n-k elements. This is the best in-place approach.
	public static void rotateByReversal(int[] arr, int k) {
		int n = arr.length;
		k = k % n;

		reverse(arr, 0, n - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);

		System.out.println("Reversal: " + Arrays.toString(arr));
	}

	// Helper method used by the reversal approach.
	private static void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	// Approach 4: Cyclic Replacement
	// Description:
	// Move each element directly to its final position in cycles.
	// This is in-place and efficient, but the logic is harder to follow.
	public static void rotateByCyclicReplacement(int[] arr, int k) {
		int n = arr.length;
		k = k % n;
		int count = 0;

		for (int start = 0; count < n; start++) {
			int current = start;
			int prev = arr[start];

			do {
				int next = (current + k) % n;
				int temp = arr[next];
				arr[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}

		System.out.println("Cyclic Replacement: " + Arrays.toString(arr));
	}

	// Approach 5: Juggling Algorithm
	// Description:
	// Divide the array into groups using the GCD of n and k, then rotate each group.
	// This is also in-place, but it is more advanced than the reversal method.
	public static void rotateByJuggling(int[] arr, int k) {
		int n = arr.length;
		k = k % n;
		int shift = n - k;
		int gcd = gcd(n, shift);

		if (k == 0) {
			System.out.println("Juggling: " + Arrays.toString(arr));
			return;
		}

		for (int i = 0; i < gcd; i++) {
			int temp = arr[i];
			int j = i;

			while (true) {
				int next = (j + shift) % n;
				if (next == i) {
					break;
				}
				arr[j] = arr[next];
				j = next;
			}

			arr[j] = temp;
		}

		System.out.println("Juggling: " + Arrays.toString(arr));
	}

	// Helper method for the juggling approach.
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int k = 2;

		rotateByBruteForce(arr.clone(), k);
		rotateByExtraArray(arr.clone(), k);
		rotateByReversal(arr.clone(), k);
		rotateByCyclicReplacement(arr.clone(), k);
		rotateByJuggling(arr.clone(), k);
	}
}

