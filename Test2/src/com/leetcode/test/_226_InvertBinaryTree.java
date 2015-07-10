package com.leetcode.test;

/**
 * Invert Binary Tree
 * 
 * @author Administrator
 *
 */
public class _226_InvertBinaryTree {
	public static void main(String[] args) {

	}

	public static TreeNode invertTree(TreeNode root) {
		if(root == null || (null == root.left && null == root.right)){
			return root;
		}else {
			TreeNode temp = null;
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
