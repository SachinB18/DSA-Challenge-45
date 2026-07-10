// Problem 2: Check if a String Contains Only Digits
// Given a string, check whether it consists entirely of digits (no letters, spaces, or symbols).
// Input: "123456"
// Output: true

// Input: "12a45"
// Output: false

public class Problem2{
    public static boolean isDigitsOnly(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "123456";
        String str2 = "12a45";
        System.out.println(Problem2.isDigitsOnly(str1)); // Output: true
        System.out.println(Problem2.isDigitsOnly(str2)); // Output: false
    }
}

 