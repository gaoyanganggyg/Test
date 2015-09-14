package com.common.test;
/**
 * 最大子数组问题
 * @author Administrator
 *
 */
public class MaxArraySum {

	public static void main(String[] args) {
		int arr[]={0,1,-1};
		max(arr);
	}
	/**
	 * 动态规划
	 * @param array
	 */
	public static void max(int[] array) {
		int sum = 0;
		int maxSum = 0;
		int start = 0;
		int end = 0;
		boolean isFistTime = true;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			if(sum < 0){
				sum = 0;
				isFistTime = true;
				continue;
			}
			if(sum >= maxSum){
				if(isFistTime == true){
					start = i;
					isFistTime = false;
				}
				end = i;
				maxSum = sum;
			}
		}
		System.out.println(maxSum);
		System.out.println(start  + " " + end);
	}

}
