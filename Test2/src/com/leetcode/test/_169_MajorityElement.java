package com.leetcode.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author Administrator
 *
 */
public class _169_MajorityElement {
	public static void main(String[] args) {
		//System.out.println(majorityElement(new int[]{1}));
		System.out.println(majorityElement1(new int[]{1,2,3,2}));
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			int num = nums[i];
			if(map.containsKey(num)){
				int newValue = map.get(num) + 1;
				map.put(num, newValue);
			}else {
				map.put(num, 1);
			}
		}
		Iterator<Integer> iterator = map.keySet().iterator();
		int maxKey = 0;
		int maxValue = 0;
		while(iterator.hasNext()){
			int key = iterator.next();
			int value = map.get(key) ;
			if(maxValue < value){
				maxValue = value;
				maxKey = key;
			}
		}
		return maxKey;
	}
	
	public static int majorityElement1(int[] nums) {
		 int ret = nums[0];
	        int count = 1;
	        for(int i = 1; i < nums.length; i ++)
	        {
	            if(nums[i] == ret)
	                count ++;
	            else
	            {
	                count --;
	                if(count == 0)
	                {
	                    ret = nums[i];
	                    count = 1;
	                }
	            }
	        }
	        return ret;
	}
	
}
