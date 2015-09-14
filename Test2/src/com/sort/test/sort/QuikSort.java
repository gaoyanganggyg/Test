package com.sort.test.sort;
/**
 * 交换排序--快排
 * 时间复杂度O(n*log2^n)
 * 空间复杂度最好的情况下为O(log2^n),最坏情况下，需要n-1此递归调用，栈的深度为O(n);平均栈深度为O(log2^n)
 * 不稳定
 * @author Administrator
 *
 */
public class QuikSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		quik_sort(0, array.length - 1);
		ArryToBeSorted.print();
	}
	
	static void quik_sort(int low, int high){
		if(low < high){
			int pivot = getPivot(low, high);
			quik_sort(low, pivot - 1);
			quik_sort(pivot + 1, high);
		}
	}
	
	static int getPivot(int low, int high){
		int pivot = array[low];
		while(low < high){
			while(low < high && array[high] >= pivot) high--;
			array[low] = array[high];
			while(low < high && array[low] <= pivot) low++;
			array[high] = array[low];
		}
		array[low] = pivot;
		return low;
	}
	
}
