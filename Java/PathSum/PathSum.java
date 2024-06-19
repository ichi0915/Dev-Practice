/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Path Sum Function.
 *
 * <p>Exercise: Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 *
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 *
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 * Constraints:
 * 		The number of nodes in the tree is in the range [0, 5000].
 * 		-1000 <= Node.val <= 1000
 * 		-1000 <= targetSum <= 1000
 */

/**
 * Main Class for the MaximumDepthOfTree
 */
class PathSum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(final String[] args) {
		// [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
		// Response: true
		final int targetSum = 22;
		final TreeNode tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

		// Response: false
		// final int targetSum = 0;
		// final TreeNode tree = null;

		// [1,2]
		// Response: false
		// final int targetSum = 2;
		// final TreeNode tree = new TreeNode(1, new TreeNode(2), null);

		final boolean response = hasPathSum(tree, targetSum);

		System.out.println("Does it add up: " + response);
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		boolean response = false;

		if (null != root) {
			response = pathSum(root, targetSum, 0);
		}

		return response;
	}

	public static boolean pathSum(final TreeNode root, final int targetSum, int currentAmount) {
		boolean response = false;
		currentAmount += root.val;

		// System.out.println("root.val: " + root.val + " - currentAmount: " + currentAmount);

		if (null != root.left) {
			response = pathSum(root.left, targetSum, currentAmount);
		}
		if (!response && null != root.right) {
			response = pathSum(root.right, targetSum, currentAmount);
		}

		if (!response && targetSum == currentAmount && null == root.left && null == root.right) {
			// System.out.println("response");
			response = true;
		}

		return response;
	}

}
