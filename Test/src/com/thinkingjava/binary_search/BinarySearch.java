package com.thinkingjava.binary_search;

public class BinarySearch {
	static int[] t1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {
		System.out.println(binarySearch(7));
	}
	private static int  binarySearch(int n) {
		int pos = (t1.length - 1)  >> 1;
		int temp = pos;
		while(pos != 0 && pos != t1.length - 1){
			if(t1[pos] == n) return pos;
				pos = (temp + pos) >> 1;
				temp = pos;
		}
		if (pos == 0 && t1[0] == n ) {
			return 0;
		}else if (pos == t1.length - 1 && t1[ t1.length - 1] == n ) {
			return pos;
		}
		return -1;
	}
}
