package com.leetcode.test;

import java.util.Arrays;

/**
 * Given an array of integers and an integer k, find out whether there there are
 * two distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k
 * 
 * @author Administrator
 *
 */
public class _219_ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int[] posArray = new int[nums.length];
		Arrays.fill(posArray, Integer.MIN_VALUE);
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int pos = Math.abs(nums[i]) % length;
			if(posArray[pos] != Integer.MIN_VALUE){
				int pos1 = posArray[pos];
				if(Math.abs(pos1 - i) <= k){
					return true;
				}else {
					posArray[pos] = i;
				}
			}else {
				posArray[pos] = i;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{1}, 1));
	}
}
