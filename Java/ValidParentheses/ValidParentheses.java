/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 		Open brackets must be closed by the same type of brackets.
 * 		Open brackets must be closed in the correct order.
 * 		Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 		1 <= s.length <= 104
 * 		s consists of parentheses only '()[]{}'.
 *
 */

import java.util.Stack;

/**
 * Main Class for the ValidParentheses
 */
class ValidParentheses {

	public static void main(final String[] args) {
		// String str = "()";
		// String str = "()[]{}";
		// String str = "(]";
		// String str = " ";
		// String str = "((";
		String str = "){";
		boolean isItValidParentheses = isValidParentheses(str);

		System.out.println(isItValidParentheses);
	}

	public static boolean isValidParentheses(final String s) {
		boolean response = true;
		Stack<Character> parenthesesStack = new Stack<Character>();

		final int strLen = s.length();

		if (0 != strLen%2) {
			response = false;
		}

		if (true == response) {
			for (int i = 0; i < strLen; i++) {
				char character = s.charAt(i);
				if (character == '{' || character == '[' || character == '(') {
					parenthesesStack.push(character);
				}
				else if (character == '}' || character == ']' || character == ')') {
					if (parenthesesStack.isEmpty()) {
						response = false;
						break;
					}
					response = isPair(parenthesesStack.pop(), character);
					if (false == response) {
						break;
					}
				}
				else {
					response = false;
					break;
				}
			}
		}

		if (!parenthesesStack.isEmpty()) {
			response = false;
		}

		return response;
	}

	public static boolean isPair(final char leftPair, final char rightPair) {
		boolean response = false;
		if (leftPair == '{' && rightPair == '}') {
			response = true;
		}
		else if (leftPair == '(' && rightPair == ')') {
			response = true;
		}
		else if (leftPair == '[' && rightPair == ']') {
			response = true;
		}
		return response;
	}

}
