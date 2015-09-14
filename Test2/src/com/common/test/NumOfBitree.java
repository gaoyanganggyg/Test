package com.common.test;
/**
 * 求N个点组成二叉树的个数
 * @author Administrator
 *
 */
public class NumOfBitree {
	public static void main(String[] args) {
		System.out.println(getNum(2));
	}
	
	static int[] result;
	static int getNum(int num){
		if(0 == num) return 0;
		result = new int[num + 1];
		result[0] = 1;
		
		for(int i = 1; i <= num; i++){
			for(int j = 0; j < i; j++){
				result[i] += result[j] * result[i - 1- j];
			}
		}
		return result[num];
	}
}
