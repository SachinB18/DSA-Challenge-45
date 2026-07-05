// Problem 3: Check if a String is a Palindrome
// Given a string, check whether it reads the same forwards and backwards (ignore case).
// Input: "Madam"
// Output: true

 public class Problem3{
    static boolean isPalindrome(String str){
        String rev = "";
        char[] conv = str.toCharArray();
        for(int i = conv.length-1; i>=0;i--){
            rev += conv[i];
        }
        if(rev.equalsIgnoreCase(str)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        
    }
 }