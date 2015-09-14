package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNodeUtil {
	public static  TreeNode construct(int[] data) {
		if(null == data || data.length == 0) return null;
		int sub = 0;
		
		for(int i = 1; i <= data.length; i = i + i * 2){
			TreeNode node = new TreeNode(data[i]);
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		TreeNode rootNode = construct(new int[]{5,4,1,Integer.MIN_VALUE,1,Integer.MIN_VALUE,4,2,Integer.MIN_VALUE,2,Integer.MIN_VALUE});
		show(rootNode);
	}
	
	static void show(TreeNode root){
		if(null == root) return;
		show(root.left);
		System.out.println(root.val);
		show(root.right);
	}
	
}


