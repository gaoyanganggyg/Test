package com.common.test;
/**
 * 水仙花数
 * @author Administrator
 *
 */
public class ShuiXiahHua {
	private static boolean isDaffodilNumber(int n) {
		int sum = 0;
		int temp = n;
		while(temp > 0){
			int temp1 = temp % 10;
			sum += temp1 * temp1 * temp1;
			temp /= 10;
		}
		if(sum == n) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isDaffodilNumber(121));
	}
}
