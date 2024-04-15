/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 * 		1 <= nums.length <= 105
 * 		-231 <= nums[i] <= 231 - 1
 * 		0 <= k <= 105
 *
 * Follow up:
 * 		Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * 		Could you do it in-place with O(1) extra space?
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Main Class for the RotateArray
 */
class RotateArray {

	public static void main(final String[] args) {
		final int[] nums = {1,2,3,4,5,6,7};				// Response: 5,6,7,1,2,3,4
		final int k = 3;
		// final int[] nums = {-1, -100, 3, 99};			// Response: 3, 99, -1, -100
		// final int k = 2;

		printArray(nums);
		rotate(nums, k);
		printArray(nums);
	}

	// Works but Extremely slow
	public static void rotate(int[] nums, int k) {
		final int numsLen = nums.length;

		if (numsLen > 0) {
			while (k > 0) {
				moveValues(nums, numsLen);
				k--;
			}
		}
	}

	public static void moveValues(int[] nums, final int numsLen) {
		final int val = nums[numsLen-1];
		for (int i = numsLen-1; i > 0; i--) {
			nums[i] = nums[i-1];
		}
		nums[0] = val;
	}

	// Faster than rotate
	public static void rotateUsingListNoReturnValue(int[] nums, int k) {
		final int numsLen = nums.length;
		final List<Integer> list = new LinkedList<>(Arrays.stream(nums).boxed().toList());

		while (k > 0) {
			Integer val = list.remove(numsLen-1);
			// System.out.print("val:" + val + "\n");
			if (null != val) {
				list.add(0, val);
			}

			k--;
		}

		int[] tmpNums = list.stream().mapToInt(Integer::intValue).toArray();

		for (int i = 0; i < numsLen; i++) {
			nums[i] = tmpNums[i];
		}
	}

	// Faster than the others but does not work with return void
	public static int[] rotateUsingList(int[] nums, int k) {
		final int numsLen = nums.length;
		final List<Integer> list = new LinkedList<>(Arrays.stream(nums).boxed().toList());

		while (k > 0) {
			Integer val = list.remove(numsLen-1);
			// System.out.print("val:" + val + "\n");
			if (null != val) {
				list.add(0, val);
			}

			k--;
		}
		nums = list.stream().mapToInt(Integer::intValue).toArray();

		return nums;
	}

	public static void swap(int[] nums, int pos1, int pos2) {
		int tmp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = tmp;
	}

	public static void printArray(final int[] nums) {
		for (int num : nums) {
			System.out.print(num + "-");
		}
		System.out.print("\n");
	}

	public static void printList(List<Integer> list) {
		for (Integer num : list) {
			System.out.print(num + "-");
		}
		System.out.print("\n");
	}

}
