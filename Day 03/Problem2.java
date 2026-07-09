// Problem 2: Count Occurrences of Each Character in a String
// Given a string, print the frequency of each character in it.
// Input: "success"
// Output: s:3, u:1, c:2, e:1

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Problem2 {

    // Approach 1: Array frequency count
    // Description:
    // Use an array to store counts of characters directly by their ASCII/Unicode index.
    // This is fast and simple when you only need raw frequency counting.
    public static void frequencyByArray(String str) {
        int[] freq = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        System.out.println("Array approach:");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }

    // Approach 2: HashMap
    // Description:
    // Store each character as a key and its count as the value.
    // This works well for any string and is easy to understand.
    public static void frequencyByHashMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("HashMap approach:");
        for (Character key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    // Approach 3: LinkedHashMap
    // Description:
    // Same idea as HashMap, but it keeps the characters in the order they first appear.
    // Useful when you want the output order to match the original string.
    public static void frequencyByLinkedHashMap(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("LinkedHashMap approach:");
        for (Character key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    // Approach 4: Sorting and scanning
    // Description:
    // Sort the characters first, then count consecutive same characters.
    // This is easy to follow, but slower because sorting is required.
    public static void frequencyBySorting(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        System.out.println("Sorting approach:");

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.println(arr[i - 1] + ": " + count);
                count = 1;
            }
        }

        if (arr.length > 0) {
            System.out.println(arr[arr.length - 1] + ": " + count);
        }
    }

    public static void main(String[] args) {
        String str = "success";

        frequencyByArray(str);
        System.out.println();

        frequencyByHashMap(str);
        System.out.println();

        frequencyByLinkedHashMap(str);
        System.out.println();

        frequencyBySorting(str);
    }
}