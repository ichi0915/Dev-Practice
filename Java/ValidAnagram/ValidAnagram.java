/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 *
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *   1 <= s.length, t.length <= 5 * 104
 *   s and t consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Main Class for the ValidAnagram
 */
class ValidAnagram {

	public static void main(final String[] args) {
		String str = "anagram";
		String str2 = "nagaram";
		// String str = "rat";
		// String str2 = "car";
		boolean isItAnagram = isAnagram(str, str2);

		System.out.println(isItAnagram);
	}

	public static boolean isAnagram(String s, String t) {
		boolean response = true;

		if (s.length() != t.length()) {
			response = false;
		}
		else {
			Map<Character, Integer> sValueMap = getValueMap(s);
			Map<Character, Integer> tValueMap = getValueMap(t);

			for (Map.Entry<Character, Integer> value : sValueMap.entrySet()) {
				if (!tValueMap.containsKey(value.getKey()) ||
						value.getValue().intValue() != tValueMap.get(value.getKey()).intValue()) {
					response = false;
					break;
				}
			}

		}

		return response;
	}

	public static Map<Character, Integer> getValueMap(String str) {
		final Map<Character, Integer> valueMap = new HashMap<Character, Integer>();
		final int strLen = str.length();

		for (int i=0; i < strLen; i++) {
			Integer amount = valueMap.get(str.charAt(i));
			if (null == amount) {
				amount = 0;
			}
			amount++;
			
			valueMap.put(str.charAt(i), amount);
		}
		return valueMap;
	}

}
