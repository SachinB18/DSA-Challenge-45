// Problem 3: Check if a String is a Rotation of Another
// Given two strings, check if one is a rotation of the other.
// Input: "waterbottle", "erbottlewat"
// Output: true

public class Problem3 {

    // Brute-force: generate rotations
    static boolean isRotationBrute(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        for (int shift = 0; shift < n; shift++) {
            String rot = s1.substring(shift) + s1.substring(0, shift);
            if (rot.equals(s2))
                return true;
        }
        return false;
    }

    // Concat-check: recommended (simple + fast in practice)
    static boolean isRotationConcat(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "erbottlewat";
        System.out.println(isRotationBrute(a, b)); // true
        System.out.println(isRotationConcat(a, b)); // true
    }
}