package com.search.test;
/**
 * 二分法查找
 * @author Administrator
 *
 */
public class SearchAllType {
	public static void main(String[] args) {
		int[] array = {0,1,16,24,35,47,59,62,73,88,99};
		SearchAllType searchAllType = new SearchAllType();
		int pos = searchAllType.binarySearch(array, 1);
		if(-1 == pos) 
			System.out.println("no such element");
		else
			System.out.println("position: " + pos + " data: " + array[pos] );
	}
	
	int binarySearch(int[] array, int key){
		if(null == array || array.length < 1) return -1;
		int low = 0;
		int high = array.length - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if(array[mid] < key){
				low = mid + 1;
			}else if (array[mid] > key) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
