// Problem 3: Container With Most Water
// Given an array where each element represents a vertical line's height, find
// two lines that together with the x-axis form the container holding the most
// water.
// Input: [1, 8, 6, 2, 5, 4, 8, 3, 7]
// Output: 49

public class Problem3 {
    // Brute-force: check every pair of lines
    public static int maxAreaBruteForce(int[] height) {
        if (height == null || height.length < 2) return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Two-pointer approach: start with the widest container and move inward
    public static int maxAreaTwoPointer(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        
        
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area (Brute Force): " + maxAreaBruteForce(height));
        System.out.println("Max Area (Two Pointer): " + maxAreaTwoPointer(height));
        
    }


}