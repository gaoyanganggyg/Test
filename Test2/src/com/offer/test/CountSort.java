package com.offer.test;

import com.sort.test.sort.ArryToBeSorted;
/**
 * 计数排序
 * 需要额外空间，空间复杂度为O(n)
 * @author Administrator
 *
 */
public class CountSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		count_sort();
		ArryToBeSorted.print();
	}
	
	static void count_sort(){
		int[] arrayTemp = new int[10];
		int len = array.length;
		
		for(int i = 0; i < len; i++){
			int num  = array[i];
			++arrayTemp[num];
		}
		
		int index = 0;
		for(int i = 0; i < arrayTemp.length; i++){
			for(int j = 0; j < arrayTemp[i]; j++){
				array[index++] = i;
			}
		}
	}
}
