/**
 * This file contains the Find First and Last Position of Element in Sorted Array function.
 *
 * <p>Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums is a non-decreasing array.
 *     -109 <= target <= 109
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

/**
 * Main Class for the FirstAndLastPositionOfElement
 */
class FirstAndLastPositionOfElement {

	public static void main(final String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int[] range = searchRange(nums, 8);			// [3,4]
		// int[] nums = {1};
		// int[] range = searchRange(nums, 1);			// [0,0]
		// int[] nums = {2,2};
		// int[] range = searchRange(nums, 2);		// [0,1]
		System.out.println("range: [" + range[0] + "," + range[1] + "]");
	}

	public static int[] searchRange(int[] nums, int target) {
		int length = nums.length-1;
		for (int i = 0; i <= length; i++) {
			if (target == nums[i]) {
				if (i+1 <= length) {
					int j = i;
					while (j <= length && nums[j] == target){
						j++;
					}
					return new int[]{i, j-1};
				}
				else
					return new int[]{i, i};
			}
		}
		return new int[]{-1,-1};
	}

}
