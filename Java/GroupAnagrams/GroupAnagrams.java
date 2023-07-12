/**
 * This file contains the Group Anagrams Function.
 *
 * <p>Exercise:
 *  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 *  1 <= strs.length <= 104
 *  0 <= strs[i].length <= 100
 *  strs[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main Class for the GetTheGroups
 */
class GroupAnagrams {

	public static void main(final String[] args) {
		// [["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]]
		// String[] vals = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};

		String[] vals = {"eat", "tea", "tan", "ate", "nat", "bat"};		// [["bat"],["nat","tan"],["ate","eat","tea"]]
		// String[] vals = {""};		// [[""]]
		// String[] vals = {"a"};		// [["a"]]
		List<List<String>> finalList = groupAnagrams(vals);

		// printAnagrams(finalList);
		System.out.println("Result List: " + finalList);
	}

	// V2 - Time Limit Exceeded - 111 / 118 test cases passed
	public static List<List<String>> groupAnagrams(String[] strs) {
		final List<List<String>> response = new ArrayList<>();
		Boolean added = false;
		List<String> innerList = new ArrayList<>();
		String[] strsRemaining = strs;

		for (String str : strs) {
			for (String str2 : strsRemaining) {
				// SOLUTION 2 - Time Limit Exceeded
				char[] first = str.toCharArray();
				char[] second = str2.toCharArray();
				Arrays.sort(first);
				Arrays.sort(second);

				if (Arrays.equals(first, second) ) {
					if (!added) {
						// System.out.println("Result List: " + str);
						if (innerList.contains(str)) {
							innerList.add(str);
							strsRemaining = removeVal(strsRemaining, str);
						}
						added = true;
					}
					// System.out.println("Result List: " + str2);
					innerList.add(str2);
					strsRemaining = removeVal(strsRemaining, str2);
				}
			}
			if (added) {
				response.add(innerList);
				innerList = new ArrayList<>();
			}
			// System.out.println("response: " + response);
			added = false;
		}

		// If empty add a value
		if (0 == response.size()) {
			if (null != strs[0])
				innerList.add(strs[0]);
			else
				innerList.add("");
			response.add(innerList);
		}

		return response;
	}
	// V2 - Time Limit Exceeded

	// V1 - Time Limit Exceeded - 108 / 118 test cases passed
	public static List<List<String>> groupAnagramsV1(String[] strs) {
		final List<List<String>> response = new ArrayList<>();
		Boolean added = false;
		List<String> innerList = new ArrayList<>();
		// int i = 1;

		for (String str : strs) {
			for (String str2 : strs) {
				if (!checkIfExistInList(response, str2)) {
					// System.out.println("str: " + str + " str2: " + str2);

					// SOLUTION 1 - Incorrect
					// if (str.chars().sum() == str2.chars().sum()) {

					// SOLUTION 3 - Incorrect
					// if (hasSameChar(str, str2) ) {

					// SOLUTION 2 - Time Limit Exceeded
					char[] first = str.toCharArray();
					char[] second = str2.toCharArray();
					Arrays.sort(first);
					Arrays.sort(second);

					if (Arrays.equals(first, second) ) {
						if (!added) {
							// System.out.println("Result List: " + str);
							if (innerList.contains(str)) {
								innerList.add(str);
							}
							added = true;
						}
						// System.out.println("Result List: " + str2);
						innerList.add(str2);
					}
				}
			}
			if (added) {
				response.add(innerList);
				innerList = new ArrayList<>();
			}
			// System.out.println("response: " + response);
			added = false;
		}

		// If empty add a value
		if (0 == response.size()) {
			if (null != strs[0])
				innerList.add(strs[0]);
			else
				innerList.add("");
			response.add(innerList);
		}

		return response;
	}
	// V1 - Time Limit Exceeded

	public static Boolean checkIfExistInList(List<List<String>> anagramList, String value) {
		Boolean response = false;
		for (List<String> anagram : anagramList) {
			for (String val : anagram) {
				if (val.equals(value)) {
					response = true;
					break;
				}
			}
		}
		return response;
	}

	public static String[] removeVal(String[] strs, String valueToRemove) {
		String[] response = new String[ strs.length - 1 ];
		int i = 0;
		for (String val : strs) {
			if (val != valueToRemove) {
				response[i] = val;
				i++;
			}
		}
		return response;
	}

	// Incorrect
	// public static boolean hasSameChar(String str1, String str2) {
	// 	for(char c : str1.toCharArray()){
	// 		if(str2.indexOf(c) < 0 ) return false;
	// 	}
	// 	for(char c : str2.toCharArray()){
	// 		if(str1.indexOf(c) < 0 ) return false;
	// 	}
	// 	return true;
	// }

	public static void printAnagrams(List<List<String>> anagrams) {
		anagrams.iterator().forEachRemaining(anagram -> {
			anagram.iterator().forEachRemaining(val -> {
				System.out.print(" Val: " + val);
			});
			System.out.println("");
		});
	}

}
