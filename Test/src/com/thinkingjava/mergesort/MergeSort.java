package com.thinkingjava.mergesort;

public class MergeSort {
	static int[] t1 = { 2, 3 };
	static int[] t2 = { 1, 2};
	static int[] t3 = new int[t1.length + t2.length];

	public static void main(String[] args) {
		mergeSort();
		for (int i = 0; i < t3.length; i++) {
			System.out.println(t3[i]);
		}
	}

	private static void mergeSort() {
		int n = 0;
		int k = 0;
		int count = 0;
		while (n < t1.length && k < t2.length) {
			if (t1[n] > t2[k]) {
				t3[count++] = t2[k++];
			} else {
				t3[count++] = t1[n++];
			}
		}
		while (n < t1.length) {
			t3[count++] = t1[n++];
		}
		while (k < t2.length) {
			t3[count++] = t2[k++];
		}
	}
}
