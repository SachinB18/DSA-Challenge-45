// Problem 2: Longest Common Prefix
// Given an array of strings, find the longest common prefix shared by all of them.
// Input: ["flower", "flow", "flight"]
// Output: "fl"

public class Problem2{
    // Brute-force: check every prefix of the first string against all others
    public static String longCommonPrefixBruteForce(String[] strs){
        if (strs == null || strs.length == 0) return "";
        String first = strs[0];
        int n = first.length();
        String longest = "";

        for (int len = 1; len <= n; len++) {
            String prefix = first.substring(0, len);
            boolean allMatch = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i] == null || !strs[i].startsWith(prefix)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                longest = prefix;
            } else {
                break;
            }
        }

        return longest;
    }

    
    // Horizontal shrink: progressively shrink prefix using startsWith
    public static String longestCommonPrefixHorizontal(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == null) return "";
            while (!strs[i].startsWith(prefix)) {
                if (prefix.length() == 0) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

        // Vertical scan: compare characters column by column
    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s == null) return "";
            minLen = Math.min(minLen, s.length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[][] tests = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"", "b"},
            new String[]{}
        };

        for (String[] t : tests) {
            System.out.println(longCommonPrefixBruteForce(t));
        }
    }
}

