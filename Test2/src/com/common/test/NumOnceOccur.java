package com.common.test;

public class NumOnceOccur {
	public static void main(String[] args) {
		int[] array = {1,2,3,1,3,2,4};
		int result = find(array);
		System.out.println(result);
	}

	static int find(int[] array){
		if(null == array || 0 == array.length) return -1;
		int result = array[0];
		for(int i = 1; i < array.length; i++){
			result ^= array[i];
		}
		return result;
	}
}
