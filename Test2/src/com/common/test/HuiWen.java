package com.common.test;
/**
 * 回文数
 * @author Administrator
 *
 */
public class HuiWen {
	public static void main(String[] args) {
		System.out.println(isHuiwen(2222));
	}
	
	static boolean isHuiwen(int num){
		int temp = num;
		int sum = 0;
		while (temp > 0) {
			sum = sum * 10 + temp % 10;
			temp /= 10;
		}
		return sum == num;
	}
}
