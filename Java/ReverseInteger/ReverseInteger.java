/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Reverse Integer
 *
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 * 		-2^31 <= x <= 2^31 - 1
 */


/**
 * Main Class for the ReverseInteger
 */
class ReverseInteger {

	public static void main(final String[] args) {
		final int x = 123;							// Response: 321
		// final int x = -123;						// Response: -321
		// final int x = 120;						// Response: 21
		// final int x = 9646324351;				// Response: 0  -- 0 because it's out of range

		final int reversedInt = reverse(x);

		System.out.println(reversedInt);
	}

	// One-pass algorithm counting
	public static int reverse(int x) {
		int response = 0;
		String responseStr = "";

		final String str = String.valueOf(x);
		final char[] charArray = str.toCharArray();
		int arrayStart = 0;

		if (x < 0) {
			arrayStart++;
		}

		for (int i = charArray.length-1; i >= arrayStart; i--) {
			responseStr += charArray[i];
		}

		try {
			response = Integer.parseInt(responseStr);
		}
		catch (Exception e) {
			response = 0;
		}

		if (x < 0) {
			response *= -1;
		}

		return response;
	}

}
