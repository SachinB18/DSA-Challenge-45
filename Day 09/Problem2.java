// Problem 2: String Compression
// Given a string, compress it using counts of repeated characters (e.g., "aabcccccaaa" → "a2b1c5a3"). If the compressed string isn't smaller, return the original.

// Input: "aabcccccaaa"
// Output: "a2b1c5a3"

public class Problem2{

    public static void stringCompressionBruteForce(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, append this char to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        String compressedString = compressed.toString();
        if (compressedString.length() < str.length()) {
            System.out.println(compressedString);
        } else {
            System.out.println(str);
        }

    }


    public static String compress(String str) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < str.length()) {

            char currentChar = str.charAt(i);

            int count = 0;

            // Count consecutive characters
            while (i < str.length() &&
                   str.charAt(i) == currentChar) {

                count++;
                i++;
            }

            // Add character and count
            result.append(currentChar);
            result.append(count);
        }

        // If compressed string is not smaller,
        // return original string
        if (result.length() >= str.length()) {
            return str;
        }

        return result.toString();
    }


    public static void stringCompression(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, append this char to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        String compressedString = compressed.toString();
        if (compressedString.length() < str.length()) {
            System.out.println(compressedString);
        } else {
            System.out.println(str);
        }
}
    public static void main(String[] args) {
        
    }

}