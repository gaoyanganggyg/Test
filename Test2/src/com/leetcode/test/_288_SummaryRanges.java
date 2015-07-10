package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author Administrator
 *
 */
public class _288_SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if(null == nums || nums.length == 0) return list;
		int start = 0;
		int end = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if(Math.abs(nums[i+1] - nums[i]) == 1){
				end++;
			}else {
				if(start == end){
					list.add(nums[start] + "");
				}else {
					list.add(nums[start] + "->" + nums[end]);
				}
				start = end =  i + 1;
			}
		}
		if(start == end){
			list.add(nums[start] + "");
		}else {
			list.add(nums[start] + "->" + nums[end]);
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> list = summaryRanges(new int[]{0,1,2,4,5,6});
		for(String data : list){
			System.out.println(data);
		}
	}
}
