// Problem 3: Group Anagrams
// Given an array of strings, group all anagrams together.
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
// Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

import java.util.*;

public class Problem3 {

    // ============================================================
    // APPROACH 1: BRUTE FORCE
    // Time: O(N^2 * K log K)
    // Space: O(N)
    // ============================================================

    public static void groupAnagramsBruteForce(String[] strs) {

        if (strs == null || strs.length == 0) {
            return;
        }

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            // Skip the string if it is already grouped
            if (visited[i]) {
                continue;
            }

            // Sort the current string
            char[] chars1 = strs[i].toCharArray();
            Arrays.sort(chars1);

            String key1 = new String(chars1);

            System.out.print("[" + strs[i]);

            // Compare current string with remaining strings
            for (int j = i + 1; j < strs.length; j++) {

                if (visited[j]) {
                    continue;
                }

                // Sort the other string
                char[] chars2 = strs[j].toCharArray();
                Arrays.sort(chars2);

                String key2 = new String(chars2);

                // If sorted strings are equal, they are anagrams
                if (key1.equals(key2)) {
                    System.out.print(", " + strs[j]);

                    // Mark as already grouped
                    visited[j] = true;
                }
            }

            System.out.println("]");
        }
    }

    // ============================================================
    // APPROACH 2: BEST APPROACH
    // HashMap + Sorting
    //
    // Time: O(N * K log K)
    // Space: O(N * K)
    // ============================================================

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Sorted string becomes the key
            String key = new String(chars);

            // If key doesn't exist, create a new group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original string to its anagram group
            map.get(key).add(str);
        }

        // Return all groups
        return new ArrayList<>(map.values());
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        String[] strs = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };

        // --------------------------------------------------------
        // BRUTE FORCE
        // --------------------------------------------------------

        System.out.println("Brute Force Approach:");

        groupAnagramsBruteForce(strs);

        // --------------------------------------------------------
        // BEST APPROACH
        // --------------------------------------------------------

        System.out.println("\nBest Approach (HashMap):");

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}
