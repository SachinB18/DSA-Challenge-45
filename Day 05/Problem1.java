// Problem 1: First Non-Repeating Character in a String
// Given a string, find the first character that doesn't repeat.
// Input: "swiss"
// Output: 'w'

//Frequency array approach

public class Problem1 {
    static void nonRepeatingCharacter(String str) {

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
                return;
            }
        }

        System.out.println("No non-repeating character found");
    }
    

//    Nested loop approach


    static void nonRepeatingCharacter1(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isRepeating = false;

            for (int j = 0; j < str.length(); j++) {
                if (i != j && ch == str.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }

            if (!isRepeating) {
                System.out.println(ch);
                return;
            }
        }

        System.out.println("No non-repeating character found");
    }

    public static void main(String[] args) {
        String str = "swiss";
        nonRepeatingCharacter(str); // Output: w
    }

}