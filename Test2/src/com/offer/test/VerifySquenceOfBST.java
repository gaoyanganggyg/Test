package com.offer.test;
/**
 * 二叉搜索树的后续遍历序列
 * @author Administrator
 *
 */
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		int[] array = {6,7};
		boolean possible = verify_of_bst(array, 0, 1);
		System.out.println(possible);
	}
	
	static boolean verify_of_bst(int[] array, int start, int end){
		if(null == array || start < 0 || end < 0 || start > end) return false;
		int root = array[end];
		int i = start;
		while(i < end){
			if(array[i] > root) break;
			i++;
		}
		for(int j = i; j < end; j++){
			if(array[j] < root) return false;
		}
		boolean left = true;
		if(i > start)
			left = verify_of_bst(array, start, i - 1);
		boolean right = true;
		if(i < end)
			right = verify_of_bst(array, i, end - 1);
		return left && right;
	}
	
}
