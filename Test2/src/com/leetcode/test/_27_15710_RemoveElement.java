package com.leetcode.test;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * tssshe new length.
 * 
 * @author Administrator
 *
 */
public class _27_15710_RemoveElement {
	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 4, 5 }, 4));
		System.out.println(removeElement1(new int[] { 4, 5 }, 4));
	}

	public static int removeElement(int[] nums, int val) {
		if (null == nums)
			return 0;
		int len = nums.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == val)
				count++;
		}
		return len - count;
	}

	public static int removeElement1(int[] nums, int val) {
		if (nums == null)
			return 0;
		int len = nums.length - 1;
		for (int i = 0; i <= len; i++) {
			if (nums[i] == val) {
				nums[i--] = nums[len--];
			}
		}
		return len + 1;
	}

}
