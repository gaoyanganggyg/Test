package com.sort.test;

public class PalindromicPrimeNumber {
	public static void main(String[] args) {
		palindromicPrimeNumber();
	}

	private static void palindromicPrimeNumber() {
		for(int i = 11; i < 9999; i++){
			if(palindromic(i) && prime(i))
				System.out.println(i);
		}
	}
	/**
	 * 回文数
	 * @param num
	 * @return
	 */
	private static boolean palindromic(int num){
		int temp = num;
		int sum = 0;
		while(temp > 0){
			sum = sum * 10 + temp % 10;
			temp /= 10;
		}
		return sum == num;
	}
	/**
	 * 素数
	 * @param num
	 * @return
	 */
	private static boolean prime(int num){
		for(int i = 2; i < Math.sqrt(num); i++){
			if( num % i == 0){
				return false;
			}
		}
		return true;
	}
}
