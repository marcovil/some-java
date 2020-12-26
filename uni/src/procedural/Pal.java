package procedural;

public class Pal {

    public static void main(String[] args) {
        String[] stringhe_prova = {"abba", "a", "aa", "ab", "aba", "catastrofe", "cattapoopattac"};
        for (String i : stringhe_prova) {
            System.out.println(isPalindrome(i));
        }
    }

    /**
     * isPalindrome returns true if the string s is palindrome
     * (if read from left to right or right to left, s is the same)
     * @param s the String to be checked, REQUIRE not null, no whitespace, no punctuation, all lowercase
     */
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i<=j && s.charAt(i)==s.charAt(j)) {
            i = i+1;
            j = j-1;
        }
        return(i>j);
    }

}

// too constrained