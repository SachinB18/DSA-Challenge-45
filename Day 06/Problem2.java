// Problem 2: Longest Substring Without Repeating Characters
// Given a string, find the length of the longest substring without repeating characters.
// Input: "abcabcbb"
// Output: 3
// ("abc")
public class Problem2{

    static void longSubstring(String str){
        int longestSubstring = Integer.MIN_VALUE;

        for(int i=0;i<str.length();i++){
            String substring = "";
            for(int j=i;j<str.length();j++){
                if(substring.contains(String.valueOf(str.charAt(j)))){
                    break;
                }
                substring += str.charAt(j);
            }
            longestSubstring = Math.max(longestSubstring,substring.length());
        }
    }
    public static void main(String[] args) {
        
    }
}