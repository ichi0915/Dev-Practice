/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 * 		n == nums.length
 * 		1 <= n <= 300
 * 		nums[i] is either 0, 1, or 2.
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 *
 */


/**
 * Main Class for the SortColors
 */
class SortColors {

	public static void main(final String[] args) {
		final int[] colors = {2,0,2,1,1,0};						// Response: [0,0,1,1,2,2]
		// final int[] colors = {2,0,1};						// Response: [0,1,2]
		sortColors(colors);

		printArray(colors);
	}

	// One-pass algorithm counting
	public static void sortColors(int[] nums) {
		int amountZero = 0, amountOnes = 0;

		for (int num : nums) {
			if (0 == num) {
				amountZero++;
			}
			else if (1 == num) {
				amountOnes++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (amountZero != 0) {
				nums[i] = 0;
				amountZero--;
			}
			else if (amountOnes != 0) {
				nums[i] = 1;
				amountOnes--;
			}
			else {
				nums[i] = 2;
			}
		}
	}

	// Works but its bubble sort and super slow
	public static void sortColorsBubble(int[] nums) {
		boolean notSorted = true;

		while (notSorted) {
			notSorted = false;
			for (int i = 0; i < nums.length-1; i++) {
				if (nums[i] > nums[i+1]) {
					int tmp = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = tmp;
					notSorted = true;
				}
			}
		}
	}


	// One-pass algorithm -- test (does not work on all cases)
	/* public static void sortColors(int[] nums) {
		int start = 0;
		int mid = 1;
		// int finish = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (0 == nums[i]) {
				nums[i] = nums[start];
				nums[start++] = 0;
				// if (0 != i || ) {
				// 	mid++;
				// }
			}
			// else if (2 == nums[i]) {
			// 	nums[i] = nums[finish];
			// 	nums[finish--] = 2;
			// }
			else if (1 == nums[i]) {
				nums[i] = nums[mid];
				nums[mid++] = 1;
			}
			// else if (1 == nums[i]) {
			// 	nums[i] = nums[start+1];
			// 	nums[start+1] = 1;
			// }

			// System.out.print(mid + "=");
			printArray(nums);

		}
	}*/

	public static void printArray(int[] nums) {
		for (int num : nums) {
			System.out.print(num + "-");
		}
		System.out.println("");
	}

}
