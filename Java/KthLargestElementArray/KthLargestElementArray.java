/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * 
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 *     1 <= k <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 */

import java.util.Arrays;

/**
 * Main Class for the KthLargestElementArray
 */
class KthLargestElementArray {

	public static void main(final String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		// int[] nums = [3, 2, 3, 1, 2, 4, 5, 5, 6];
		// int k = 4;
		// int[] nums = {1};
		// int k = 1;
		int kthLargest = findKthLargestSorting(nums, k);
		// int kthLargest = findKthLargest(nums, k);

		System.out.println(kthLargest);
	}

	public static int findKthLargestSorting(int[] nums, int k) {
		int response = 0;

		Arrays.sort(nums);
		final int numsLen = nums.length;
		response = nums[numsLen - k];

		return response;
	}

	public static int findKthLargest(int[] nums, int k) {
		int response = 0;
		int amount = k;

		while (0 != amount+1) {
			int largestPos = 0;
			int largestValue = 0;
			int i = 0;
			for (int num : nums) {
				if (num > largestPos) {
					largestPos = i;
					largestValue = num;
				}
				i++;
			}
			nums = removeValueFromArray(nums, largestPos);
			amount--;
			response = largestValue;
		}

		return response;
	}

	// Recives array and position to remove
	public static int[] removeValueFromArray(int[] nums, int pos) {
		final int arrLen = nums.length;
		int[] resp = new int[arrLen];

		int j = 0;
		for (int i = 0; i < arrLen; i++) {
			if (i != pos) {
				resp[i] = nums[j++];
			}
		}

		return resp;
	}

}
