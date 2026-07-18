// Problem 1: Product of Array Except Self
// Given an array, return a new array where each element is the product of all other elements, without using division.
// Input: [1, 2, 3, 4]
// Output: [24, 12, 8, 6]


//Method 1
public class Problem1 {
    public static int[] ProductofArray(int[] arr) {
        int[] newarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = 1;
        }
        // int p = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    newarr[i] *= arr[j];
                }

            }

        }
        return newarr;
    }

    //Method 2

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Initialize the output array with 1s
        for (int i = 0; i < n; i++) {
            output[i] = 1;
        }

        // Calculate the product of elements to the left of each index
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate the product of elements to the right of each index
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4 };
        int[] result = ProductofArray(input);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}