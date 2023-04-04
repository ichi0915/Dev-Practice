/**
 * This file contains the Concatenation Of Arrays Function.
 *
 * <p>Exercise: Given an integer array nums of length n,
 * you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 *
 * Specifically, ans is the concatenation of two nums arrays.
 *
 * Return the array ans.
 *
 *
 *
 * Input: nums = [1,2,1]
 * Output: [1,2,1,1,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 *
 * Input: nums = [1,3,2,1]
 * Output: [1,3,2,1,1,3,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 *
 * Constraints:
 *     n == nums.length
 *     1 <= n <= 1000
 *     1 <= nums[i] <= 1000
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

/**
 * Main Class for the ConcatenationOfArray
 */
class ConcatenationOfArray {

	public static void main(final String[] args) {
		int[] nums = {1,2,1};
		// int[] nums = {1,3,2,1};
		int[] finalArray = getConcatenation(nums);

		printArray(finalArray);
	}

	public static int[] getConcatenation(int[] nums) {
		int[] response = new int[2 * nums.length];
		int responsePos = 0;

		for (int i = 0; i <= nums.length-1; i++) {
			response[responsePos++] = nums[i];
			if (i == nums.length-1 && responsePos == nums.length) {
				i = -1;
			}
		}
		return response;
	}

	public static void printArray(int[] array) {
		System.out.println("Printing Array");
		for (int i = 0; i <= array.length-1; i++) {
			System.out.println(array[i]);
		}
	}

}
