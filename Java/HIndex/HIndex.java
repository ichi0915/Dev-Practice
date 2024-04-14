/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published
 * at least h papers that have each been cited at least h times.
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 *
 * Constraints:
 * 		n == citations.length
 * 		1 <= n <= 5000
 * 		0 <= citations[i] <= 1000
 *
 */


/**
 * Main Class for the HIndex
 */
class HIndex {

	public static void main(final String[] args) {
		// final int[] citations = {8};					// Response: 1
		final int[] citations = {8, 3};				// Response: 2
		// final int[] citations = {3, 0, 6, 1, 5};		// Response: 3
		// final int[] citations = {1, 3, 1};			// Response: 1
		// final int[] citations = {9, 7, 6, 2, 1};		// Response: 3
		// final int[] citations = {10, 8, 5, 4, 3};	// Response: 4
		// final int[] citations = {25, 8, 5, 3, 3};	// Response: 3
		final int hIndexValue = hIndex(citations);

		System.out.println(hIndexValue);
	}

	public static int hIndex(int[] citations) {
		final int amountPublications = citations.length;
		int response = 0;
		int[] buckets = new int[amountPublications + 1];

		// Count papers for each citation count
		for (int citation : citations) {
			// If bigger add count to the end of bucket
			if (citation >= amountPublications) {
				buckets[amountPublications]++;
			}
			else {
				buckets[citation]++;
			}
		}

		int count = 0;
		for (int i = amountPublications; i >= 0; i--) {
			count += buckets[i];
			if (count >= i) {
				response = i;
				break;
			}
		}

		return response;
	}

}
