/**
 * This file contains the Spiral Matrix Function.
 *
 * <p>Exercise: Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main Class for the SpiralMatrix
 */
class SpiralMatrix {

	public static void main(final String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> finalMatrix = spiralOrder(matrix);

		// matrix = {{2,3,7,1},{9,8,6,7},{1,7,6,4,8}};
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> finalMatrix = new ArrayList<>();

		System.out.println("Input matrix: " + Arrays.deepToString(matrix));

		return finalMatrix;
	}
}