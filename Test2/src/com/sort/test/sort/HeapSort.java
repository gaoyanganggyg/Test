package com.sort.test.sort;
/**
 * 选择排序--堆排序
 * 向下调整的时间与树高有关，为O(h)。
 * 在元素个数为n的序列上建堆，其时间复杂度为O（n）。可以在线性时间内，将一个无序数组建成一个大根堆
 * 每次调整的时间复杂度为O(h)，故在最好或平均情况下，堆排序的时间复杂度为O（n*log2^n）堆算法只需一个辅助空间
 * 是不稳定的算法
 * @author Administrator
 *
 */
public class HeapSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		heap_sort();
		//heap_sort1();
		ArryToBeSorted.print();
	}
	
	static void heap_sort(){
		build();
		for(int i = array.length - 1; i > 0; i--){
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			adjust(0, i);
		}
	}
	
	static void build(){
		for(int i = array.length / 2 - 1; i >= 0; i--){
			adjust(i, array.length);
		}
	}
	//向下调整
	static void adjust(int k, int len){
		int temp = array[k];
		for(int i = 2 * k; i < len; i *= 2){
			if(i < len - 1  && array[i] < array[i + 1]) i++;
			if(array[i] <= temp) break;
			else {
				array[k] = array[i];
				k = i;
			}
		}
		array[k] = temp;
	}
	
	//-----------------------------------------------------
	static void heap_sort1(){
		build1();
	}
	
	static void build1(){
		for(int i = 1; i < array.length; i++){
			adjust1(i);
		}
	}
	
	//向上调整
	static void adjust1(int k){
		int temp = array[k];
		int i = k / 2;
		boolean flag = true;
		while(i >= 0 && flag  && array[i] < temp){
			if(0 == i) flag = false;
			array[k] = array[i];
			k = i;
			i = k / 2;
		}
		array[k] = temp;
	}
	
}
