/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * String Encode and Decode
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 *
 * Example 1:
 * Input: ["neet","code","love","you"]
 * Output:["neet","code","love","you"]
 *
 * Example 2:
 * Input: ["we","say",":","yes"]
 * Output: ["we","say",":","yes"]
 *
 * Constraints:
 * 		0 <= strs.length < 100
 * 		0 <= strs[i].length < 200
 * 		strs[i] contains only UTF-8 characters.
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Main Class for the StringEncodeAndDecode
 */
class StringEncodeAndDecode {

	public static void main(final String[] args) {
		final List<String> strs = List.of("neet", "code", "love", "you");		// Response: is the same
		// final List<String> strs = List.of("");

		final String encodedString = encode(strs);
		final List<String> dencodedList = decode(encodedString);

		System.out.println("Input: " + strs);
		System.out.println("Encoded String: " + encodedString);
		System.out.println("De coded List: " + dencodedList);
	}

	public static String encode(List<String> strs) {
		String response = "";

		for (String str : strs) {
			response += str + "-";
		}

		return response;
	}

	public static List<String> decode(String str) {
		List<String> response = new ArrayList<>();

		if (null != str && str.contains("-")) {
			response = List.of(str.split("-"));
		}
		else {
			response.add("");
		}

		return response;
	}

}
