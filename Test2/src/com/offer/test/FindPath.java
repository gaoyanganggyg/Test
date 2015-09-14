package com.offer.test;

import java.util.ArrayList;
/**
 * 二叉树中和为某一值的路径
 * @author Administrator
 *
 */
public class FindPath {
	public static void main(String[] args) {

	}
	
	static void find_path(TreeNode root, int num){
		if(null == root) return;
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		find(root, list, num, sum);
	}
	
	static void find(TreeNode root, ArrayList<Integer> list, int num, int sum){
		if(root == null) return;
		sum += root.val;
		list.add(root.val);
		//如果是叶子节点，并且路径上节点的和等于给定的值
		if(root.left == null && root.right == null && sum == num){
			for (Integer data : list) {
				System.out.print(data + " ");
			}
		}
		//如果不是叶子节点，则遍历它的子节点
		find(root.left, list, num, sum);
		find(root.right, list, num, sum);
		//返回前删除子节点的值
		list.remove(list.size() - 1);
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
