// Problem 3: Subarray Sum Equals K
// Given an array and an integer k, find the total number of contiguous subarrays whose sum equals k.

// Input: [1,1,1], k = 2
// Output: 2

// Approach 1: Brute Force
// Time Complexity: O(n²)
// Space Complexity: O(1)

class BruteForce{
    public static int subarraySum(int[] nums,int k){
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)count++;
            }
        }
        return count;
    }
}

import java.util.*;

// Approach 2: Prefix Sum + HashMap (Optimal)
// Time Complexity: O(n)
// Space Complexity: O(n)

class Optimal{
    public static int subarraySum(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

public class Problem3{
    public static void main(String[] args){
        int[] nums={1,1,1};
        int k=2;
        System.out.println("Brute Force: "+BruteForce.subarraySum(nums,k));
        System.out.println("Optimal: "+Optimal.subarraySum(nums,k));
    }
}