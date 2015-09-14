package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 
  	3
   / \
  9  20
    /  \
   15   7

	return
 * its level order traversal as:
 * [
  [3],
  [9,20],
  [15,7]
	]
 * 
 * @author Administrator
 *
 */
public class _102_15812_BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (null == root)
			return list;
		List<TreeNode> list0 = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(root.val);
		list.add(temp);

		list0.add(root);
		while (list0.size() != 0) {
			List<TreeNode> temp0 = new ArrayList<>();
			List<Integer> tempInt = new ArrayList<>();
			for (int i = 0; i < list0.size(); i++) {
				if (null != list0.get(i)) {
					if (null != list0.get(i).left) {
						temp0.add(list0.get(i).left);
						tempInt.add(list0.get(i).left.val);
					}

					if (null != list0.get(i).right) {
						temp0.add(list0.get(i).right);
						tempInt.add(list0.get(i).right.val);
					}
				}
			}

			if (tempInt.size() != 0)
				list.add(tempInt);
			list0.clear();
			list0.addAll(temp0);
		}
		return list;
	}

}
