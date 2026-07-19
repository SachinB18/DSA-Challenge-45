public class Problem2 {

    public static int remDuplicates(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return 0;
        }

        int i = 0;

        for (int j = 1; j < arr.length; j++) {

            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {5, 6, 8, 8, 8, 10};

        int newLength = Problem2.remDuplicates(arr);

        System.out.println("New Length: " + newLength);

        System.out.print("Array: ");

        for (int n = 0; n < newLength; n++) {
            System.out.print(arr[n] + " ");
        }
    }
}