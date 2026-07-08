
// Problem 1: Find the Second Largest Element in an Array
// Given an array of integers, find the second largest element (without sorting, using a single pass).
// Input: [3, 7, 2, 9, 4]
// Output: 7

public class Problem1{

    public static int secLargest(int[] arr){
         int largest = Integer.MIN_VALUE;
         int secLargest = Integer.MIN_VALUE;

         for(int i=0;i<arr.length; i++){
             if(arr[i] > largest){
                  secLargest = largest;
                largest = arr[i];
              
             }else if (arr[i] < largest && arr[i] > secLargest){
                secLargest = arr[i];
             }
         }
         return secLargest;
         
    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,7,13,8};
        int result = secLargest(arr);
        System.out.println(result);
        
    }
   
}