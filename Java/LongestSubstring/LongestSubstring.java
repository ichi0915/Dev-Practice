/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 *
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 		0 <= s.length <= 5 * 104
 * 		s consists of English letters, digits, symbols and spaces.
 *
 */

/**
 * Main Class for the LongestSubstring
 */
class LongestSubstring {

	public static void main(final String[] args) {
		// final String word = "abcabcbb";				// Response: 3
		// final String word = "bbbbb";					// Response: 1
		// final String word = "pwwkew";				// Response: 3
		// final String word = "";						// Response: 0
		final String word = "aab";						// Response: 2
		final int wordLen = lengthOfLongestSubstring(word);

		System.out.println(wordLen);
	}

	public static int lengthOfLongestSubstring(String s) {
		String words = "";
		int sLen = s.length();
		int maxLength = 0;
		int current = 0;

		for (int i = 0; i < sLen; i++) {
			char currentChar = s.charAt(i);

			while (words.contains(""+currentChar)) {
				current--;
				words = words.substring(1);
			}
			current++;

			words += currentChar;

			if (current > maxLength) {
				maxLength = current;
			}
		}

		return maxLength;
	}


}
