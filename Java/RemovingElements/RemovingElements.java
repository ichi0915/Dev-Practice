/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Removing Elements Function.
 *
 * <p>Exercise: Take an array and remove every second element from the array.
 * Always keep the first element and start removing with the next element.
 *
 * Example:
 * 		["Keep", "Remove", "Keep", "Remove", "Keep", ...] --> ["Keep", "Keep", "Keep", ...]
 *
 * None of the arrays will be empty, so you don't have to worry about that!
 */
import java.util.Arrays;

/**
 * Main Class for the RemovingElements
 */
class RemovingElements {

	public static void main(final String[] args) {
		final Object[] obj = new Object[] {"Hello", "Goodbye", "Hello Again"};
		// final Object[] obj = new Object[] {1, 2};
		// final Object[] obj = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// final Object[] obj = new Object[] {"Goodbye"};
		// final Object[] obj = new Object[] {};

		Object[] response = removeEveryOther(obj);

		printObj(response);
	}

	public static Object[] removeEveryOther(Object[] arr) {
		int len = arr.length;
	
		if (len % 2 != 0) {
			len = len / 2;
			len++;
		}
		else {
			len = len / 2;
		}
	
		Object[] response = new Object[len];
		int count = 0;
	
		for (int i=0; i < arr.length ; i ++) {
			if (i % 2 == 0) {
				response[count++] = arr[i];
			}
		}
	 
		return response;
	}

	public static void printObj(Object[] obj) {
		for (int i=0; i < obj.length ; i ++) {
			System.out.println(Arrays.toString(obj));
		}
	}
}
