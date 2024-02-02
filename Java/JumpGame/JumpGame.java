/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 */

/**
 * Main Class for the JumpGame
 */
class JumpGame {

	public static void main(final String[] args) {
		int[] nums = {2,3,1,1,4};
		// int[] nums = {3,2,1,0,4};
		// int[] nums = {3,0,0,1,2,0,1,4};
		// int[] nums = {0};
		// int[] nums = {1};
		boolean canItJump = canJump(nums);

		System.out.println(canItJump);
	}

	public static boolean canJump(final int[] nums) {
		int maxReach = 0;
		int finalPos = nums.length - 1;

		for (int i = 0; i <= finalPos; i++) {
			if (i > maxReach) {
				return false; // If current position cannot be reached, return false
			}
			maxReach = Math.max(maxReach, i + nums[i]);
			print("maxReach: " + maxReach);
			if (maxReach >= finalPos) {
				return true; // If the last index is reachable, return true
			}
		}

		return false;
	}

	/*
	// Chat GTP
	public static boolean canJump(final int[] nums) {
		boolean response = false;
		int finalPos = nums.length - 1;
		int maxReach = 0;

		for (int i = 0; i <= maxReach && i <= finalPos; i++) {
			maxReach = Math.max(maxReach, i + nums[i]);

			if (maxReach >= finalPos) {
				response = true;
				break;
			}
		}

		return response;
	}
	// */

	/*
	// Original code, it works but slow
	public static boolean canJump(final int[] nums) {
		boolean response = false;
		int finalPos = nums.length;
		int currentPos = 0;

		if (currentPos+1 == finalPos) {
			response = true;
		}
		else if (0 != nums[currentPos]) {
			for (int i = 1; i <= nums[currentPos]; i++) {
				// print("finalPos: " + finalPos);
				// print("currentPos: " + currentPos);
				// print("val at currentPos: " + (currentPos+i));
				response = canJump(nums, currentPos+i, finalPos);
				if (response || currentPos == finalPos) {
					response = true;
					break;
				}
			}
		}

		return response;
	}

	public static boolean canJump(final int[] nums, final int currentPos, final int finalPos) {
		boolean response = false;

		if (currentPos+1 == finalPos) {
			response = true;
		}
		else if (0 != nums[currentPos]) {
			for (int i = 1; i <= nums[currentPos]; i++) {
				// print("A-currentPos: " + currentPos);
				// print("A-val at currentPos: " + (currentPos+i));
				response = canJump(nums, currentPos+i, finalPos);
				if (response) {
					break;
				}
			}
		}

		return response;
	}
	// */

	public static void print(String str) {
		System.out.println(str);
	}

}
