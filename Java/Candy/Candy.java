/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Candy Function.
 *
 * 135. Candy
 *
 * <p>Exercise: There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * • Each child must have at least one candy.
 * • Children with a higher rating get more candies than their neighbors.
 * • Rephrase - Children with higher ratings (larger rating values) will receive more candy than their neighbors with lower ratings.
 *
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 * Constraints:
 * 		n == ratings.length
 * 		1 <= n <= 2 * 10^4
 * 		0 <= ratings[i] <= 2 * 10^4
 *
 */

import java.util.Arrays;

/**
 * Main Class for the Candy
 */
class Candy {

	public static void main(final String[] args) {
		// final int[] childrenRatings = {};							// Response: 0
		// final int[] childrenRatings = {1, 0, 2};						// Response: 5
		// final int[] childrenRatings = {1, 2, 2};						// Response: 4
		// final int[] childrenRatings = {1, 3, 2, 2, 1};				// Response: 7
		// final int[] childrenRatings = {1, 2, 4, 4, 4, 3};			// Response: 10
		// 1-2-3-1-2-1 ***
		// final int[] childrenRatings = {1, 6, 10, 8, 7, 3, 2};		// Response: 18
		// 1-2-5-4-3-2-1
		// final int[] childrenRatings = {1, 2, 87, 87, 87, 2, 1};		// Response: 13
		// 1-2-3-1-3-2-1 ***
		final int[] childrenRatings = {29, 51, 87, 87, 72, 12};			// Response: 12
		// 1-2-3-3-2-1

		final int amountOfCandies = candy(childrenRatings);

		System.out.println("The amount of candies are: " + amountOfCandies);
	}


	public static int candy(int[] ratings) {
		int ratingsLen = ratings.length;
		int[] candies = new int[ratingsLen];
		Arrays.fill(candies, 1);

		for (int i = 1; i < ratingsLen; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = ratingsLen - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}

		int totalCandies = 0;
		for (int candy : candies) {
			totalCandies += candy;
		}

		return totalCandies;
	}

	/*
	// Second Submit
	public static int candy(int[] ratings) {
		int amountOfCandies = 0;
		int previousCandies = 1;

		for(int i = 0; i < ratings.length; i++) {
			if (0 == i) {
				if (i+1 < ratings.length) {
					previousCandies = getCurrentPositionCandies(99999, ratings[i], ratings[i+1], 99999, previousCandies);
				}
				else {
					previousCandies = 1;
				}
			}
			else {
				if (i+1 < ratings.length) {
					if (i+2 < ratings.length) {
						previousCandies = getCurrentPositionCandies(ratings[i-1], ratings[i], ratings[i+1], ratings[i+2], previousCandies);
					}
					else {
						previousCandies = getCurrentPositionCandies(ratings[i-1], ratings[i], ratings[i+1], 99999, previousCandies);
					}
				}
				else {
					previousCandies = getCurrentPositionCandies(ratings[i-1], ratings[i], 99999, 99999, previousCandies);
				}
			}
			amountOfCandies += previousCandies;
			System.out.println("previousCandies: " + previousCandies + " amountOfCandies: " + amountOfCandies);
		}

		return amountOfCandies;
	}

	public static int getCurrentPositionCandies(int left, int current, int right, int right2, int previousCandies) {
		int amount = 1;
		System.out.println("\n" + left + "-" + current + "-" + right);
		if (left < current && current > right) {
			amount = previousCandies + 1;
			System.out.println("0-previousCandies");
		}
		else if (left == current && current == right) {

			// if (1 != previousCandies) {
			// 	amount = previousCandies - 1;
			// }
			amount = 1;

			System.out.println("1-previousCandies");
		}
		else if (left == current && current > right) {
			amount = previousCandies;

			if (1 == amount) {
				amount++;
			}

			if (previousCandies == 1 && right > right2 && current > right2) {
				amount++;
			}

			System.out.println("2-previousCandies");
		}
		else if (left <= current && current > right) {
			amount = previousCandies - 1;

			// if (1 == amount) {
			if (1 >= amount) {
				amount++;
			}

			System.out.println("3-previousCandies");
		}
		else if (left < current && current >= right) {
			amount = previousCandies + 1;

			if (1 == amount) {
				amount++;
			}

			System.out.println("4-previousCandies");
		}
		else if (left > current && current > right) {
			amount = previousCandies;

			if (1 == amount) {
				amount++;
			}
			else if (1 != previousCandies && 2 != previousCandies) {
				amount = previousCandies - 1;
			}

			System.out.println("5-previousCandies");
		}
		else if (left < current || current > right) {
			amount = previousCandies + 1;
			System.out.println("6-previousCandies");
		}
		return amount;
	}*/

	/*
	// First Submit
	class Solution {
		public static int candy(int[] ratings) {
			int amountOfCandies = 0;
			int previousCandies = 1;

			for(int i = 0; i < ratings.length; i++) {
				if (0 == i) {
					if (i+1 < ratings.length) {
						previousCandies = getCurrentPositionCandies(99999, ratings[i], ratings[i+1], previousCandies);
					}
					else {
						previousCandies = 1;
					}
				}
				else {
					if (i+1 < ratings.length) {
						previousCandies = getCurrentPositionCandies(ratings[i-1], ratings[i], ratings[i+1], previousCandies);
					}
					else {
						previousCandies = getCurrentPositionCandies(ratings[i-1], ratings[i], 99999, previousCandies);
					}
				}
				amountOfCandies += previousCandies;
			}

			return amountOfCandies;
		}

		public static int getCurrentPositionCandies(int left, int current, int right, int previousCandies) {
			int amount = 1;
			if (left < current || current > right) {
				amount = previousCandies + 1;
			}
			return amount;
		}
	}
	*/
}
