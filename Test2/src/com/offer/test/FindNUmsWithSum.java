package com.offer.test;
/**
 * 和为s的两个数
 * @author Administrator
 *
 */
public class FindNUmsWithSum {
	public static void main(String[] args) {
		int[] array = {1,2,4,7,11,15};
		find(array, 15);
	}
	
	static void find(int[] array, int k){
		int len = 0;
		if(null == array || (len = array.length ) == 0) return;
		int start = 0, end = len - 1;
		while(start < end){
			int sum = array[start] + array[end];
			if(sum == k){
				System.out.println(array[start]);
				System.out.println(array[end]);
				return;
			}else if(sum > k) end--;
			else start++;
		}
	}
}
