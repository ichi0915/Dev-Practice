/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * Constraints:
 * 		1 <= target <= 109
 * 		1 <= nums.length <= 105
 * 		1 <= nums[i] <= 104
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 *
 */

/**
 * Main Class for the MinimumSizeSubarraySum
 */
class MinimumSizeSubarraySum {

	public static void main(final String[] args) {
		final int target = 7;							// Response: 2
		final int[] nums = {2, 3, 1, 2, 4, 3};			// Response: [4,3]
		// final int target = 4;							// Response: 1
		// final int[] nums = {1, 4, 4};					// Response: [1]
		// final int target = 11;							// Response: 0
		// final int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};		// Response: [0]

		final int wordLen = minSubArrayLen(target, nums);

		System.out.println(wordLen);
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int minimumLen = Integer.MAX_VALUE;
		int numsLen = 0;
		int currentSum = 0;
		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			currentSum += nums[right];
			numsLen++;

			while (target <= currentSum) {
				currentSum -= nums[left];
				left++;

				if (minimumLen > numsLen) {
					minimumLen = numsLen;
				}

				numsLen--;
			}

		}

		if (minimumLen == Integer.MAX_VALUE) {
			minimumLen = 0;
		}

		return minimumLen;
	}


}
