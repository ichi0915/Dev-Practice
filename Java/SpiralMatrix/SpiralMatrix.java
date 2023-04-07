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
		// int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> finalMatrix = spiralOrder(matrix);

		System.out.println("Result matrix: " + finalMatrix);
		// matrix = {{2,3,7,1},{9,8,6,7},{1,7,6,4,8}};
	}

	//directions 1:right 2:down 3:left 4:up
	public static void spiralTraversal(List<Integer> list, int[][] matrix, int startWidth, int startHeight, int direction, int loopTimes) {
		//Final list
		// List<Integer> list = new ArrayList<>();
		//Actual length
		int matrixWidth = matrix.length;
		int matrixHeight = matrix[0].length;
		//My current position
		int currentWidth = 0;
		int currentHeight = 0;

		System.out.println("\ndirection " + direction);

		if (1 == direction || 3 == direction) {
			startWidth += loopTimes;
			startHeight += loopTimes;
		}
		else if (2 == direction || 4 == direction) {
			startWidth -= loopTimes;
			startHeight -= loopTimes;
		}

		System.out.print("startWidth:" + startWidth + " startHeight" + startHeight + " matrixWidth:"+ matrixWidth + " matrixHeight:"+ matrixHeight + "\n");

		if (1 == direction) {
			int m = startWidth;
			for(int n = startHeight; n < matrixHeight && n >= 0; n++) {
			// for(int n = startHeight; n < matrixHeight; n++) {
				System.out.print(matrix[m][n] + " ");
				list.add(matrix[m][n]);
				currentWidth = m + 1;
				currentHeight = n;
			}
		}
		else if (2 == direction) {
			int n = startHeight;
			for(int m = startWidth; m < matrixWidth && m >= 0; m++) {
				System.out.print(matrix[m][n] + " ");
				list.add(matrix[m][n]);
				currentWidth = m;
				currentHeight = n - 1;
			}
		}
		else if (3 == direction) {
			int m = startWidth;
			for(int n = startHeight; n < matrixHeight && n >= 0; n--) {
				System.out.print(matrix[m][n] + " ");
				list.add(matrix[m][n]);
				currentWidth = m - 1;
				currentHeight = n;
			}
		}
		else if (4 == direction) {
			int n = startHeight;
			for(int m = startWidth; m >= matrixWidth-2 && m >= 0; m--) {
				// System.out.print("M:" + m + " n" + n + " matrixWidth:"+ matrixWidth + " --");
				System.out.print(matrix[m][n] + " ");
				list.add(matrix[m][n]);
				currentWidth = m;
				currentHeight = n - 1;
			}
		}

		direction++;
		if (4 < direction){
			direction = 1;
			loopTimes++;
		}

		if ( (matrixWidth*matrixHeight) > list.size() ) {
			spiralTraversal(list, matrix, currentWidth, currentHeight, direction, loopTimes);
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> finalMatrix = new ArrayList<>();

		System.out.println("Input matrix: " + Arrays.deepToString(matrix));

		spiralTraversal(finalMatrix, matrix, 0, 0, 1, 0);

		// for(int m = 0; m < matrixWidth; m++) {
		// 	for(int n = 0; n < matrixHeight; n++) {
		// 		System.out.print(matrix[m][n] + " ");
		// 		list.add(matrix[m][n]);
		// 	}
		// }

		return finalMatrix;
	}
}
//30
