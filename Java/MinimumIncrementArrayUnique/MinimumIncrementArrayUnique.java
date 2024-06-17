/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Minimum Increment to Make Array Unique
 *
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * Return the minimum number of moves to make every value in nums unique.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: 1
 * Explanation: After 1 move, the array could be [1, 2, 3].
 *
 * Example 2:
 * Input: nums = [3,2,1,2,1,7]
 * Output: 6
 * Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 * Constraints:
 * 		1 <= nums.length <= 105
 * 		0 <= nums[i] <= 105
 *
 */

import java.util.Arrays;

/**
 * Main Class for the Minimum Increment to Make Array Unique
 */
class MinimumIncrementArrayUnique {

	public static void main(final String[] args) {
		// final int[] nums = {1,2,2};						// Response: 1
		final int[] nums = {3,2,1,2,1,7};			// Response: 6

		final int response = minIncrementForUnique(nums);
		System.out.println("Min Increment For Unique: " + response);
	}

	public static int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int response = 0;
		int prev = nums[0];

		for(int i = 1; i < nums.length; i++) {
			if (prev >= nums[i]) {
				response += (nums[i - 1] - nums[i])+1;
				nums[i] = nums[i - 1] + 1;
			}
			prev = nums[i];
		}

		// printArray(nums);
		return response;
	}

	public static int minIncrementForUniqueNotOptimal(int[] nums) {
		Arrays.sort(nums);
		int response = 0;
		int prev = nums[0];

		for(int i = 1; i < nums.length; i++) {
			while (prev >= nums[i]) {
				nums[i]++;
				response++;
			}
			prev = nums[i];
		}

		// printArray(nums);
		return response;
	}

	public static void printArray(int[] nums) {
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
