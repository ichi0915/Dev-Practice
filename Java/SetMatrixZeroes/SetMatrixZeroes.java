/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * Constraints:
 *		 m == matrix.length
 * 		n == matrix[0].length
 * 		1 <= m, n <= 200
 * 		-231 <= matrix[i][j] <= 231 - 1
 *
 * Follow up:
 * 		A straightforward solution using O(mn) space is probably a bad idea.
 * 		A simple improvement uses O(m + n) space, but still not the best solution.
 * 		Could you devise a constant space solution?
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class for the SetMatrixZeroes
 */
class SetMatrixZeroes {

	public static void main(final String[] args) {
		// final int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};			// Response: [[1,0,1],[0,0,0],[1,0,1]]
		final int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; 	// Response: {{0,0,0,0},{0,4,5,0},{0,3,1,0}};

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		setZeroes(matrix);

		System.out.println("\nZeroes Matrix:");
		printMatrix(matrix);
	}

	public static void setZeroes(int[][] matrix) {
		final int matrixI = matrix.length;
		int matrixJ = 0;
		List<int[]> zeroesList = new ArrayList<int[]>();

		for(int i = 0; i < matrixI; i++) {
			matrixJ = matrix[i].length;
			for(int j = 0; j < matrixJ; j++) {
				if (0 == matrix[i][j]) {
					final int[] zero = {i, j};
					zeroesList.add(zero);
				}
			}
		}

		printZeroesList(zeroesList);

		for (int[] zero : zeroesList) {
			for(int i = 0; i < matrixI; i++) {
				if (i > zero[0]) {
					matrix[i][zero[1]] = 0;
				}
				if (i < zero[0]) {
					matrix[i][zero[1]] = 0;
				}
			}

			for(int i = 0; i < matrixJ; i++) {
				if (i > zero[1]) {
					matrix[zero[0]][i] = 0;
				}
				if (i < zero[1]) {
					matrix[zero[0]][i] = 0;
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		final int matrixI = matrix.length;

		for(int i = 0; i < matrixI; i++) {
			final int matrixJ = matrix[i].length;
			for(int j = 0; j < matrixJ; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}

	public static void printZeroesList(List<int[]> zeroesList) {
		System.out.println("\nZeroes List:");
		for (int[] zero : zeroesList) {
			System.out.println(zero[0] + "-" + zero[1]);
		}
	}

}
