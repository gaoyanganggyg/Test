package com.common.test;

public class ZuiDaZiXvLianZhiHe {
	public static void main(String[] args) {
		System.out.println(maxSubStrSum(new int[]{ -2, 11, -4, 13, -5, -2}));
	}
	
	public static int maxSubStrSum(int[] array) {
		int sum = 0;
		int max = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			if(sum > max){
				max = sum;
			}
			if(sum < 0){
				sum = 0;
			}
		}
		return max;
	}
}
