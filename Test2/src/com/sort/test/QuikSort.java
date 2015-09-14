package com.sort.test;

public class QuikSort {
	public static void main(String[] args) {
		int[] array = {40,38,46,56,79,84};
		quikSort(array, 0, array.length - 1);
		System.out.println("-----------------");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	static void quikSort(int[] array, int low, int high){
		if(low < high){
			int pivot = pivotGet(array, low, high);
			quikSort(array, low, pivot - 1);
			quikSort(array, pivot + 1, high);
		}
	}
	
	static int pivotGet(int[] array, int low, int high){
		int pivotKey = array[low];
		
		while(low < high){
			while(low < high && array[high] >= pivotKey){
				high--;
			}
			swap(array, low, high);
			
			while(low < high && array[low] <= pivotKey){
				low++;
			}
			swap(array, low, high);
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
		return low;
	}

	static void swap(int[] array, int low, int high){
		int temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}
	
}
