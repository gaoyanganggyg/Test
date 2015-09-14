package com.sort.test.sort;
/**
 * 直接插入排序 O(n^2)
 * 适合顺序存储的线性表，也适用于链式存储结构的线性表
 * @author Administrator
 *
 */
public class InsertSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		//insert_sort();
		insert_sort1();
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	//有哨兵
	static void insert_sort(){
		for(int i = 2; i < array.length; i++){
			if(array[i] < array[i - 1]){
				array[0] = array[i];
				int j = i - 1;
				while(array[j] > array[0]){
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = array[0];
			}
		}
	}
	
	static void insert_sort1(){
		for(int i = 1; i < array.length; i++){
			if(array[i - 1] > array[i]){
				int temp = array[i];
				int j  = i - 1;
				while(j >= 0 && array[j] > temp){
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = temp;
			}
		}
	}
}
