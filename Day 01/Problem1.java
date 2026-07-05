// Problem 1: Find the Largest Element in an Array
// Given an array of integers, find and return the largest element.
// Input: [3, 7, 2, 9, 4]
// Output: 9

 public class Problem1{

    public static int FindLargestElement(int[] arr){
         int largest = Integer.MIN_VALUE;
         for(int i =0; i<arr.length;i++){
             if(arr[i] > largest){
                 largest = arr[i];
             }
         }
         return largest;
    }
     public static void main(String[] args) {
        int ans = Problem1.FindLargestElement(new int[]{1,4,5,2,10,4,12,-25});
        System.out.println(ans);
     }
 }