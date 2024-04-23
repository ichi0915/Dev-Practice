/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * 		2 <= nums.length <= 104
 * 		-109 <= nums[i] <= 109
 * 		-109 <= target <= 109
 *
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 *
 */

/**
 * Main Class for the TwoSum
 */
class TwoSum {

	public static void main(final String[] args) {
		// final int[] nums = {2, 7, 11, 15};			// Response: [0, 1]
		// final int target = 9;
		final int[] nums = {3, 2, 4};			// Response: [1, 2]
		final int target = 6;

		final int[] twoSumArray = twoSum(nums, target);

		System.out.println("[" + twoSumArray[0] + "," + twoSumArray[1] + "]" );
	}

	public static int[] twoSum(int[] nums, int target) {
		final int[] response = new int[2];
		final int numsLen = nums.length;

		for (int i = 0; i < numsLen; i++) {
			// We dont start at 0, we use i because we already
			//  Tested all the values before i and +1 because we
			//  "may not use the same element twice"
			for (int j = i+1; j < numsLen; j++) {
				final int sum = nums[i] + nums[j];
				if (sum == target) {
					response[0] = i;
					response[1] = j;
					break;
				}
			}
		}

		return response;
	}

}
