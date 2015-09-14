package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author Administrator
 *
 */
public class _111_15710_MinimumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(5);
		TreeNode l2 = new TreeNode(4);
		TreeNode l3 = new TreeNode(8);
		TreeNode l4 = new TreeNode(11);
		TreeNode l5 = new TreeNode(13);
		TreeNode l6 = new TreeNode(4);
		TreeNode l7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(2);
		TreeNode l9 = new TreeNode(1);
		l1.left = l2;
		l1.right = l3;
		l2.left = l4;
		l3.left = l5;
		l3.right = l6;
		l4.left = l7;
		l4.right = l8;
		l6.right = l9;
		System.out.println(minDepth(l1));
	}

	public static int minDepth(TreeNode root) {
		if (null == root)
			return 0;
		int count = 0;
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		count++;
		while (list.size() != 0) {
			List<TreeNode> temp = new ArrayList<>();
			for (TreeNode node : list) {
				if (node.left == null && node.right == null) {
					return count;
				} else if (node.left != null && node.right == null) {
					temp.add(node.left);
				} else if (node.left == null && node.right != null) {
					temp.add(node.right);
				} else {
					temp.add(node.left);
					temp.add(node.right);
				}
			}
			list = temp;
			count++;
		}
		return count;
	}


}
