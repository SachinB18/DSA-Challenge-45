// Problem 3: Trapping Rain Water (Simplified)
// Given an array representing elevation heights, calculate how much water can be trapped between the bars after raining.

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6


public class Problem3 {

// APPROACH 1: BRUTE FORCE
// Time Complexity : O(n²)
// Space Complexity: O(1)
    public static int trap(int[] height) {

        int water = 0;

        for (int i = 0; i < height.length; i++) {

            int leftMax = 0;

            // Find maximum height on left side
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;

            // Find maximum height on right side
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Water trapped at current index
            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }

// APPROACH 2: PREFIX & SUFFIX ARRAYS (DP)
// Time Complexity : O(n)
// Space Complexity: O(n)
    public static int trap1(int[] height) {

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Build leftMax array
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Build rightMax array
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

// APPROACH 3: TWO POINTER (OPTIMAL)
// Time Complexity : O(n)
// Space Complexity: O(1)
    public static void trappingRainWater(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }

        System.out.println(waterTrapped);
    }

    public static void main(String[] args) {
         int[] height = {4,2,0,3,2,5};

        trappingRainWater(height);

    }

}
