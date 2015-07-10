package com.leetcode.test;

import java.util.HashMap;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 * 
 * @author Administrator
 *
 */
public class _202_HappyNumber {
	public static boolean isHappy(int n, HashMap<Integer, Integer> map) {
		if(n == 1){
			return true;
		}
		if(map.containsKey(n)){
			return false;
		}
		int temp = n;
		int sum = 0;
		while(temp > 0){
			int num = temp % 10;
			sum += num * num;
			temp /= 10;
		}
		map.put(n, n);
		return isHappy(sum, map);
	}
	
	public static boolean isHappy(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int temp = n;
		while(temp != 1 && !map.containsKey(temp)){
			map.put(temp, temp);
			int sum = 0;
			int temp1 = temp;
			while(temp1 > 0){
				int temp2 = temp1 % 10;
				sum += temp2 * temp2;
				temp1 /= 10;
			}
			temp = sum;
		}
		if(temp == 1){
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		//System.out.println(isHappy(18, new HashMap<>()));
		System.out.println(isHappy(18));
	}

}
