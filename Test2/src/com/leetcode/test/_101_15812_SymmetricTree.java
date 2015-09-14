package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;


public class _101_15812_SymmetricTree {
	public static void main(String[] args) {
//		TreeNode t3 = new TreeNode(3);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t21 = new TreeNode(2);
//		TreeNode t31 = new TreeNode(3);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t31;
//		t3.left = t21;
		
		TreeNode t4 = new TreeNode(4);
		TreeNode t42 = new TreeNode(1);
		t4.right = t42;
		
		TreeNode t421 = new TreeNode(2);
		t42.left = t421;
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t12 = new TreeNode(4);
		t1.right = t12;
		
		TreeNode t121 = new TreeNode(2);
		t12.left = t121;
		
		TreeNode t5 = new TreeNode(5);
		
		t5.left = t4;
		t5.right = t1;
		
		
		
		System.out.println(isSymmetric(t5));
	}

	static List<Integer> list = new ArrayList<Integer>();

	public static boolean isSymmetric(TreeNode root) {
		mid(root);
		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			int a = list.get(i);
			int b = list.get(j);
			if (a != b)
				return false;
		}
		return true;
	}

	public static void mid(TreeNode root) {
		if (null == root){
			return;
		}
		
		if(null != root.left){
			mid(root.left);
		}
		if(null == root.left && null != root.right){
			list.add(Integer.MAX_VALUE);
			list.add(root.val);
		} else if(null != root.left && null == root.right ){
			list.add(root.val);
			list.add(Integer.MAX_VALUE);
			
		}else {
			list.add(root.val);
		}
		
		if(null != root.right){
			mid(root.right);
		}
	}
}

