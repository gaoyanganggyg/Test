package com.sort.test;

import java.util.Comparator;
/**
 * 冒泡排序
 * @author Administrator
 *
 */
public class BubbleSort implements Sorter {
	@Override
	public <T> void sort(Comparator<T> comparable, T[] list) {
		for(int i = 0; i < list.length; i++){
			for(int j = i; j < list.length; j++){
				if(comparable.compare(list[i], list[j]) > 0){
					T temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i; j < list.length; j++) {
				if(list[i].compareTo(list[j]) > 0){
					T temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
}
