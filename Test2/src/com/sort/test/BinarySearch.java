package com.sort.test;
/**
 * 二分法查找
 * @author Administrator
 *
 */
public class BinarySearch {
	static Integer[] arr = new Integer[]{1,2,3,6,7,8};
	public static void main(String[] args) {
		System.out.println(binarySearch(arr, 8));
		System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
	}
	
	private static <T extends Comparable<T>> int binarySearch(T[] list, T key){
		int low = 0;
		int high = list.length - 1;
		while(low <= high){
			int mid = (low + high) >>> 1;
			if(list[mid].compareTo(key) > 0){
				high = mid - 1;
			}else if (list[mid].compareTo(key) < 0) {
				low = mid  + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	
	private static <T extends Comparable<T>> int binarySearch(T[] list, int low, int high, T key){
		if(low <= high){
			int mid =( low + high ) >>> 1;
			if(list[mid].compareTo(key) > 0)
				return binarySearch(list, low, mid - 1, key);
			else if (list[mid].compareTo(key) < 0)
				return binarySearch(list, mid + 1, high, key);
			else
				return mid;
		}
		return -1;
	}
}
