/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * This file contains the Maximum Depth of Binary Tree Function.
 *
 * <p>Exercise: Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 * 		The number of nodes in the tree is in the range [0, 104].
 * 		-100 <= Node.val <= 100
 */

/**
 * Main Class for the MaximumDepthOfTree
 */
class MaximumDepthOfTree {

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
		// [3,9,20,null,null,15,7]
		TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))); // Response: 3
		// TreeNode tree = new TreeNode(1); 		// Response: 1
		// TreeNode tree = null; 						// Response: 0

		final int maxDepthOfTree = maxDepth(tree);

		System.out.println("Max Depth Of Tree: " + maxDepthOfTree);
	}

	// Auxiliary methods


	// First pos is carry and second is sum value
	public static int maxDepth(TreeNode root) {
		int maxDepth = 0;

		if (null != root) {
			maxDepth = 1;

			if (null != root.left || null != root.right) {
				maxDepth = maxDepth(root, maxDepth);
			}
		}

		return maxDepth;
	}

	public static int maxDepth(TreeNode root, int depth) {
		int maxDepth = depth, leftDepth = 0, rightDepth = 0;
		// System.out.println("maxDepth: " + root.val + " depth:" + depth);

		if (null != root.left) {
			leftDepth = maxDepth(root.left, depth+1);
		}
		if (null != root.right) {
			rightDepth = maxDepth(root.right, depth+1);
		}

		if (maxDepth < rightDepth || maxDepth < leftDepth) {
			if (rightDepth > leftDepth) {
				maxDepth = rightDepth;
			}
			else {
				maxDepth = leftDepth;
			}
		}

		return maxDepth;
	}

}
