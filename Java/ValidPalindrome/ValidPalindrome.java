/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Constraints:
 *     1 <= s.length <= 2 * 105
 *     s consists only of printable ASCII characters.
 */

/**
 * Main Class for the ValidPalindrome
 */
class ValidPalindrome {

	public static void main(final String[] args) {
		String str = "A man, a plan, a canal: Panama";
		// String str = "race a car";
		// String str = " ";
		boolean isItPalindrome = isPalindrome(str);

		System.out.println(isItPalindrome);
	}

	public static boolean isPalindrome(String s) {
		boolean response = true;
		final String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		final int len = str.length() - 1;
		int end = len;

		for (int i = 0; i <= len; i++) {
			// System.out.println("i: " + str.charAt(i) + "- end:" + str.charAt(end));
			if (str.charAt(i) != str.charAt(end--)) {
				response = false;
				break;
			}
		}

		return response;
	}

}
