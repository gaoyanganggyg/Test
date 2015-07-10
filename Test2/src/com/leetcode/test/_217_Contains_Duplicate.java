
package com.leetcode.test;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct
 * 
 * @author Administrator
 *
 */
public class _217_Contains_Duplicate {
	public static  boolean containsDuplicate(int[] nums) {
		int length = nums.length;
		int[] posArray = new int[length];
		Arrays.fill(posArray, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) % length;
			if(posArray[pos] != Integer.MIN_VALUE){
				if(nums[posArray[pos]] == nums[i]){
					return true;
				}
			}else {
				posArray[pos] = i;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{3,3}));
	}
}
