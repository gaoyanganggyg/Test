package com.sort.test.search;
/**
 * 二分查找
 * @author Administrator
 *
 */
public class BinarySearch {
	static int[] array = {7,10,13,16,19,29,32,33,37,41,43};
	public static void main(String[] args) {
		int result = bin_search(13, 0, array.length - 1);
		System.out.println(result);
	}
	
	static int bin_search(int key, int low, int high){
		while(low <= high){
			int mid = (low + high) / 2;
			if(key > array[mid]) low = mid + 1;
			else if(key < array[mid]) high = mid - 1;
			else return array[mid];
		}
		return -1;
	}
}
