package com.sort.test.sort;

public class ArryToBeSorted {
	static int[] array = { 0, 2, 4, 1, 3, 5, 1, 9, 6, 4, 7,8};

	public static int[] getArray() {
		return array;
	}
	
	public static void print() {
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "  ");
		}
		System.out.println(" ");
	}
	
}
