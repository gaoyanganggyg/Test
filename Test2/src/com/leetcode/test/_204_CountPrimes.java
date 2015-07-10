package com.leetcode.test;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author Administrator
 *
 */
public class _204_CountPrimes {
	public static int countPrimes(int n) {
		if(n == 1 || n == 0) return 0;
		boolean[] isPrimes = new boolean[n];
		Arrays.fill(isPrimes, true);
		
		for(int i = 2; i*i < n; i++){
			if(! isPrimes[i]) continue;
			for(int j = i*i; j < n; j += i){
				isPrimes[j] = false;
			}
		}
		int count = 0;
		for(int i = 2; i < n; i++){
			if(isPrimes[i]) count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(3));
	}
}
