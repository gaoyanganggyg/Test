package com.offer.test;
/**
 * 二叉树镜像
 * @author Administrator
 *
 */
public class MirrorRecursive {
	public static void main(String[] args) {

	}
	
	static void recursive(TreeNode root){
		if(null == root ) return;
		if(root.left == null && root.right == null) return;
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		recursive(root.left);
		recursive(root.right);
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
