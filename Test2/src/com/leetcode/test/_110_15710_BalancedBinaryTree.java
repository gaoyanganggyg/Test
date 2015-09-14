package com.leetcode.test;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Administrator
 *
 */
public class _110_15710_BalancedBinaryTree {
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
		TreeNode l12 = new TreeNode(2);
		TreeNode l13 = new TreeNode(3);
		l11.left = l12;
		l12.right = l13;
		System.out.println(isBalanced(l11));
	}

	public static boolean isBalanced(TreeNode root) {
		if (null == root)
			return true;
		if (Math.abs(heightOfBiTree(root.left) - heightOfBiTree(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	static int heightOfBiTree(TreeNode root) {
		if (null == root) {
			return 0;
		}
		int left = heightOfBiTree(root.left) + 1;
		int right = heightOfBiTree(root.right) + 1;
		return Math.max(left, right);
	}


}
