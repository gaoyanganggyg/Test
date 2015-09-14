package com.offer.test;
/**
 * 树的子结构
 * @author Administrator
 *
 */
public class HasSubTree {
	public static void main(String[] args) {
		
	}
	
	static boolean has_sub_tree(TreeNode main, TreeNode sub){
		boolean result = false;
		if(main != null && sub != null){
			if(main.val == sub.val)
				result = is_same(main, sub);
			if(!result)
				result = has_sub_tree(main.left, sub);
			if(!result)
				result = has_sub_tree(main.right, sub);
		}
		return result;
	}
	
	static boolean is_same(TreeNode main, TreeNode sub){
		if(sub == null) return true;
		if(main == null) return false;
		if(main.val != sub.val) return false;
		return is_same(main.left, sub.left) && is_same(main.right, sub.right);
	}
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		@SuppressWarnings("unused")
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
