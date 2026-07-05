// Problem 2: Reverse a String
// Given a string, reverse it without using a built-in reverse method (write the logic yourself using a loop).
// Input: "hello"
// Output: "olleh"

public class Problem2{

    public static void RevString(String str){
         char[] conv = str.toCharArray();
            String rev = "";
            for(int i = conv.length-1; i>=0;i--){
                rev += conv[i];
            }
            System.out.println(rev);

    }
    public static void main(String[] args) {
        String str = "Sachin Bhabad";
        Problem2.RevString(str);
        
    }
}