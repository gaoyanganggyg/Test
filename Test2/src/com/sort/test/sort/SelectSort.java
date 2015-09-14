package com.sort.test.sort;
/**
 * 选择排序--简单选择排序
 * 时间复杂度O(n^2)
 * 不稳定
 * @author Administrator
 *
 */
public class SelectSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		select_sort();
		ArryToBeSorted.print();
	}
	
	static void select_sort(){
		for(int i = 0; i < array.length; i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[min]) min = j;
			}
			if(min != i){
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
}
