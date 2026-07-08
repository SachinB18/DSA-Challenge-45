// Problem 2: Count Vowels and Consonants in a String
// Given a string, count how many vowels and consonants it contains.
// Input: "Hello World"
// Output: Vowels = 3, Consonants = 7

public class Problem2{
    public static void vowelsConsonantsCount(String str){
         int vowels = 0;
         int consonents = 0;



         char[] word = str.toCharArray();

         for(int i=0;i<word.length;i++){
            char ch = Character.toLowerCase(word[i]);
             if(ch >= 'a' && ch <= 'z'){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels++;
                }else{
                    consonents++;
                }
             }
         }
        System.out.print("Vowels: " + vowels + "\nconsonents: " + consonents );

    }
    public static void main(String[] args) {
        String str = "Sach$in";
        Problem2.vowelsConsonantsCount(str);
        
        
    }
}