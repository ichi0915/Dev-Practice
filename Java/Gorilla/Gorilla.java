/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

/**
 * Main Class for Gorilla
 */
class Gorilla {

	public static void main(final String[] args) {
		String pass = "myPassword#1"; // true
		Boolean resp = isValidPassword(pass);
		System.out.println("Correct true, Actual: " + resp);

		pass = "complicatedPass"; // false
		resp = isValidPassword(pass);
		System.out.println("Correct false, Actual: " + resp);

		pass = "Pass#1%!"; // false
		resp = isValidPassword(pass);
		System.out.println("Correct false, Actual: " + resp);

		pass = "123@PaSS"; // false
		resp = isValidPassword(pass);
		System.out.println("Correct false, Actual: " + resp);
	}

	/*
	 * 8 characters long
	 * upper, lowe, digits, special
	 * not more tan 20% special
	 * no psaces, periods, commas
	 * no secuentiona leters
	 */
	public static Boolean isValidPassword(String password) {
		int passLen = password.length();

		if (passLen < 8)
			return false;

		for (char ch : password.toCharArray()) {
			if (ch == ',' || ch == ' ' || ch == '.')
				return false;
		}

		boolean hasUppercases = false;
		boolean hasLowercases = false;
		boolean hasDigits = false;
		int specialChars = 0;
		double limitAmountSpecialChar = passLen * .2;

		for (int i = 0, n = passLen; i < n; i++) {
			char c = password.charAt(i);
			if (Character.isDigit(c)) {
				hasDigits = true;
			} else if (Character.isUpperCase(c)) {
				hasUppercases = true;
			} else if (Character.isLowerCase(c)) {
				hasLowercases = true;
			} else {
				specialChars++;
			}
		}

		// System.out.println("AAA");
		// System.out.println("\n\n ===== " + password + " =====");
		// System.out.println("passLen: " + passLen);
		// System.out.println("limitAmountSpecialChar: " + limitAmountSpecialChar);
		// System.out.println("specialChars: " + specialChars);

		if (!hasUppercases || !hasLowercases || !hasDigits || (specialChars <= 0)) {
			return false;
		}

		if (specialChars > limitAmountSpecialChar) {
			return false;
		}

		// System.out.println("ZZZ");

		// no secuentional letters
		for (int i = 0; i < passLen - 3; i++) {
			// System.out.println("password.charAt(i): " + password.charAt(i));
			if (((int) password.charAt(i) == (int) password.charAt(i + 1) + 1) &&
					((int) password.charAt(i + 1) == (int) password.charAt(i + 2) + 1) &&
					((int) password.charAt(i + 2) == (int) password.charAt(i + 3) + 1)) {
				return false;
			}
		}

		// for(int i = 0; i < passLen - 3; i++) {
		// if(((int)password.charAt(i)+1 == (int)password.charAt(i+1))&&
		// ((int)password.charAt(i+2)+1 == (int)password.charAt(i+3))) {
		// return false;
		// }
		// }

		return true;
	}

}
