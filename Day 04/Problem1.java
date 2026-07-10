// Problem 1: Move All Zeros to the End
// Given an array, move all 0s to the end while keeping the relative order of non-zero elements, without using extra array space.
// Input: [0, 1, 0, 3, 12]
// Output: [1, 3, 12, 0, 0]

public class Problem1{
    public static void moveZero(int[] arr){
     
     //Method 1
        int zeroCount = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0) {
            zeroCount++;
        } else {
            arr[i - zeroCount] = arr[i];
        }
    }

    for (int i = arr.length - zeroCount; i < arr.length; i++) {
        arr[i] = 0;
    }


    //Method 2
        int i=0;
        while(i<arr.length){
            if(arr[i] != 0){
                i++;
            }else{
                int j = i+1;
                while(j<arr.length && arr[j]==0){
                    j++;
                }
                if(j<arr.length){
                    arr[i] = arr[j];
                    arr[j] = 0;
                }else{
                    break;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,13};
        Problem1.moveZero(arr);
        for(int num:arr){
            System.out.print(num + " ");
        }
    }
}