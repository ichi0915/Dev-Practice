/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Longest Consecutive Sequence
 *
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements.
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
 * You must write an algorithm that runs in O(n) time.
 * 
 * Example 1:
 * Input: nums = [2,20,4,10,3,4,5]
 * Output: 4
 * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
 * 
 * Example 2:
 * Input: nums = [0,3,2,5,4,6,1,1]
 * Output: 7
 * 
 * Constraints:
 * 		0 <= nums.length <= 1000
 * 		-10^9 <= nums[i] <= 10^9
 */

import java.util.Arrays;

/**
 * Main Class for the LongestConsecutiveSequence
 */
class LongestConsecutiveSequence {

	public static void main(final String[] args) {
		// final int[] nums = {2, 20, 4, 10, 3, 4, 5};				// Response: 4
		// final int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};				// Response: 7
		final int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};		// Response: 7

		final int response = longestConsecutive(nums);

		System.out.println("Longest Consecutive: " + response);
	}

	public static int longestConsecutive(int[] nums) {
		int response = 0;
		int currentMax = 0;

		if (nums.length > 0) {
			Arrays.sort(nums);
			response = currentMax = 1;
			int previousNum = nums[0];

			for (int i = 1; i < nums.length; i++) {
				// System.out.println("num:" + nums[i] + " previousNum:" + previousNum);
				if (nums[i] == previousNum+1) {
					// System.out.println("entro");
					previousNum = nums[i];
					currentMax++;
					if (currentMax > response) {
						response = currentMax;
					}
				}
				else if (nums[i] != previousNum) {
					// System.out.println("max = 0");
					previousNum = nums[i];
					currentMax = 1;
				}
			}
		}

		return response;
	}

}
