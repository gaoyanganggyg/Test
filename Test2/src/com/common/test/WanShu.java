package com.common.test;

/**
 * 所谓的完数是指一个数恰好等于它的所有因子之和 例如：6=1+2+3
 * 
 * @author Administrator
 *
 */
public class WanShu {
	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			int temp = 0;
			for (int j = 1; j < i / 2 + 1; j++) {
				if (i % j == 0)
					temp += j;
			}
			if (temp == i)
				System.out.println(i);
		}
	}
}
