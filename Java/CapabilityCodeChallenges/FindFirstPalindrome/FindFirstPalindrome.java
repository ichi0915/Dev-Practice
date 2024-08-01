/**
     Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

     A string is palindromic if it reads the same forward and backward.

     Example 1:
         Input: words = ["abc","car","ada","racecar","cool"]
         Output: "ada"
         Explanation: The first string that is palindromic is "ada".
         Note that "racecar" is also palindromic, but it is not the first.

     Example 2:
         Input: words = ["notapalindrome","racecar"]
         Output: "racecar"
         Explanation: The first and only string that is palindromic is "racecar".

     Example 3:
         Input: words = ["def","ghi"]
         Output: ""
         Explanation: There are no palindromic strings, so the empty string is returned.

     Constraints:

         * 1 <= words.length <= 100
         * 1 <= words[i].length <= 100
         * words[i] consists only of lowercase English letters.
 */
public class FindFirstPalindrome {

    public static String firstPalindrome(String[] words) {
        for (final String currentWord : words) {
            final int wordLen = currentWord.length();
            int leftPtr = wordLen - 1;

            for (int j = 0; j < wordLen; j++) {
                if (currentWord.charAt(j) != currentWord.charAt(leftPtr)) {
                    break;
                }

                // When we reach the middle this string is a palindrome
                if (j == leftPtr) {
                    return currentWord;
                }
                leftPtr--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Starting FindFirstPalindrome");

        String resp = firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"});
        System.out.println("Response: " + resp);

        resp = firstPalindrome(new String[]{"notapalindrome", "racecar"});
        System.out.println("Response: " + resp);

        resp = firstPalindrome(new String[]{"def","ghi"});
        System.out.println("Response: " + resp);
    }
}
