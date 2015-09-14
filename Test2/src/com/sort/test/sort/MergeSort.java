package com.sort.test.sort;

import java.util.Arrays;
/**
 * 归并排序
 * 
 * 归并排序的时间主要包括划分子序列的时间、对子序列进行排序以及递归的时间。划分子序列是在常数时间内完成，
 * 最后的归并操作可以在线性时间内完成。
 * 
 * 归并对待排序的序列的初始输入排列是不敏感。归并排序时间复杂度为O(n*log2^n)，空间复杂度为O(n)
 * 是一种稳定的算法
 * @author Administrator
 *
 */
public class MergeSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		merge_sort(0, array.length - 1);
		ArryToBeSorted.print();
	}
	
	static void merge_sort(int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			merge_sort(low, mid);
			merge_sort(mid  + 1, high);
			merge(low, mid, high);
		}
	}
	static int[] array1;
	static void merge(int low, int mid, int high){
		array1 = Arrays.copyOf(array, array.length);
		int i = low, j = mid + 1;
		int k = low;
		while(i <= mid && j <= high){
			if(array1[i] > array1[j]) array[k++] = array1[j++];
			else array[k++] = array1[i++];
		}
		while(i <= mid) array[k++] = array1[i++];
		while(j <= high) array[k++] = array[j++];
	}
}
