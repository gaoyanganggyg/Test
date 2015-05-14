package com.sort.test;

import java.util.Comparator;


public class T1 {
	static Integer[] integers = new Integer[]{3,1,4,2,1};
	public static void main(String[] args) {
		//bubble1();
		bubble2();
	}
	
	/**
	 * 冒泡排序1
	 */
	private static void bubble1(){
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(integers);
		print(integers);
	}
	
	/**
	 * 冒泡排序2
	 */
	private static void bubble2(){
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort((int1, int2) -> {
				if(int1.intValue() > int2.intValue()){
					return 1;
				}else if (int1.intValue() < int2.intValue()) {
					return -1;
				}else {
					return 0;
				}
		}, integers);
		print(integers);
	}
	
	private static <T> void print(T[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}

