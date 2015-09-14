package com.offer.test;
/**
 * 二叉搜索树与双向链表
 * @author Administrator
 *
 */
public class Convert {
	public static void main(String[] args) {

	}
	
	static TreeNode firstConvert(TreeNode root){
		TreeNode lastIn = null;
		TreeNode head = convert(root, lastIn);
		while(head.left != null){
			head = head.left;
		}
		return head;
	}

	static TreeNode convert(TreeNode root, TreeNode lastIn){
		if(null == root) return null;
		TreeNode node = root;
		if(node.left != null)
			convert(node.left, lastIn);
		node.left = lastIn;
		if(lastIn != null)
			lastIn.right = node;
		lastIn = node;
		if(node.right != null)
			convert(node.right, lastIn);
		return root;
	}
	
	private static class TreeNode{
		@SuppressWarnings("unused")
		int val;
		TreeNode left;
		TreeNode right;
		@SuppressWarnings("unused")
		public TreeNode(int val) {
			this.val = val;
		}
	}
}
