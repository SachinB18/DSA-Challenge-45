// Problem 3: Check if Two Strings are Anagrams
// Given two strings, check if one is an anagram of the other (same letters, same frequency, different order).
// Input: "listen", "silent"
// Output: true

public class Problem3{

    public static boolean checkAnagram(String str1,  String str2){
         if(str1.length() != str2.length()){
            return false;
         }

         char[] arr1 = str1.toLowerCase().toCharArray();
         char[] arr2 = str2.toLowerCase().toCharArray();

         int[  ] freq = new int[26];
          
         for(int i=0;i<arr1.length; i++){
            freq[arr1[i] - 'a']++;
         }

         for(int i=0; i<arr2.length;i++){
            freq[arr2[i] - 'a']--;
         }
         for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(checkAnagram(str1, str2));
    }
    
}