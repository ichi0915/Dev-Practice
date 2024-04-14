/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Length of Last Word
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 * Constraints:
 * 		1 <= s.length <= 104
 * 		s consists of only English letters and spaces ' '.
 * 		There will be at least one word in s.
 *
 */


/**
 * Main Class for the LengthOfLastWord
 */
class LengthOfLastWord {

	public static void main(final String[] args) {
		// final String word = "Hello World";							// Response: 5
		// final String word = "   fly me   to   the moon  ";			// Response: 4
		// final String word = "luffy is still joyboy";					// Response: 6
		// final String word = "Today is a nice day";					// Response: 3
		// final String word = "   fly me   to   the moon  ";			// Response: 4
		final String word = "A";										// Response: 1
		final int wordLen = lengthOfLastWord(word);

		System.out.println(wordLen);
	}

	public static int lengthOfLastWord(String s) {
		int response = 0;
		int currentLen = 0;
		final int strLen = s.length();

		for (int i = 0; i < strLen; i++) {
			if (s.charAt(i) == ' ') {
				if (0 != currentLen) {
					response = currentLen;
				}
				currentLen = 0;
			}
			else if (i+1 == strLen) {
				currentLen++;
				if (1 != currentLen) {
					response = currentLen;
				}
			}
			else {
				currentLen++;
			}
		}

		if (0 != currentLen) {
			response = currentLen;
		}

		return response;
	}

	public static int lengthOfLastWordUsingTrim(String s) {
		int response = 0;
		int currentLen = 1;
		s = s.trim();
		final int strLen = s.length();

		for (int i = 0; i < strLen; i++) {
			if (s.charAt(i) == ' ') {
				currentLen = 0;
			}
			else if (i+1 == strLen) {
				response = currentLen;
			}
			currentLen++;
		}

		return response;
	}

	public static int lengthOfLongestWord(String s) {
		int response = 0;
		int currentLongest = 0;
		final int strLen = s.length();

		for (int i = 0; i < strLen; i++) {
			if (s.charAt(i) == ' ') {
				if (currentLongest > response) {
					response = currentLongest;
				}
				currentLongest = 0;
			}
			else if (i+1 == strLen) {
				currentLongest++;
				if (currentLongest > response) {
					response = currentLongest;
				}
			}
			else {
				currentLongest++;
			}
		}

		return response;
	}

}
