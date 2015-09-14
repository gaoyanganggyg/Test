package com.sort.test.sort;
/**
 * 希尔排序
 * 不稳定 
 * 在O(n*log2^n) 到 O(n^2) 平均为O(n^1.3)
 * 最后步长一定为1
 * @author Administrator
 *
 */
public class ShellSort {
	static int[] array;
	public static void main(String[] args) {
		array = ArryToBeSorted.getArray();
		shell_sort();
		for (int  num : array) {
			System.out.println(num);
		}
	}
	
	static void shell_sort(){
		for(int dk = array.length / 2; dk >= 1; dk /= 2){
			for(int i = dk; i < array.length; i++){
				if(array[i] < array[i - dk]){
					int temp = array[i];
					int j = i - dk;
					while(j >= 0 && array[j] > temp){
						array[j + dk] = array[j];
						j -= dk;
					}
					array[j + dk] = temp;
				}
			}
		}
	}
	
}
