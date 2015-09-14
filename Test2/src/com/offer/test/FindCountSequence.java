package com.offer.test;
/**
 * 和为s的连续正整数序列
 * @author Administrator
 *
 */
public class FindCountSequence {
	public static void main(String[] args) {
		find(20);
	}

	static void find(int k) {
		int start = 1;
		int end = 2;
		int mid = (k + 1) / 2;
		int sum = start + end;
		while (start < mid) {
			if (sum == k)
				print(start, end);
			while (sum > k && start < mid) {
				sum -= start;
				start++;
				if (sum == k)
					print(start, end);
			}
			end++;
			sum += end;
		}
	}

	static void print(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

}
