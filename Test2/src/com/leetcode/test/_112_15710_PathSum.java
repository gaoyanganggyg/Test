package com.leetcode.test;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 *   		  5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author Administrator
 *
 */
public class _112_15710_PathSum {
	public static void main(String[] args) {
		// TreeNode l1 = new TreeNode(5);
		// TreeNode l2 = new TreeNode(4);
		// TreeNode l3 = new TreeNode(8);
		// TreeNode l4 = new TreeNode(11);
		// TreeNode l5 = new TreeNode(13);
		// TreeNode l6 = new TreeNode(4);
		// TreeNode l7 = new TreeNode(7);
		// TreeNode l8 = new TreeNode(2);
		// TreeNode l9 = new TreeNode(1);
		// l1.left = l2;
		// l1.right = l3;
		// l2.left = l4;
		// l3.left = l5;
		// l3.right = l6;
		// l4.left = l7;
		// l4.right = l8;
		// l6.right = l9;
		TreeNode l11 = new TreeNode(1);
		// TreeNode l12 = new TreeNode(2);
		// l11.left = l12;
		System.out.println(hasPathSum(l11, 1));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (null == root)
			return false;

		return hasPathSum1(root, sum, 0);
	}

	static boolean hasPathSum1(TreeNode root, int sum, int val) {
		if (val == sum && root == null) {
			return true;
		}
		if (root == null) {
			return false;
		}
		boolean isLeftTrue = false;
		boolean isRightTrue = false;
		if (root.left == null && root.right != null) {
			isRightTrue = hasPathSum1(root.right, sum, val + root.val);
		} else if (root.left != null && root.right == null) {
			isLeftTrue = hasPathSum1(root.left, sum, val + root.val);
		} else {
			isLeftTrue = hasPathSum1(root.left, sum, val + root.val);
			isRightTrue = hasPathSum1(root.right, sum, val + root.val);
		}
		return isLeftTrue || isRightTrue;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
