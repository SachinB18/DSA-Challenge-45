// Problem 2: Merge Two Sorted Arrays
// Given two sorted arrays, merge them into a single sorted array (without using built-in sort).
// Input: [1, 3, 5], [2, 4, 6]
// Output: [1, 2, 3, 4, 5, 6]

 public class Problem2 {
    static void mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] newarr = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                newarr[k++] = arr1[i++];
            } else {
                newarr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            newarr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            newarr[k++] = arr2[j++];
        }

        for (int m : newarr) {
            System.out.print(m + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        mergeArrays(arr1, arr2); // 1 2 3 4 5 6
    }
}