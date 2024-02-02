/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 *   In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *     n == height.length
 *     2 <= n <= 105
 *     0 <= height[i] <= 104
 */

/**
 * Main Class for the ContainerWithMostWater
 */
class ContainerWithMostWater {

	public static void main(final String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};	// Output: 49
		// int[] height = {1,1};			// Output: 1
		// int[] height = {4, 3, 2, 1, 4};	// Output: 16

		int maxWater = maxArea(height);

		System.out.println(maxWater);
	}

	public static int maxArea(int[] height) {
		int maxWater = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int h = Math.min(height[left], height[right]);
			int w = right - left;
			int currentWater = w*h;

			maxWater = Math.max(maxWater, currentWater);

			if (height[left] < height[right]) {
				left++;
			}
			else {
				right--;
			}
		}

		return maxWater;
	}

}
