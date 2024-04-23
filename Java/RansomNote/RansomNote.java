/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * 		1 <= ransomNote.length, magazine.length <= 105
 * 		ransomNote and magazine consist of lowercase English letters.
 *
 */

import java.util.HashMap;

/**
 * Main Class for the RansomNote
 */
class RansomNote {

	public static void main(final String[] args) {
		// final String ransomNote = "a";
		// final String magazine = "b";
		final String ransomNote = "aa";
		// final String magazine = "ab";
		final String magazine = "aab";

		final boolean canConstructResp = canConstruct(ransomNote, magazine);

		System.out.println(canConstructResp);
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		boolean response = true;

		final HashMap<Character, Integer> ransomMap = getMap(ransomNote);
		final HashMap<Character, Integer> magazineMap = getMap(magazine);

		for (Character ransomChars : ransomMap.keySet()) {
			final Integer amountRansom = ransomMap.get(ransomChars);
			final Integer amountMagazine = magazineMap.get(ransomChars);

			if (null != amountMagazine) {
				if (amountRansom > amountMagazine) {
					response = false;
					break;
				}
			}
			else {
				response = false;
				break;
			}
		}

		return response;
	}

	public static HashMap<Character, Integer> getMap(String charSequence) {
		final HashMap<Character, Integer> map = new HashMap<>();
		for (Character charVal : charSequence.toCharArray()) {
			Integer amount = map.get(charVal);
			if (null == amount) {
				amount = 0;
			}
			amount++;
			map.put(charVal, amount);
		}
		return map;
	}

}
