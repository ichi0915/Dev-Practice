/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Best Time to Buy and Sell Stock
 *
 * Binary search is a search algorithm used to find the position of a target value within a sorted array.
 * It works by repeatedly dividing the search interval in half until the target value is found or the interval is empty.
 * The search interval is halved by comparing the target element with the middle value of the search space.
 *
 * To apply Binary Search algorithm:
 * 		The data structure must be sorted.
 * 		Access to any element of the data structure takes constant time.
 */

/**
 * Main Class for the BinarySearch
 */
class BinarySearch {

	public static void main(final String[] args) {
		final int[] values = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
		final int target = 23;											//Response: 5

		final int position = binarySearch(values, target);
		final int positionRecursive = binarySearchRecursive(values, target, 0, values.length-1);

		System.out.println("Position: " + position);
		System.out.println("Position: " + positionRecursive);
	}

	public static int binarySearchRecursive(final int[] values, final int target, final int start, final int finish) {
		if(finish >= start) {
			final int mid = start + ((finish - start) / 2);

			if (target == values[mid]) {
				return mid;
			}
			else if (target > values[mid]) {
				return binarySearchRecursive(values, target, mid + 1, finish);
			}
			else {
				return binarySearchRecursive(values, target, start, mid - 1);
			}
		}

		// We didn't find the value
		return -1;
	}

	public static int binarySearch(int[] values, final int target) {
		int start = 0;
		int finish = values.length -1;

		while (start <= finish) {
			int mid = start + ((finish - start) / 2);

			if (target == values[mid]) {
				return mid;
			}
			else if (target > values[mid]) {
				start = mid + 1;
			}
			else {
				finish = mid - 1;
			}
		}

		return -1;
	}

}
