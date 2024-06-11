/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Summary Ranges Function.
 *
 * <p>Exercise: You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 *
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * Constraints:
 * 		0 <= nums.length <= 20
 * 		-231 <= nums[i] <= 231 - 1
 * 		All the values of nums are unique.
 * 		nums is sorted in ascending order.
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class for the SummaryRanges
 */
class SummaryRanges {


	public static void main(final String[] args) {
		// final int[] nums = {};						// Response: []
		// final int[] nums = {0, 1, 2, 4, 5, 7};		// Response: ["0->2","4->5","7"]
		final int[] nums = {0, 2, 3, 4, 6, 8, 9};		// Response: ["0","2->4","6","8->9"]

		List<String> ranges = summaryRanges(nums);

		printList(ranges);
	}


	public static List<String> summaryRanges(int[] nums) {
		final List<String> response = new ArrayList<>();

		if (0 < nums.length) {
			int startValue = nums[0];
			int prevValue = nums[0];

			for(int i=1; i < nums.length; i++) {
				if (nums[i] == prevValue+1) {
					prevValue++;
				}
				else {
					String val = "" + prevValue;
					if (startValue != prevValue) {
						val = startValue + "->" + prevValue;
					}
					startValue = prevValue = nums[i];
					response.add(val);
				}
			}

			String val = "" + prevValue;
			if (startValue != prevValue) {
				val = startValue + "->" + prevValue;
			}
			response.add(val);
		}

		return response;
	}

	public static void printList(List<String> list) {
		list.forEach(val -> {
			System.out.print(val + ",");
		});
	}

}
