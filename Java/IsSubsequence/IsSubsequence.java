/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Is Subsequence Function.
 *
 * 392. Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 * 		0 <= s.length <= 100
 * 		0 <= t.length <= 104
 * 		s and t consist only of lowercase English letters.
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */

/**
 * Main Class for the Candy
 */
class IsSubsequence {

	public static void main(final String[] args) {
		// final String s = "abc";
		// final String t = "ahbgdc";		// Response: true

		// final String s = "axc";
		// final String t = "ahbgdc";		// Response: false

		// final String s = "acb";
		// final String t = "ahbgdc";		// Response: false

		// final String s = "";
		// final String t = "ahbgdc";		// Response: true

		final String s = "b";
		final String t = "abc";				// Response: true

		final boolean isSubsequence = isSubsequence(s, t);

		System.out.println("Is Subsequence: " + isSubsequence);
	}


	public static boolean isSubsequence(String s, String t) {
		boolean response = false;

		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int j = 0;

		for (int i = 0; i < tChars.length; i++) {
			if (j >= sChars.length) {
				break;
			}
			if (tChars[i] == sChars[j]) {
				j++;
			}
		}

		if (s.length() == j) {
			response = true;
		}

		return response;
	}

}
