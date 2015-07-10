package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class _107_BinaryTreeLevelOrderTraversalII {
	public static void main(String[] args) {

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(null == root) return new ArrayList<List<Integer>>();
		List<List<Integer>> listResult = new ArrayList<List<Integer>>();
		List<TreeNode> listTemp = new ArrayList<TreeNode>();
		listTemp.add(root);
		while(listTemp.size() != 0){
			List<Integer> tempList = new ArrayList<>();
			for(TreeNode node : listTemp){
					tempList.add(node.val);
			}
			listResult.add(tempList);
			
			List<TreeNode> tempList1 = new ArrayList<>(listTemp);
			listTemp = new ArrayList<>();
			for(TreeNode node : tempList1){
				if(node.left != null && node.right != null){
					listTemp.add(node.left);
					listTemp.add(node.right);
				}else if (node.left != null && node.right == null) {
					listTemp.add(node.left);
				}else if (node.left == null && node.right != null) {
					listTemp.add(node.right);
				}
			}
		}
		
		List<List<Integer>> listResult1 = new ArrayList<List<Integer>>();
		for(int i = listResult.size() - 1; i >= 0; i-- ){
			listResult1.add(listResult.get(i));
		}
		return listResult1;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
