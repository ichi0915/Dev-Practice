/**
 * This file contains the Spiral Matrix Function.
 *
 * <p>Exercise: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 *     1 <= n <= 8
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class for the GenerateParentheses
 */
class GenerateParentheses {

	public static void main(final String[] args) {
		System.out.println("Result Parenthesis: " + generateParenthesis(1));		// ["()"]
		System.out.println("Result Parenthesis: " + generateParenthesis(2));		// ["(())","()()"]
		System.out.println("Result Parenthesis: " + generateParenthesis(3));		// ["((()))","(()())","(())()","()(())","()()()"]
		System.out.println("Result Parenthesis: " + generateParenthesis(4));		// ["(((())))","((()()))","(()()())","(()())()","()(()())","(())()()","()(())()","()()(())","()()()()"]
	}

	public static List<String> generateParenthesis(int n) {
		//Approach: using Backtracking
		List<String> response = new ArrayList<>();
		backtrack("", n, n, response);
		return response;
	}

	public static void backtrack(String s, int open, int close, List<String> response){
		// base case
		if(open>close) return;
		if(open>0){
			backtrack(s+"(", open-1, close, response);
		}
		if(close>0){
			backtrack(s+")", open, close-1, response);
		}
		if(open==0 && close==0){
			response.add(s);
		}
	}

	// backtrack does a parenthesis balanced string, count of ')' must be less than equal to count of '(' for every prefix of the string.
	// A parenthesis balanced string (of size 2*N) must have N number of '(' and N number of ')'.
	// We go on adding '(' before ')' for every recursive state string until count of '(' becomes equal to N.
	// Then we start adding ')' only on a condition that count of ')' is less than count of '('.
	// These two conditions will always produce balanced string.

	// == Ejemplo de 3 ==

	// (
	// ((
	// (((
	// ((()
	// ((())
	// ((()))
	// (()
	// (()(
	// (()()
	// (()())
	// (())
	// (())(
	// (())()
	// ()
	// ()(
	// ()((
	// ()(()
	// ()(())
	// ()()
	// ()()(
	// ()()()

	/*
	public static List<String> generateParenthesisOld(int n) {
		List<String> response = new ArrayList<>();

		if (0 == n)
			return response;
		if (1 == n) {
			response.add("()");
			return response;
		}

		response.add(simple(n));
		response.add(allIn(n));

		if (3 <= n) {
			response.add(insideParenthesis(n));
			response.addAll(combinations(n));
		}

		return response;
	}

	// returns () an amount of n times
	public static String simple(int n) {
		String response = "";
		for (int i = 0; i < n; i++) {
			response += "()";
		}
		return response;
	}

	// returns nested parenthesis an amount of n times
	public static String allIn(int n) {
		String response = "";
		for (int i = 0; i < n; i++) {
			response = "(" + response + ")";
		}
		return response;
	}

	// returns one parenthesis surrounding all the n-1 ones
	public static String insideParenthesis(int n) {
		return "(" + simple(n-1) + ")";
	}

	// "(())()",   "()(())"
	// ((()()))",  "(()())()",  "()(()())",  "(())()()",  "()(())()",  "()()(())"
	// returns inside levels
	public static List<String> combinations(int n) {
		List<String> response = new ArrayList<>();
		String paren = "()";
		int amountR = n -1;

		String tmp = insideParenthesis(2);
		// for (int i = 0; i < amountR; i++) {
		// 	tmp
		// 	response.add();
		// }
		return response;
	}
	*/

}
