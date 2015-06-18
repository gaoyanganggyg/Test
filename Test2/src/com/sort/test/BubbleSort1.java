package com.sort.test;

public class BubbleSort1 {
	class Sqlist{
		int r[];
		int length;
	}

	public static void main(String[] args) {
		BubbleSort1 bubbleSort1 = new BubbleSort1();
		BubbleSort1.Sqlist sq = bubbleSort1.new Sqlist();
		sq.r = new int[]{9,1,5,8,3,7,4,6,2};
		sq.length = 9;
//		Sqlist result = bubbleSort1.sort(sq);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result.r[i]);
//		}
//		Sqlist result1 = bubbleSort1.sort1(sq);
//		for (int i = 0; i < result1.length; i++) {
//			System.out.println(result.r[i]);
//		}
//		Sqlist result2 = bubbleSort1.sort2(sq);
//		for (int i = 0; i < result2.length; i++) {
//			System.out.println(result.r[i]);
//		}
		
//		Sqlist result3 = bubbleSort1.selectSort(sq);
//		for (int i = 0; i < result3.length; i++) {
//			System.out.println(result3.r[i]);
//		}
//		
//		Sqlist result4 = bubbleSort1.insertSort(sq);
//		for (int i = 0; i < result4.length; i++) {
//			System.out.println(result4.r[i]);
//		}
//		Sqlist result5 = bubbleSort1.shellSort(sq);
//		for (int i = 0; i < result5.length; i++) {
//			System.out.println(result5.r[i]);
//		}
//		Sqlist result6 = bubbleSort1.heapSort(sq);
//		for (int i = 0; i < result6.length; i++) {
//			System.out.println(result6.r[i]);
//		}
//		Sqlist result7 = bubbleSort1.mergeSort(sq);
//		for (int i = 0; i < result7.length; i++) {
//			System.out.println(result7.r[i]);
//		}
		Sqlist result8 = bubbleSort1.quikSort(sq);
		for (int i = 0; i < result8.length; i++) {
			System.out.println(result8.r[i]);
		}
	}
	/**
	 * 冒泡排序
	 * @param list
	 * @return
	 */
	Sqlist sort(Sqlist list){
		long start = System.currentTimeMillis();
		if(list.length <= 1) return list;
		for(int i = 0; i < list.length - 1; i++){
			for (int j = list.length - 2; j >= i; j--) {
				if(list.r[j] > list.r[j + 1]){
					int temp = list.r[j];
					list.r[j] = list.r[j + 1];
					list.r[j+ 1] = temp;
				}
			}
		}
		System.out.println("sort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 冒泡排序
	 * @param list
	 * @return
	 */
	Sqlist sort1(Sqlist list){
		long start = System.currentTimeMillis();
		for(int i = 0; i < list.length - 1; i++){
			for (int j = i + 1; j < list.length; j++) {
				if(list.r[i] > list.r[j]){
					int temp = list.r[i];
					list.r[i] = list.r[j];
					list.r[j] = temp;
				}
			}
		}
		System.out.println("sort1 time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 冒泡排序
	 * @param list
	 * @return
	 */
	Sqlist sort2(Sqlist list){
		boolean flag = true;
		long start = System.currentTimeMillis();
		if(list.length <= 1) return list;
		for(int i = 0; i < list.length - 1 && flag; i++){
			flag = false;
			for (int j = list.length - 2; j >= i; j--) {
				if(list.r[j] > list.r[j + 1]){
					
					flag = true;
					
					int temp = list.r[j];
					list.r[j] = list.r[j + 1];
					list.r[j+ 1] = temp;
				}
			}
		}
		System.out.println("sort2 time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 选择排序
	 * @param list
	 * @return
	 */
	Sqlist selectSort(Sqlist list){
		long start = System.currentTimeMillis();
		for(int i = 0; i < list.length - 1; i++){
			int min = i ;
			for(int j = i + 1; j < list.length; j++){
				if(list.r[j] < list.r[min]){
					min = j;
				}
			}
			if(i != min){
				int temp = list.r[min];
				list.r[min] = list.r[i];
				list.r[i] = temp;
			}
		}
		
		System.out.println("selectSort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 插入排序
	 * @param list
	 * @return
	 */
	Sqlist insertSort(Sqlist list){
		long start = System.currentTimeMillis();
		int j = 0;
		for(int i = 1; i < list.length; i++){
			if(list.r[i] < list.r[i-1]){
				int temp = list.r[i];
				for(j = i - 1; j >= 0 &&  list.r[j] > temp; j--){
					list.r[j + 1] = list.r[j];
				}
				list.r[j + 1] = temp;
			}
		}
		System.out.println("insertSort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 希尔排序
	 * @param list
	 * @return
	 */
	Sqlist shellSort(Sqlist list){
		long start = System.currentTimeMillis();
		int j = 0;
		int increment = list.length;
		while(increment > 1){
			increment = increment / 3 + 1;
			for(int i = increment; i < list.length; i++){
				if(list.r[i] < list.r[i - increment]){
					int temp = list.r[i];
					for(j = i - increment; j >= 0 && list.r[j] > temp; j -= increment){
						list.r[j + increment] = list.r[j];
					}
					list.r[j + increment] = temp;
				}
			}
		}
		System.out.println("shellSort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/*******************************堆排序***********************************************/
	/**
	 * 堆排序
	 * @param list
	 * @return
	 */
	Sqlist heapSort(Sqlist list){
		long start = System.currentTimeMillis();
		
		for(int i = list.length / 2 - 1; i >= 0; i--){
			HeapAdjust(list, i, list.length - 1);
		}
		for(int i = list.length - 1; i > 0; i--){
			int temp = list.r[i];
			list.r[i] = list.r[0];
			list.r[0] = temp;
			HeapAdjust(list, 0, i - 1);
		}
		System.out.println("heapSort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	/**
	 * 构建堆
	 * @param list
	 * @param start
	 * @param length
	 */
	void HeapAdjust(Sqlist list, int start, int length){
		int i = 0;
		int temp = list.r[start];
		for(i = 2 * (start + 1); i <= length; i *= 2){
			if(i >= length || list.r[i] < list.r[i - 1]) i--;
			if(list.r[i] <= temp) break;
			list.r[start] = list.r[i];
			start = i;
			list.r[start] = temp;
		}
	}
	/********************************************************************************/
	
	/**********************************归并排序********************************************/
	Sqlist mergeSort(Sqlist list){
		long start = System.currentTimeMillis();
		mSort(list.r, list.r, 0, list.length - 1);
		System.out.println("mergeSort time used : " + (System.currentTimeMillis() - start));
		return list;
	}
	void mSort(int[] list1, int[] list2, int start, int end){
		int m;
		int[] list3 = new int[list1.length];
		if(start == end){
			list2[start] = list1[start];
		}else {
			m = (start + end) / 2;
			mSort(list1, list3, start, m);
			mSort(list1, list3, m + 1, end);
			merge(list3, list2, start, m, end);
		}
	}
	void merge(int[] result1, int[] result2, int start, int m, int end){
		int pos, j;
		for(j = m + 1, pos = start; j <= end && start <= m; pos++){
			if(result1[j] < result1[start]){
				result2[pos] = result1[j++];
			}else {
				result2[pos] = result1[start++];
			}
		}
		if(start <= m){
			for(int k = 0; k <= m - start; k++){
				result2[pos + k] = result1[start + k];
			}
		}
		if(j <= end){
			for(int k = 0; k <= end - j; k++){
				result2[pos + k ] = result1[j + k];
			}
		}
	}
	/******************************************************************************/
	
	/********************************快排*********************************************/
	Sqlist quikSort(Sqlist list){
		long startTime = System.currentTimeMillis();
		quikSort1(list, 0, list.length - 1);
		System.out.println("quikSort time used: " + (System.currentTimeMillis() - startTime));
		return list;
	}
	void quikSort1(Sqlist list, int start, int end){
		int pos;
		if(start < end){
			pos = quikSort2(list, start, end);
			quikSort1(list, start, pos - 1);
			quikSort1(list, pos + 1, end);
		}
	}
	
	int quikSort2(Sqlist list, int start, int end){
		int temp = list.r[start];
		while(start < end){
			while(start < end && list.r[end] >= temp){
				end--;
			}
			int temp1 = list.r[start];
			list.r[start] = list.r[end];
			list.r[end] = temp1;
			while(start < end && list.r[start] <= temp){
				start++;
			}
			int temp2 = list.r[start];
			list.r[start] = list.r[end];
			list.r[end] = temp2;
		}
		return start;
	}
	/*******************************************************************************/
	
	
}
