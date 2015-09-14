package com.sort.test.sort;
/**
 * 交换排序---冒泡排序
 * 冒泡排序时间复杂度为O(n^2) 空间复杂度O(1)
 * 稳定的排序方法
 * 假设待排序列长为n，从后向前或者从前向后两两比较相邻元素的值，若为逆序，则交换他们，直到序列比较完，称为一趟冒泡排序
 * @author Administrator
 *
 */
public class BubbleSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		//bubble_sort();
		bubble_sort1();
		//bubble_sort2();
		ArryToBeSorted.print();
	}
	
	static void bubble_sort(){
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 2; j >= i ; j--){
				if(array[j + 1] < array[j]){
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	static void bubble_sort1(){
		for(int i = array.length - 1; i >= 0; i--){
			for(int j = 1; j  <= i; j++ ){
				if(array[j] < array[j - 1]){
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
	
	static void bubble_sort2(){
		boolean flag = true;
		for(int i = 0; flag == true && i < array.length; i++){
			flag = false;
			for(int j = array.length - 1; j > i; j--){
				if(array[j] < array[j - 1]){
					flag = true;
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			if(false == flag) return;
		}
	}
	
}
