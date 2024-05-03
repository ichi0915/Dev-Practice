/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Constraints:
 * 		1 <= s.length <= 5 * 104
 * 		t.length == s.length
 * 		s and t consist of any valid ascii character.
 */

import java.util.HashMap;
import java.util.Set;

/**
 * Main Class for the IsomorphicStrings
 */
class IsomorphicStrings {

	public static void main(final String[] args) {
		// Response True
		// final String s = "egg";
		// final String t = "add";

		// Response false
		// final String s = "foo";
		// final String t = "bar";

		// Response false
		// final String s = "badc";
		// final String t = "baba";

		// Response true
		final String s = "paper";
		final String t = "title";

		final boolean response = isIsomorphic(s, t);

		System.out.println("Are strings Isomorphic: " + response);
	}

	public static boolean isIsomorphic(String s, String t) {
		final int sLength = s.length();
		boolean response = true;
		final HashMap<Character, Character> map = new HashMap<>();

		if (s.length() != t.length()) {
			return false;
		}

		for (int i = 0; i < sLength; i++) {
			final char sChar = s.charAt(i);

			if (map.containsKey(sChar)) {
				final char sCharLocal = map.get(sChar);
				if (sCharLocal != t.charAt(i)) {
					response = false;
					break;
				}
			}
			else {
				if (doesMapContainValue(map, t.charAt(i))) {
					response = false;
					break;
				}
				else{
					map.put(sChar, t.charAt(i));
				}
			}
		}

		// printMap(map);
		return response;
	}

	public static boolean doesMapContainValue(final HashMap<Character, Character> map, final char value) {
		boolean response = false;

		final Set<Character> charKeySet = map.keySet();

		for (Character character : charKeySet) {
			if (map.get(character) == value) {
				response = true;
			}
		}

		return response;
	}

	public static void printMap(final HashMap<Character, Character> map) {
		final Set<Character> charKeySet = map.keySet();
		charKeySet.forEach(charKey -> {
			System.out.println("[" + charKey + "]" + map.get(charKey));
		});
	}
}
