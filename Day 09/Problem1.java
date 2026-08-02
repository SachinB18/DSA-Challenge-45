// Problem 1: Three Sum
// Given an array of integers, find all unique triplets that sum to zero.
// Input: [-1, 0, 1, 2, -1, -4]
// Output: [[-1, -1, 2], [-1, 0, 1]]

import java.util.*;

public class Problem1 {
    // Brute force
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == 0) {

                        List<Integer> triplet = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k]);

                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }

    //------------------------------------------Sorting + two pointer-----------------------------------------------------

     public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Set two pointers
            int left = i + 1;
            int right = nums.length - 1;

            // Step 4: Find the other two elements
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    // We found a valid triplet
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    // Move both pointers
                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    // Sum is too small
                    // Move left to a larger value
                    left++;

                } else {

                    // Sum is too large
                    // Move right to a smaller value
                    right--;
                }
            }
        }

        return result;
    }





    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }
}